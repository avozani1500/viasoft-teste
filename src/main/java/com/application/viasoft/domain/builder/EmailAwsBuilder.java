package com.application.viasoft.domain.builder;

import com.application.viasoft.domain.dto.EmailAwsDTO;
import com.application.viasoft.domain.dto.InputObjectDTO;
import org.springframework.stereotype.Component;

@Component
public class EmailAwsBuilder {

    public EmailAwsDTO fromInputEmail(InputObjectDTO inputObjectDTO) {
        EmailAwsDTO emailAwsDTO = new EmailAwsDTO();
        emailAwsDTO.setRecipient(inputObjectDTO.getDestinatario());
        emailAwsDTO.setRecipientName(inputObjectDTO.getNomeDestinatario());
        emailAwsDTO.setSender(inputObjectDTO.getRemetente());
        emailAwsDTO.setSubject(inputObjectDTO.getAssunto());
        emailAwsDTO.setContent(inputObjectDTO.getConteudo());
        return emailAwsDTO;
    }
}
