package com.tw.practice;

import org.junit.Assert;
import org.junit.Test;

public class NumberTest {

    public NumberTest() {
    }

    @Test
    public void SameDigits4A0B() {
        Number number = new Number("0000");
        Assert.assertEquals("4A0B", number.compare("0000"));
    }

    @Test
    public void SameDigitsPartsDifPos1A3B() {
        Number number = new Number("1234");
        Assert.assertEquals("1A3B", number.compare("3241"));
    }

    @Test
    public void DifferentDigits0A0B() {
        Number number = new Number("1234");
        Assert.assertEquals("0A0B", number.compare("0965"));
    }

    @Test
    public void SameDigitsDifPos0A4B() {
        Number number = new Number("1234");
        Assert.assertEquals("0A4B", number.compare("4321"));
    }
}
