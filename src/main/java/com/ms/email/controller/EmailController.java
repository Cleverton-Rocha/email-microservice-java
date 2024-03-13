package com.ms.email.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.email.domain.Email;
import com.ms.email.dto.EmailDTO;
import com.ms.email.model.StatusEmail;
import com.ms.email.service.EmailService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mail")
public class EmailController {
  @Autowired
  EmailService emailService;

  @PostMapping("/send")
  public ResponseEntity<StatusEmail> sendEmail(@RequestBody @Valid EmailDTO emailDTO) {
    Email email = new Email();
    BeanUtils.copyProperties(emailDTO, email);
    emailService.sendMail(email);
    return new ResponseEntity<>(email.getStatusEmail(), HttpStatus.CREATED);
  }
}
