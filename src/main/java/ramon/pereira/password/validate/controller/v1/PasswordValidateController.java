package ramon.pereira.password.validate.controller.v1;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ramon.pereira.password.validate.controller.v1.dtos.PasswordValidateRequestDTO;
import ramon.pereira.password.validate.controller.v1.dtos.PasswordValidateResponseDTO;
import ramon.pereira.password.validate.controller.v1.mapper.PasswordValidateMapper;
import ramon.pereira.password.validate.service.PasswordValidateService;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/validatepassword")
@AllArgsConstructor
public class PasswordValidateController {

  private final PasswordValidateService passwordValidateService;

  @PostMapping
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
