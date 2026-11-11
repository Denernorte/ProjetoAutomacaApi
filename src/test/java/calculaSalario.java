import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class calculaSalario {

    @Test
    public void testeSalario(){

        String pathParamSalario = "5000";
        String url = "http://localhost:8080/exercicios/calculaSalario/"+pathParamSalario;


        RestAssured.given()
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                //.body(Matchers.containsString(msgResponseBody));
                .body(Matchers.containsString("Salário bruto = 5000 . 0,  Salário líquido = 3794 . 3599999999997,  INSS = 700 . 0000000000001,  Imposto de Renda = 505 . 64  "));

    }
}
