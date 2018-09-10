package com.supportform.emailserver.util;

import com.supportform.emailserver.domain.SupportForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailUtilImpl implements EmailUtil {

  JavaMailSenderImpl mailSender;

  @Autowired
  public EmailUtilImpl(JavaMailSenderImpl mailSender) {
    this.mailSender = mailSender;
  }

  @Override
  public void sendSimpleEmail(String requestorEmail) {
    SimpleMailMessage message =  new SimpleMailMessage();
    message.setTo(requestorEmail);
    message.setFrom("springtest02@gmail.com");
    message.setSubject("Confirmation Email");

    mailSender.send(message);
  }

  @Override
  public void sendEmailWithAttachment(SupportForm supportForm) {

    MimeMessage message = mailSender.createMimeMessage();

    try {
      MimeMessageHelper helper = new MimeMessageHelper(message, true);
      helper.setFrom(supportForm.getEmail());
      helper.setTo("snoop_suzan@yahoo.com");
      helper.setSubject("TEST");
      helper.setText(supportForm.getMessage());

      System.out.println(supportForm.getAttachment().getName());
      FileSystemResource file = new FileSystemResource(new File(supportForm.getAttachment().getPath()));
      helper.addAttachment("some file", supportForm.getAttachment());

      mailSender.send(message);

    } catch (MessagingException e) {
      e.printStackTrace();
    }

  }
}
