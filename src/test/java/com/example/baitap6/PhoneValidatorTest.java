package com.example.baitap6;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PhoneValidatorTest {

    @Test
    public void testValidPhone_09() {
        Assert.assertTrue(PhoneValidator.isValid("0912345678"));
    }

    @Test
    public void testValidPhone_Plus84() {
        Assert.assertTrue(PhoneValidator.isValid("+84912345678"));
    }

    @Test
    public void testInvalidPrefix() {
        Assert.assertFalse(PhoneValidator.isValid("0212345678"));
    }

    @Test
    public void testInvalidLength() {
        Assert.assertFalse(PhoneValidator.isValid("091234567"));
    }

    @Test
    public void testInvalidCharacters() {
        Assert.assertFalse(PhoneValidator.isValid("09a2345678"));
    }

}