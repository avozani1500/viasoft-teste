package com.application.viasoft.controller;

import com.application.viasoft.domain.dto.InputObjectDTO;
import com.application.viasoft.domain.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller responsável pelo gerenciamento da requisição
 * e tambem utiliza o {@link EmailService} para processar as requisições de envio de email
 */
@RestController
@RequestMapping("/email-sender")
public class EmailSenderController {

    private final EmailService emailService;

    public EmailSenderController(EmailService emailService) {
        this.emailService = emailService;
    }

    /**
     * endpoint pra enviar o email,
     * recebe o json e envia pro service {@link EmailService}.
     *
     * @param email DTO dos dados fornecidos
     */
    @PostMapping("/send")
    public ResponseEntity<Void> send(@RequestBody InputObjectDTO email) {
        try {
            emailService.sendEmail(email);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
