package com.phonebook.testsRA;

import com.phonebook.AllContactsDto;
import com.phonebook.ContactDto;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllContactsTest extends TestBase{
    @Test
    public void getAllContactsPositiveTest(){
        AllContactsDto contactsDto = given()
                .header(AUTH, TOKEN)
                .when()
                .get("contacts")
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(AllContactsDto.class);
        for(ContactDto contact: contactsDto.getContacts()){
            System.out.println(contact.getId() + "999999999999" + contact.getName());
            System.out.println("======================================================");
        }
    }
    //TODO: написать тест на получение всех контактов с неверным токеном
}
