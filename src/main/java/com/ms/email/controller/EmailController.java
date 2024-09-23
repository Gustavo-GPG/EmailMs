package com.ms.email.controller;

import com.ms.email.dtos.EmailDto;
import com.ms.email.model.EmailModel;
import com.ms.email.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller para emails.
 */
@RestController
public class EmailController {
  @Autowired
  private final EmailService emailService;

  /**
   * Método construtor de um EmailController.
   *
   * @param emailService the email service
   */
  public EmailController(EmailService emailService) {
    this.emailService = emailService;
  }

  /**
   * Enviar email response entity.
   *
   * @param emailDto dto de email
   * @return retorna uma ResponseEntity com o email enviado
   */
  @PostMapping("/sending-email")
  public ResponseEntity<EmailModel> enviarEmail(@RequestBody @Valid EmailDto emailDto) {
    EmailModel emailModel = emailService.enviarEmail(emailDto);
    return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
  }
}
