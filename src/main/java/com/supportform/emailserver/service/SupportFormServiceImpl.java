package com.supportform.emailserver.service;

import com.supportform.emailserver.domain.SupportForm;
import com.supportform.emailserver.domain.SupportFormDAO;
import com.supportform.emailserver.util.EmailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Arrays;

@Service
public class SupportFormServiceImpl implements SupportFormService {

  private EmailUtil emailUtil;

  @Autowired
  public SupportFormServiceImpl(EmailUtil emailUtil) {
    this.emailUtil = emailUtil;
  }

  private Logger logger = LoggerFactory.getLogger(SupportFormServiceImpl.class);

  @Override
  public void sendSupportEmail(SupportFormDAO supportFormDAO) {
    SupportForm supportForm = new SupportForm();
    supportForm.setName(supportFormDAO.getName());
    supportForm.setContact(getContactNumber(supportFormDAO.getContact()));
    supportForm.setEmail(supportFormDAO.getEmail());
    supportForm.setDepartment(supportFormDAO.getDepartment());
    supportForm.setPosition(supportFormDAO.getPosition());
    supportForm.setLocation(supportFormDAO.getLocation());
    supportForm.setRoomNumber(supportFormDAO.getRoomNumber());
    supportForm.setMessage(supportFormDAO.getMessage());
    supportForm.setUrgent(isUrgentBoolean(supportFormDAO.isUrgent()));
//    supportForm.setAttachment(supportFormDAO.getAttachment());

    logger.info("Attempting to send the support Form: {} to Support Group", supportForm);
    emailUtil.sendSimpleEmail(supportForm);
    logger.info("SupportForm sent Support Group!!");

  }

  @Override
  public void sendConfirmationEmail(String requestorEmail) {
    logger.info("Attempting to send the Confirmation email to the user with email: {}", requestorEmail);
    emailUtil.sendConfirmationEmail(requestorEmail);
    logger.info("Confirmation email sent to the user with email", requestorEmail);
  }

  public boolean isUrgentBoolean(String isUrgent) {
    if(isUrgent.equalsIgnoreCase("true")) {
      return true;
    }
    return false;
  }

  public BigInteger getContactNumber(String contact) {
    String[] contactSplittedArray = contact.split("[\\(\\)-]");
    if(contactSplittedArray.length > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      Arrays.stream(contactSplittedArray).forEach(splittedString -> stringBuilder.append(splittedString));
      return new BigInteger(String.valueOf(stringBuilder));
    }
    return new BigInteger(contact);
  }
}
