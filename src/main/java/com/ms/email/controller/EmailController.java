package com.ms.email.controller;

import com.ms.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
  @Autowired
  private final EmailService emailService;

  public EmailController(EmailService emailService) {
    this.emailService = emailService;
  }
}
