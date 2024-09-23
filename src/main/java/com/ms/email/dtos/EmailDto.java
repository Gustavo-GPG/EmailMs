package com.ms.email.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Email data transfer object.
 */
@Data
public class EmailDto {

  @NotBlank
  private String propietarioDoEmail;
  @NotBlank
  private String remetente;
  @NotBlank
  @Email
  private String destinatario;
  @NotBlank
  private String titulo;
  @NotBlank
  private String texto;
}
