package com.phonebook.testsRA;

import com.phonebook.AuthRequestDto;
import com.phonebook.AuthResponseDto;
import com.phonebook.ErrorDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class LoginTestRA extends TestBase {
    // Вызываем класс AuthRequestDto
    AuthRequestDto auth = AuthRequestDto.builder() // экземпляр объекта класса для представления данных авторизации, таких как логин и пароль, которые будут отправлены на сервер для выполнения аутентификации
            .username("admin@gmail.com") // Логин
            .password("Qwertyuiop$1") // Пароль
            .build();

    //Пишем тест
    @Test
    public void loginSuccessTest() {
        // Отправляем запрос на сервер
        AuthResponseDto dto = given()
                .contentType(ContentType.JSON) // Указываем тип контента
                .body(auth) // Передаем данные авторизации
                .when() // Условие, что делаем когда отправляем запрос
                .post("/user/login/usernamepassword") // Отправляем POST запрос на сервер без V1
                .then() // Условие, что делаем когда получаем ответ
                .assertThat().statusCode(200)// Проверяем что код ответа 200
                .extract().response().as(AuthResponseDto.class); //!  ВНИМАНИЕ! Именно AuthResponseDto.class а не AuthRequestDto.class
        System.out.println(dto); // Выводим ответ с Токеном в консоль
    }

    @Test
    public void loginSuccessTest2() {
        String responseToken = given() // имя переменной должно быть говорящее
                .contentType("application/json")
                .body(auth)
                .post("user/login/usernamepassword")
                .then()
                .assertThat().statusCode(200)
                //! по эту строку копируем с предидущего теста только меняем имя переменной
                .body(containsString("token")) // Проверяем что в ответе есть токен
                .extract().path("token"); // Извлекаем токен из ответа сервера
        System.out.println(responseToken); // Выводим токен в консоль
    }

    @Test
    public void loginWithWrongPasswordTest() {
        ErrorDto errorDto = given().body(AuthRequestDto.builder()
                        .username("wrong@email.com") //! Логин исправляем на неверный
                        .password("Qwertyuiop$1")
                        .build())
                .when()
                .post("user/login/usernamepassword") //! Не забываем указать эндпоинт куда отправляем запрос к контроллеру
                .then()
                .assertThat().statusCode(401)
                .body(containsString("Login or Password incorrect"))
                .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getMessage());
        System.out.println(errorDto.getError());
    }

    @Test
    public void loginWithWrongPasswordTest2() { // !  Давайте теперь создадим ассерты поскольку мы видим какие тут стринги возвращаются
        given().body(AuthRequestDto.builder()
                        .username("wrong@email.com") //! Логин исправляем на неверный
                        .password("Qwertyuiop$1")
                        .build())
                .when()
                .post("user/login/usernamepassword")
                .then()
                .assertThat().statusCode(401) //! Проверяем что код ответа 401
                .assertThat().body("message", equalTo("Login or Password incorrect")); //! Проверяем что в ответе есть сообщение об ошибке
    }
}
