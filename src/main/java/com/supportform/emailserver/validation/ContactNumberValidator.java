package com.supportform.emailserver.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactNumberValidator implements ConstraintValidator<ContactNumberConstraint, String> {

  private String contactNumberFormattedRegex = "\\((\\d{3})\\)(\\d{3})-(\\d{4})";
  private String contactNumberNotFormattedRegex = "(\\d{10})";
  private String contactNumberFormattedWithDashesRegex = "(\\d{3})-(\\d{3})-(\\d{4})";

  private Pattern pattern;
  private Matcher matcher;
  @Override
  public void initialize(ContactNumberConstraint constraintAnnotation) {

  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    boolean valid = false;
    valid |= matchesContactNumberFormattedRegex(value, context);
    valid |= matchesContactNumberNotFormattedRegex(value, context);
    valid |= matchesContactNumberFormattedWithDashesRegex(value, context);

    return valid;
  }

  private boolean matchesContactNumberFormattedRegex(String value, ConstraintValidatorContext context) {
    pattern = Pattern.compile(contactNumberFormattedRegex);
    matcher = pattern.matcher(value);
    if(!(matcher.matches() && value.length() == 13)) {
      context.buildConstraintViolationWithTemplate("Contact Info Invalid!!");
      return false;
    }
    return matcher.matches();
  }

  private boolean matchesContactNumberNotFormattedRegex(String value, ConstraintValidatorContext context) {
    pattern = Pattern.compile(contactNumberNotFormattedRegex);
    matcher = pattern.matcher(value);

    if(!(matcher.matches() && value.length() == 10)) {
      context.buildConstraintViolationWithTemplate("Contact Info Invalid!!");
      return false;
    }
    return true;
  }

  private boolean matchesContactNumberFormattedWithDashesRegex(String value, ConstraintValidatorContext context) {
    pattern = Pattern.compile(contactNumberFormattedWithDashesRegex);
    matcher = pattern.matcher(value);

    if(!(matcher.matches() && value.length() == 13)) {
      context.buildConstraintViolationWithTemplate("Contact Info Invalid!!");
      return false;
    }
    return true;
  }
}
