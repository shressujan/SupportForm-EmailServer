package com.supportform.emailserver.service;

import com.supportform.emailserver.domain.SupportFormDAO;

import javax.validation.constraints.Email;

public interface SupportFormService {

  void sendSupportEmail(SupportFormDAO supportFormDAO);
  void sendConfirmationEmail(String requestorEmail);
}
