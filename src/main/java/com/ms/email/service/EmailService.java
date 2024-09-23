package com.ms.email.service;

import com.ms.email.model.EmailModel;
import com.ms.email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
  @Autowired
   private final EmailRepository emailRepository;

  public EmailService(EmailRepository emailRepository) {
    this.emailRepository = emailRepository;
  }

  public void enviarEmail(EmailModel emailModel) {
    emailRepository.save(emailModel);

  }
}
