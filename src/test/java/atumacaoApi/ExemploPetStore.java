package atumacaoApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

public class ExemploPetStore {
    @Test
    public void adicionarNovoUsuario(){
        String bodyUser = "[\n" +
                          "  {\n" +
                          "    \"id\": 0,\n" +
                          "    \"username\": \"Dener\",\n" +
                          "    \"firstName\": \"Norte\",\n" +
                          "    \"lastName\": \"QA\",\n" +
                          "    \"email\": \"pwsilima@gmail.com\",\n" +
                          "    \"password\": \"123456\",\n" +
                          "    \"phone\": \"619983595\",\n" +
                          "    \"userStatus\": 1\n" +
                          "  }\n" +
                          "]";


        String url = "https://petstore.swagger.io/v2/user/createWithList";

        RestAssured.given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(bodyUser)
                .when()
                .post(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON);
        }
}
