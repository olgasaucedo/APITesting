package petStore;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import schemas.Entity;
import schemas.Pet;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class PetTest {

    final private String baseURI = "http://localhost:8080/api/v3/pet/";

    @Test(groups = "smoke")
    public void updatePet() {
        String name = "Gato";
        String status = "pending";
        Entity category = new Entity(1, "string");
        List<String> photoURLs = new ArrayList<>();
        photoURLs.add("photoURL1");
        List<Entity> tags = new ArrayList<>();
        Pet pet = new Pet(11, name, category, photoURLs, tags, status);

        given().baseUri(baseURI)
                .contentType(ContentType.JSON)
                .body(pet)
        .when().put()
        .then().statusCode(200)
                .body("name", equalTo(name))
                .body("status", equalTo(status));
    }

    @Test(groups = "smoke")
    public void addPet() {
        Integer id = 11;
        String name = "Kitty";
        Entity category = new Entity(1, "string");
        List<String> photoURLs = new ArrayList<>();
        photoURLs.add("photoURL1");
        List<Entity> tags = new ArrayList<>();
        Pet pet = new Pet(id, name, category, photoURLs, tags, "available");

        given().baseUri(baseURI)
                .contentType(ContentType.JSON)
                .body(pet)
        .when().post()
        .then().statusCode(200)
                .body("id", equalTo(id))
                .body("name", equalTo(name));
    }

    @Test(groups = "smoke")
    public void findByStatus() {
        given().baseUri(baseURI)
                .basePath("/findByStatus")
                .params("status", "available")
        .when().get()
        .then().statusCode(200);
    }

    @Test
    public void findByStatusInvalidValue() {
        given().baseUri(baseURI)
                .basePath("/findByStatus")
                .params("status", 3)
        .when().get()
        .then().statusCode(400);
    }


    @Test(groups = "smoke")
    public void findByTags() {
        given().baseUri(baseURI)
                .basePath("/findByTags")
                .params("tags", "cat")
        .when().get()
        .then().statusCode(200);
    }


    @Test(groups = "smoke")
    public void getPet() {
        given().baseUri(baseURI)
                .basePath("{petId}")
                .pathParams("petId", 11)
        .when().get()
        .then().statusCode(200);
    }

    @Test
    public void getPetInvalidID() {
        given().baseUri(baseURI)
                .basePath("{petId}")
                .pathParams("petId", "pet")
        .when().get()
        .then().statusCode(400);
    }

    @Test
    public void getPetNotFound() {
        given().baseUri(baseURI)
                .basePath("{petId}")
                .pathParam("petId", 15)
        .when().get()
        .then().statusCode(404);
    }

    @Test(groups = "smoke")
    public void updatePetWithFormData() {
        String name = "Kitty";
        given().baseUri(baseURI)
                .basePath("{petId}")
                .pathParam("petId", "11")
                .queryParam("name", name)
        .when().post()
        .then().statusCode(200)
                .body("name", equalTo(name));
    }

    @Test
    public void deletePet() {
        given().baseUri(baseURI)
                .basePath("{petId}")
                .pathParam("petId", "16")
        .when().delete()
        .then().statusCode(200);
    }
}
