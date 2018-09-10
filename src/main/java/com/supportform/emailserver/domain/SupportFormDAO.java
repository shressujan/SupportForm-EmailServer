package com.supportform.emailserver.domain;

import com.supportform.emailserver.validation.ContactNumberConstraint;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Email;
import java.io.File;

public class SupportFormDAO {

  private String name;
  @ContactNumberConstraint
  private String contact;
  @Email
  private String email;
  private String position;
  private String department;
  private String roomNumber;
  private String location;
  private String message;
  private String urgent;
  private File attachment;

  public SupportFormDAO(String name, String contact, String email, String position, String department, String roomNumber, String location, String message, String urgent, File attachment) {
    this.name = name;
    this.contact = contact;
    this.email = email;
    this.position = position;
    this.department = department;
    this.roomNumber = roomNumber;
    this.location = location;
    this.message = message;
    this.urgent = urgent;
    this.attachment = attachment;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String isUrgent() {
    return urgent;
  }

  public void setUrgent(String  urgent) {
    this.urgent = urgent;
  }

  public File getAttachment() {
    return attachment;
  }

  public void setAttachment(File attachment) {
    this.attachment = attachment;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}

