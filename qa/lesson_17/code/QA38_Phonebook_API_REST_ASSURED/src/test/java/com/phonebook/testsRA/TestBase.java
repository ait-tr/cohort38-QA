package com.phonebook.testsRA;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {
  public static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiYWRtaW5AZ21haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE3MTU5NjY4ODgsImlhdCI6MTcxNTM2Njg4OH0.J2-_LX0w8iJYXdkOBupeqb2_sDJrqsojKHf0NQQzj1U"; // Финальная переменная, которая хранит токен для авторизации
  public static final String AUTH = "Authorization"; // Просто переменная для слова Authorization

  @BeforeMethod
    public void init(){
      RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com"; // Переменная для домена свагера
      RestAssured.basePath = "v1"; // Переменная пути которая часто повторяется
  }
}
