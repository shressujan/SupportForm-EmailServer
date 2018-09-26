package com.supportform.emailserver.util;

import com.supportform.emailserver.domain.SupportForm;

public interface EmailUtil {
  void sendSimpleEmail(SupportForm supportForm);
  void sendConfirmationEmail(String requestorEmail);
  void sendEmailWithAttachment(SupportForm supportForm);
}
