package ramon.pereira.password.validate.controller.v1;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import ramon.pereira.password.validate.controller.v1.dtos.PasswordValidateRequestDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class PasswordValidateControllerIntegrationTest {

  private String passwordValidateEndpoint = "/v1/validatepassword";

  @LocalServerPort
  private int port;

  @BeforeEach
  void setUp() {
    baseURI = "http://localhost";
    port = port;
  }

  @Test
  void postPasswordValidateWithPasswordNullExpectedBadRequest() {
    final var requestDTO =
        PasswordValidateRequestDTO.builder()
            .password(null)
            .build();

    given().
        header("Content-Type", "application/json").
        body(requestDTO).
        when().
        post(passwordValidateEndpoint).
        then().
        statusCode(400);
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "aa", "ab", "AAAbbbCc", "AbTp9!foo", "AbTp9!foA", "AbTp9 fok"})
  void postPasswordValidateWithPasswordExpected200OkReturnValidFalse(String password) {
    final var requestDTO =
        PasswordValidateRequestDTO.builder()
            .password(password)
            .build();

    given().
        header("Content-Type", "application/json").
        body(requestDTO).
        when().
        post(passwordValidateEndpoint).
        then().
        statusCode(200).
        body("valid", equalTo(false));
  }

  @ParameterizedTest
  @ValueSource(strings = {"AbTp9!fok", "abTp9!fok", "abTp9&fok"})
  void postPasswordValidateWithPasswordExpected200OkReturnValidTrue(String password) {
    final var requestDTO =
        PasswordValidateRequestDTO.builder()
            .password(password)
            .build();

    given().
        header("Content-Type", "application/json").
        body(requestDTO).
        when().
        post(passwordValidateEndpoint).
        then().
        statusCode(200).
        body("valid", equalTo(true));
  }
}
