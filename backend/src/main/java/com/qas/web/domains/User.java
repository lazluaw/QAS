package com.qas.web.domains;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Data
@Component
@Lazy
public class User {
    private Integer userIdx;
    private String userId;
    private String userPassword;
    private String userEmail;
    private int status;
    private Timestamp insertDate;
    private Timestamp updateDate;
}