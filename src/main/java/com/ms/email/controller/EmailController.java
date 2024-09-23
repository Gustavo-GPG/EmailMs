package com.ms.email.controller;

import com.ms.email.dtos.EmailDto;
import com.ms.email.model.EmailModel;
import com.ms.email.service.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
  @Autowired
  private final EmailService emailService;

  public EmailController(EmailService emailService) {
    this.emailService = emailService;
  }

  @PostMapping("/sending-email")
  public ResponseEntity<EmailModel> enviarEmail(EmailDto emailDto) {
    EmailModel emailModel= new EmailModel();
    BeanUtils.copyProperties(emailDto, emailModel);
    emailService.enviarEmail(emailModel);
    return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
  }
}
