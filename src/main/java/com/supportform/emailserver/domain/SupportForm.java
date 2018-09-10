package com.supportform.emailserver.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Email;
import java.io.File;
import java.math.BigInteger;

public class SupportForm {

  private String name;
  private BigInteger contact;
  @Email
  private String email;
  private String position;
  private String department;
  private String roomNumber;
  private String location;
  private String message;
  private boolean urgent;
  private File attachment;

  public SupportForm(String name, BigInteger contact, String email, String position, String department, String roomNumber, String location, String message, boolean urgent, File attachment) {
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

  public SupportForm() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigInteger getContact() {
    return contact;
  }

  public void setContact(BigInteger contact) {
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

  public boolean isUrgent() {
    return urgent;
  }

  public void setUrgent(boolean urgent) {
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
