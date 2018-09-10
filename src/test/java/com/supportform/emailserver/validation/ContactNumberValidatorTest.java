package com.supportform.emailserver.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.*;
import javax.validation.constraints.AssertTrue;
import java.util.Set;

public class ContactNumberValidatorTest {

  private ContactNumberValidator contactNumberValidator;
  private ValidatorFactory validatorFactory;
  private Validator validator;

  private String validContact1 = "(123)456-7890";
  private String validContact2 = "1234567890";
  private String validContact3 = "123-456-7890";

  private String inValidContact1 = "(123)456-78903";
  private String inValidContact2 = "(023)456-7890"; //TODO reject the contacts numbers that start with 0
  @Before
  public void setup() {
    validatorFactory = Validation.buildDefaultValidatorFactory();
    validator = validatorFactory.getValidator();
    contactNumberValidator = new ContactNumberValidator();
  }

  @Test
  public void ContactNumber_IsValid() {
    Assert. assertTrue(contactNumberValidator.isValid(validContact1, constraintValidatorContext()));
    Assert. assertTrue(contactNumberValidator.isValid(validContact2, constraintValidatorContext()));
    Assert. assertTrue(contactNumberValidator.isValid(validContact3, constraintValidatorContext()));
  }

  @Test
  public void ContactNumber_IsInvalid() {
    Assert. assertFalse(contactNumberValidator.isValid(inValidContact1, constraintValidatorContext()));
  }

  public ConstraintValidatorContext constraintValidatorContext() {

    return new ConstraintValidatorContext() {
      @Override
      public void disableDefaultConstraintViolation() {

      }

      @Override
      public String getDefaultConstraintMessageTemplate() {
        return null;
      }

      @Override
      public ClockProvider getClockProvider() {
        return null;
      }

      @Override
      public ConstraintViolationBuilder buildConstraintViolationWithTemplate(String messageTemplate) {
        return null;
      }

      @Override
      public <T> T unwrap(Class<T> type) {
        return null;
      }
    };
  }
}
