package com.application.viasoft.domain.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class EmailAwsDTO implements Serializable {

    private String recipient;
    private String recipientName;

    private String sender;

    private String subject;
    private String content;

}
