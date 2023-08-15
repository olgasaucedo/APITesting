package petStore;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import schemas.Order;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class StoreTest {

    final private String baseURI = "http://localhost:8080/api/v3/store/";

    @Test
    public void getInventory() {
        given().baseUri(baseURI)
                .basePath("inventory")
        .when().get()
        .then().log().all().statusCode(200);
    }

    @Test(groups = "smoke")
    public void postOrder() {

        Order order = new Order(20, 11, 7);

        given().baseUri(baseURI)
                .basePath("order")
                .body(order)
                .contentType(ContentType.JSON)
        .when().post()
        .then().statusCode(200)
                .body("complete", equalTo(false));
    }
    @Test(groups = "smoke")
    public void getOrder() {
        given().baseUri(baseURI)
                .basePath("order/{orderId}")
                .pathParams("orderId", 1)
        .when().get()
        .then().statusCode(200);
    }

    @Test
    public void getOrderNotFound() {
        given().baseUri(baseURI)
                .basePath("order/{orderId}")
                .pathParams("orderId", 20)
        .when().get()
        .then().statusCode(404);
    }

    @Test
    public void getOrderInvalidInput() {
        given().baseUri(baseURI)
                .basePath("order/{orderId}")
                .pathParams("orderId", "String")
        .when().get()
        .then().statusCode(400);
    }

    @Test
    public void deleteOrder() {
        given().baseUri(baseURI)
                .basePath("order/{orderId}")
                .pathParams("orderId", 20)
        .when().delete()
        .then().statusCode(200);
    }
}
