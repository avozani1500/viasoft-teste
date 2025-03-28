package com.application.viasoft.domain.service;

import com.application.viasoft.security.EmailDTOFactory;
import com.application.viasoft.domain.dto.InputObjectDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    private final EmailDTOFactory emailDTOFactory;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public EmailService(EmailDTOFactory emailDTOFactory) {
        this.emailDTOFactory = emailDTOFactory;
    }

    public void sendEmail(InputObjectDTO inputObjectDTO) throws IOException {
        Object adaptedDto = emailDTOFactory.adaptDto(inputObjectDTO);

        String serializedObject = objectMapper.writeValueAsString(adaptedDto);

        System.out.println("Objeto adaptado e serializado:");
        System.out.println(serializedObject);
    }
}
