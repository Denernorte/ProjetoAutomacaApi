import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class validaCpf {

    @Test
    public void validaCpf(){


        String url = "http://localhost:8080/exercicios/validarCpf/";
        String cpf = "15022627035";

        RestAssured.given()
                .queryParam("cpf", cpf)
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                //.body(Matchers.containsString(msgResponseBody));
                .body(Matchers.equalTo("CPF Valido"));

    }
}
