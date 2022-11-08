package api.actions;

import WebUI.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;

import static io.restassured.RestAssured.given;

public class CardActions {


    public String createCard(String idList) {

        RestAssured.baseURI = "https://api.trello.com/1";

        Response response = given()
                .contentType("application/json")
                .queryParam("name", RandomStringUtils.randomAlphabetic(10))
                .queryParam("idList", idList)
                .queryParam("keepFromSource", "all")
                .queryParam("key", ConfigReader.getProperties("ApiKey"))
                .queryParam("token", ConfigReader.getProperties("ApiToken"))
                .when().post("/cards/");

        response.then().statusCode(200);
        return response.jsonPath().getString("id");
    }

    public void updateCard(String cardId, String name) {

        RestAssured.baseURI = "https://api.trello.com/1";

        Response response = given()
                .contentType("application/json")
                .queryParam("name", name)
                .queryParam("desc", "test description")
                .queryParam("key", ConfigReader.getProperties("ApiKey"))
                .queryParam("token", ConfigReader.getProperties("ApiToken"))
                .when().put("/cards/" + cardId);

        response.then().statusCode(200);

    }

    public void deleteCard(String cardId) {

        RestAssured.baseURI = "https://api.trello.com/1";

        Response response = given()
                .contentType("application/json")
                .queryParam("key", ConfigReader.getProperties("ApiKey"))
                .queryParam("token", ConfigReader.getProperties("ApiToken"))
                .when().delete("/cards/" + cardId);

        response.then().statusCode(200);

    }


}
