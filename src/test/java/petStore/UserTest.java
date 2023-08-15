package petStore;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import schemas.User;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;


public class UserTest {

    final private String baseURI = "http://localhost:8080/api/v3/user/";

    @Test(groups = "smoke")
    public void createUser() {

       String username = "user11";
       String firstName = "First Name 11";
       String lastName = "Last Name 11";
       User user = new User("11", username, firstName, lastName,
               "email11", "password", "12345", "1");

       given().baseUri(baseURI)
                .contentType(ContentType.JSON)
                .body(user)
       .when().post()
       .then().statusCode(200)
               .body("username", equalTo(username))
               .body("firstName", equalTo(firstName))
               .body("lastName", equalTo(lastName));
    }

    @Test
    public void createUserWithList() {
        String username = "theUser";
        String firstName = "John";
        String lastName = "James";
        User user = new User("10", "theUser", "John", "James",
                "john@email.com", "12345", "12345", "1");
        List<User> users = new ArrayList<>();
        users.add(user);

        given().baseUri(baseURI)
                .basePath("createWithList")
                .contentType(ContentType.JSON)
                .body(users)
        .when().post()
        .then().log().all().statusCode(200)
                .body("username", hasItem(username))
                .body("firstName", hasItem(firstName))
                .body("lastName", hasItem(lastName));
    }

    @Test(groups = "smoke")
    public void login() {
        given().baseUri(baseURI)
               .basePath("login")
               .queryParam("username", "admin")
               .queryParam("password", "admin")
        .when().get()
        .then().statusCode(200);
    }


    @Test(groups = "smoke")
    public void logout() {
        given().baseUri(baseURI)
                .basePath("logout")
        .when()
                .get()
        .then().log().all()
                .statusCode(200);
        }

    @Test(groups = "smoke")
    public void getUser() {
        given().baseUri(baseURI)
                .basePath("{username}")
                .pathParam("username", "user1")
        .when()
                .get()
        .then().statusCode(200);
    }

    @Test
    public void getUserNotFound() {
        given().baseUri(baseURI)
                .basePath("{username}")
                .pathParam("username", "user20")
        .when().get()
        .then().statusCode(404);
    }

    @Test(groups = "smoke")
    public void updateUser() {

        String username = "user8";
        String firstName = "John Updated";
        String lastName = "James Updated";
        User user = new User("10", username, firstName, lastName,
                "john@email.com", "12345", "12345", "1");

        given().baseUri(baseURI)
                .basePath("{username}")
                .pathParam("username", "user2")
                .contentType(ContentType.JSON)
                .body(user)
        .when().put()
        .then().statusCode(200)
                .body("username", equalTo(username))
                .body("firstName", equalTo(firstName))
                .body("lastName", equalTo(lastName));
    }

    @Test(groups = "smoke")
    public void deleteUser() {
        given().baseUri(baseURI)
                .basePath("{username}")
                .pathParam("username", "theUser")
        .when().delete()
        .then().statusCode(200);
    }
}
