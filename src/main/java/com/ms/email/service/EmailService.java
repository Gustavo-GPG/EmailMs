package com.ms.email.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ms.email.enums.EmailStatus;
import com.ms.email.model.EmailModel;
import com.ms.email.repositories.EmailRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
  @Autowired
   private final EmailRepository emailRepository;

  @Autowired
  private JavaMailSender emailSender;

  public EmailService(EmailRepository emailRepository) {
    this.emailRepository = emailRepository;
  }

  public void enviarEmail(EmailModel emailModel) {

    emailModel.setDataDeEnvio(LocalDateTime.now());

    try {
      SimpleMailMessage menssagem = new SimpleMailMessage();
      menssagem.setFrom(emailModel.getRemetente());
      menssagem.setTo(emailModel.getDestinatario());
      menssagem.setSubject(emailModel.getTitulo());;
      menssagem.setText(emailModel.getTexto());
      emailSender.send(menssagem);

      emailModel.setStatusDoEmail(EmailStatus.ENVIADO);
    } catch (MailException e) {
      emailModel.setStatusDoEmail(EmailStatus.ERROR);
    } finally {
      emailRepository.save(emailModel);
    }

  }
}
