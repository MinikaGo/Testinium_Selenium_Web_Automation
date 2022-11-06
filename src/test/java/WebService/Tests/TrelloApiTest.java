package WebService.Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class TrelloApiTest {

    String ApiKey = "5912b18724fc08c34f64ffdc8f0048f1";
    String ApiToken = "fad6cdb3f83a58e47ce50751c03e3d79b6190e1576126869e63d6b6c5d74a0a7";
    String boardName = "AutomationBoard 3";
    String boardId;
    String listId;
    String cardId1;
    String cardId2;
    Response r;

    @Test
    public void trelloTestCase()  {

        RestAssured.baseURI = "https://api.trello.com/1";

        RequestSpecification h = RestAssured.given().contentType(ContentType.JSON);

        r = h.post("/boards/?name=" + boardName + "&key=" + ApiKey + "&token=" + ApiToken);

        boardId = r.jsonPath().get("id");

        //- Oluşturduğunuz board’ liste oluştur (Ümit S)
        r = h.post("/lists?name=DummyList&idBoard=" + boardId + "&key=" + ApiKey + "&token=" + ApiToken);

        listId = r.jsonPath().get("id");

        //- Oluşturduğunuz board’ a iki tane kart oluşturunuz.
        r = h.post("/cards?idList=" + listId + "&key=" + ApiKey + "&token=" + ApiToken + "&name=FirstCard");

        cardId1 = r.jsonPath().get("id");

        r = h.post("/cards?name=SecondCard&idList=" + listId + "&key=" + ApiKey + "&token=" + ApiToken);

        cardId2 = r.jsonPath().get("id");

//----------------------------------------------------------------

        //- Oluştrduğunuz bu iki karttan random olacak sekilde bir tanesini güncelleyiniz.
        h.put("/cards/" + cardId1 + "?key=" + ApiKey + "&token=" + ApiToken + "&desc=SecondCardNameIsUpdated");


        ///cards/{id}?key=APIKey&token=APIToken
        //        - Oluşturduğunuz kartları siliniz.


        //- Oluşturduğunuz board’ u siliniz.


    }

}
