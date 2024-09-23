package com.ms.email.repositories;

import com.ms.email.model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Contrato de repositório para facilitar consulta ao banco de dados.
 */
public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}
