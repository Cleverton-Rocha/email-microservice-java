package com.ms.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms.email.domain.Email;
import com.ms.email.model.StatusEmail;

@Service
public class EmailService {
  @Autowired
  private JavaMailSender mailSender;

  @Value("${spring.mail.username}")
  private String emailFrom;

  public StatusEmail sendMail(Email email) {
    SimpleMailMessage message = new SimpleMailMessage();

    try {
      message.setFrom(emailFrom);
      message.setTo(email.getEmailTo());
      message.setSubject(email.getSubject());
      message.setText(email.getMessage());
      mailSender.send(message);

      email.setStatusEmail(StatusEmail.SENT);
    } catch (Exception exception) {
      email.setStatusEmail(StatusEmail.NOT_SENT);
    }

    return email.getStatusEmail();
  }

}
