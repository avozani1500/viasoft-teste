package com.application.viasoft.domain.builder;

import com.application.viasoft.domain.dto.EmailOciDTO;
import com.application.viasoft.domain.dto.InputObjectDTO;
import org.springframework.stereotype.Component;

@Component
public class EmailOciBuilder {

    public EmailOciDTO fromInputEmail(InputObjectDTO inputObjectDTO) {
        EmailOciDTO emailOciDTO = new EmailOciDTO();
        emailOciDTO.setRecipientEmail(inputObjectDTO.getDestinatario());
        emailOciDTO.setRecipientName(inputObjectDTO.getNomeDestinatario());
        emailOciDTO.setSenderEmail(inputObjectDTO.getRemetente());
        emailOciDTO.setSubject(inputObjectDTO.getAssunto());
        emailOciDTO.setBody(inputObjectDTO.getConteudo());
        return emailOciDTO;
    }
}
