package com.supportform.emailserver.controller;

import com.supportform.emailserver.domain.SupportFormDAO;
import com.supportform.emailserver.service.SupportFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class SupportFormController {

  private SupportFormService supportFormService;

  @Autowired
  public SupportFormController(SupportFormService supportFormService) {
    this.supportFormService = supportFormService;
  }

  @GetMapping("/supportForm")
  public String supportForm() {
    return "supportForm";
  }

  @PostMapping("/supportForm")
  @ResponseBody
  public String supportFormSubmit(@ModelAttribute SupportFormDAO supportFormDAO) {
    System.out.println("here");
    supportFormService.sendSupportEmail(supportFormDAO);
    supportFormService.sendConfirmationEmail(supportFormDAO.getEmail());
    return  "You Issue has been Submitted";
  }
}
