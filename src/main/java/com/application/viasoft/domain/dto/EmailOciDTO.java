package com.application.viasoft.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class EmailOciDTO implements Serializable {

    private String recipientEmail;
    private String recipientName;

    private String senderEmail;

    private String subject;
    private String body;

}
