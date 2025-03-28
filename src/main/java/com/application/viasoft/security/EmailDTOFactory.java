package com.application.viasoft.security;


import com.application.viasoft.domain.builder.EmailAwsBuilder;
import com.application.viasoft.domain.builder.EmailOciBuilder;
import com.application.viasoft.domain.dto.InputObjectDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * factory feita pra adaptar objetos DTO de entrada ({@link InputObjectDTO})
 * para DTOs específicos de provedores de e-mail (AWS ou OCI),
 * o tipo é definido pela configuração no application properties.
 */
@Component
public class EmailDTOFactory {

    @Value("${mail.integration}")
    private String emailServiceProvider;

    private final EmailAwsBuilder emailAwsBuilder;
    private final EmailOciBuilder emailOciBuilder;

    public EmailDTOFactory(EmailAwsBuilder emailAwsBuilder, EmailOciBuilder emailOciBuilder) {
        this.emailAwsBuilder = emailAwsBuilder;
        this.emailOciBuilder = emailOciBuilder;
    }

    /**
     * metodo que converte a classe ({@link InputObjectDTO}) pro objeto esperado
     *
     * @param inputObjectDTO dto contendo os dados
     * @return retorna o objeto convertido com base na configuração.
     * @throws IllegalArgumentException Se o provedor de e-mail configurado não for suportado.
     */
    public Object adaptDto(InputObjectDTO inputObjectDTO) {

        if ("AWS".equalsIgnoreCase(emailServiceProvider)) {
            System.out.println("Adaptando AWS");
            return emailAwsBuilder.fromInputEmail(inputObjectDTO);
        } else if ("OCI".equalsIgnoreCase(emailServiceProvider)) {
            System.out.println("Adaptando OCI");
            return emailOciBuilder.fromInputEmail(inputObjectDTO);
        } else {
            throw new IllegalArgumentException("Provedor de e-mail inválido, " +
                    "por favor verifique as configurações: " + emailServiceProvider);
        }
    }
}
