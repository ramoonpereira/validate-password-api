package ramon.pereira.password.validate.controller.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ramon.pereira.password.validate.controller.v1.dtos.PasswordValidateRequestDTO;
import ramon.pereira.password.validate.controller.v1.dtos.PasswordValidateResponseDTO;
import ramon.pereira.password.validate.controller.v1.mapper.PasswordValidateMapper;
import ramon.pereira.password.validate.service.PasswordValidateService;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/validatepassword")
@AllArgsConstructor
@Api(value = "Validate Paswword Api", tags = {"Validate"})
public class PasswordValidateController {

  private final PasswordValidateService passwordValidateService;

  @PostMapping
  @ResponseBody
  @ApiOperation(value = "Valid Password", response = PasswordValidateResponseDTO.class,
      produces = "application/json")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 201, message = "Created"),
      @ApiResponse(code = 400, message = "Bad Request"),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 500, message = "Internal Server Error")})
  public ResponseEntity<PasswordValidateResponseDTO> validadePassword(
      @RequestBody @Valid final PasswordValidateRequestDTO requestDto
  ) {

    final var valid =
        passwordValidateService.validatePassword(PasswordValidateMapper.toModel(requestDto));

    return ResponseEntity.ok(PasswordValidateResponseDTO.builder()
        .valid(valid)
        .build());

  }

}
