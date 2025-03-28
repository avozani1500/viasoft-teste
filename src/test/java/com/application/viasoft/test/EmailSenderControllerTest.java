package com.application.viasoft.test;

import com.application.viasoft.controller.EmailSenderController;
import com.application.viasoft.domain.dto.InputObjectDTO;
import com.application.viasoft.domain.service.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class EmailSenderControllerTest {

    @Mock
    private EmailService emailService;

    @InjectMocks
    private EmailSenderController emailSenderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendEmail_Success() throws IOException {
        // Arrange
        InputObjectDTO email = new InputObjectDTO();
        email.setDestinatario("teste@example.com");
        email.setNomeDestinatario("nati neiti");
        email.setRemetente("testenovamente@example.com");
        email.setAssunto("convite");
        email.setConteudo("bora toma uma coca");

        doNothing().when(emailService).sendEmail(email);

        // Act
        ResponseEntity<Void> response = emailSenderController.send(email);

        // Assert
        assertEquals(204, response.getStatusCodeValue());
        verify(emailService, times(1)).sendEmail(email);
    }

    @Test
    void testSendEmail_Failure() throws IOException {
        // Arrange

        InputObjectDTO email = new InputObjectDTO();
        email.setDestinatario("test@teste.com");
        email.setNomeDestinatario("hehehe");
        email.setRemetente("testednv@teste.com");
        email.setAssunto("subject");
        email.setConteudo("bodyyyyyyyyyyyyy");

        doThrow(new RuntimeException("Error sending email")).when(emailService).sendEmail(email);

        // Act
        ResponseEntity<Void> response = emailSenderController.send(email);

        // Assert
        assertEquals(400, response.getStatusCodeValue());
        verify(emailService, times(1)).sendEmail(email);
    }
}
