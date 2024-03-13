package com.ms.email.domain;

import com.ms.email.model.StatusEmail;

import lombok.Data;

@Data
public class Email {
  private String emailTo;
  private String subject;
  private String message;
  private StatusEmail statusEmail;
}
