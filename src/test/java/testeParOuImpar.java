import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class testeParOuImpar {

    @Test
    public void testeparOuImpar(){

        String url = "http://localhost:8080/exercicios/parOuImpar";
        String msgResponseBody = "O numero 2 é par";

        RestAssured.given()
                .queryParam("numero", 2)
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                //.body(Matchers.containsString(msgResponseBody));
                .body(Matchers.equalTo(msgResponseBody));

    }
}
