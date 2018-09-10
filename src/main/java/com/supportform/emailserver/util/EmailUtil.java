package com.supportform.emailserver.util;

import com.supportform.emailserver.domain.SupportForm;

public interface EmailUtil {
  void sendSimpleEmail(String requestorEmail);
  void sendEmailWithAttachment(SupportForm supportForm);
}
