package api.actions;

import WebUI.utils.ConfigReader;
import api.objects.Board;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;

import static io.restassured.RestAssured.given;

public class BoardActions {

    public Board createBoard() {

        RestAssured.baseURI = "https://api.trello.com/1";
        RequestSpecification requestSpecification = given()
                .contentType(ContentType.TEXT)
                .contentType("application/json")
                .queryParam("key", ConfigReader.getProperties("ApiKey"))
                .queryParam("token", ConfigReader.getProperties("ApiToken"))
                .queryParam("desc", "test description")
                .queryParam("name", RandomStringUtils.randomAlphabetic(10));
        return requestSpecification.request(Method.POST, "boards").as(Board.class);
    }

    public void removeBoard(String id){
        RestAssured.baseURI = "https://api.trello.com/1";
        RestAssured
                .given()
                .queryParam("key", ConfigReader.getProperties("ApiKey"))
                .queryParam("token", ConfigReader.getProperties("ApiToken"))
                .delete("/boards/" + id);
    }


}
