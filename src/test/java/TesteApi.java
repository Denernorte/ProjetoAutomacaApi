import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class TesteApi {
    String url = "http://localhost:8080/api";
    RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(url).build();

    @Test
    public void testeComSucessoApi(){

        String path = "/primeiraApi";

                        given()
                                .spec(requestSpecification)
                                .log().all()
                        .when()
                                .get(path)
                        .then()
                                .log().all()
                                .assertThat()
                                .statusCode(200)
                        .body(Matchers.containsString("Retorno da api com sucesso!!!"));

    }

    @Test
    public void testeQueryParam(){

        String path = "/primeiraApiV1";
        String textoQueryParam = "Automação";

        given()
                .spec(requestSpecification)
                .queryParam("palavra", "Automação")
                .log().all()
                .when()
                .get(path)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("Automação"));

    }

    @Test
    public void testePathParam(){
        String textPathParam = "textPathParam";
        String path = "/primeiraApiV2/"+textPathParam;

        given()
                .spec(requestSpecification)
                .log().all()
                .when()
                .get(path)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("textPathParam"));

    }



}
