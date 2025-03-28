package com.application.viasoft.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class InputObjectDTO implements Serializable {

    /**
     * Endereço de email do destinatario
     */
    private String destinatario;
    /**
     * Nome do destinatario
     */
    private String nomeDestinatario;

    /**
     * Remetente do email
     */
    private String remetente;

    /**
     * Assunto do email
     */
    private String assunto;
    /**
     * conteudo do emaill
     */
    private String conteudo;

}
