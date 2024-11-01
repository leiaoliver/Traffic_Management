package br.com.fiap.TrafficManagement.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class CadastroRotasSteps {

    private Response response;
    private Map<String, Object> rotaData;

    @Dado("que eu tenha os seguintes dados da rota:")
    public void queEuTenhaOsSeguintesDadosDaRota(Map<String, String> dados) {
        rotaData = new HashMap<>();
        rotaData.put("origem", dados.get("origem"));
        rotaData.put("destino", dados.get("destino"));
        rotaData.put("distancia_km", Double.parseDouble(dados.get("distancia_km")));
        rotaData.put("duracao_minutos", Integer.parseInt(dados.get("duracao_minutos")));
    }

    @Quando("eu enviar a requisição para o endpoint {string} de cadastro de rotas")
    public void euEnviarARequisicaoParaOEndpointDeCadastroDeRotas(String endpoint) {
        response = RestAssured.given()
                .contentType("application/json")
                .body(rotaData)
                .post(endpoint);
    }

    @Então("o status code da resposta deve ser {int}")
    public void oStatusCodeDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Então("o corpo de resposta deve conter o campo {string} com o valor {string}")
    public void oCorpoDeRespostaDeveConterOCampoComOValor(String campo, String valorEsperado) {
        Assert.assertEquals(valorEsperado, response.jsonPath().getString(campo));
    }
}
