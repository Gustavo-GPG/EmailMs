package com.ms.email.model;

import com.ms.email.enums.EmailStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * Representação de uma entidade email.
 */
@Entity
@Data
@Table(name = "TB_EMAIL")
public class EmailModel {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long emailId;

  private String propietarioDoEmail;
  private String remetente;
  private String destinatario;
  private String titulo;

  @Column(columnDefinition = "TEXT")
  private String texto;

  private LocalDateTime dataDeEnvio;
  private EmailStatus statusDoEmail;

}
