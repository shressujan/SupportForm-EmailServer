package com.supportform.emailserver.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class GetContactNumberTest {

  private SupportFormServiceImpl supportFormServiceImpl;

  @Before
  public void initialSetup() {
    supportFormServiceImpl = new SupportFormServiceImpl();
  }

  @Test
  public void getContactNumber() {
    String testContactNumber1 = "(123)456-7890";
    String testContactNumber2 = "1234567890";
    String testContactNumber3 = "123-456-7890";
    BigInteger expectedContactNumber = new BigInteger(String.valueOf(1234567890));

    Assert.assertEquals(expectedContactNumber, supportFormServiceImpl.getContactNumber(testContactNumber1));
    Assert.assertEquals(expectedContactNumber, supportFormServiceImpl.getContactNumber(testContactNumber2));
    Assert.assertEquals(expectedContactNumber, supportFormServiceImpl.getContactNumber(testContactNumber3));
  }
}
