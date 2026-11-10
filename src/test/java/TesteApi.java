import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;

public class TesteApi {
    @Test
        public void testName() {
                
        }

    @Test
    public void testeComSucessoApi(){

        String url = "http://localhost:8080/api/primeiraApi";
                RestAssured.given()
                                .log().all()
                        .when()
                                .get(url)
                        .then()
                                .log().all()
                                .assertThat()
                                .statusCode(200)
                        .body(Matchers.containsString("Retorno da api com sucesso!!!"));

    }
}
