package api.actions;

import WebUI.utils.ConfigReader;
import api.objects.ListBoard;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ListActions {

    public List<ListBoard> getBoardLists(String idBoard){

        RestAssured.baseURI = "https://api.trello.com/1";

        RequestSpecification requestSpecification = given()
                .queryParam("key", ConfigReader.getProperties("ApiKey"))
                .queryParam("token", ConfigReader.getProperties("ApiToken"));
        return requestSpecification.request(Method.GET, "/boards/" + idBoard + "/lists").as(new TypeRef<List<ListBoard>>(){});
    }

}
