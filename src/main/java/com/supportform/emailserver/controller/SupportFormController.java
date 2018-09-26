package com.supportform.emailserver.controller;

import com.supportform.emailserver.domain.SupportFormDAO;
import com.supportform.emailserver.service.SupportFormService;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

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
  public String supportFormSubmit(SupportFormDAO supportFormDAO) {

    supportFormService.sendSupportEmail(supportFormDAO);
    supportFormService.sendConfirmationEmail(supportFormDAO.getEmail());
    return  "You Issue has been Submitted";
  }

/*
  @GetMapping("/test")
  public String test() {
    return "test";
  }

  @PostMapping("/test")
  public String testSubmit(MultipartFile file) {
    System.out.printf("\n\n***Filename: %s",file.getOriginalFilename());
    return null;
  }*/
}
