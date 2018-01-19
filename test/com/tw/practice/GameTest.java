package com.tw.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    private NumberGenerator mockedGenerator;

    @Mock
    private Printer mockedPrinter;

    @Mock
    private NumberReader mockedReader;

    @Test
    public void shouldReturn4A0BWhenInputSameNumber() throws Exception {
        Mockito.when(mockedGenerator.generate()).thenReturn("1234");
        Mockito.when(mockedReader.read()).thenReturn("1234");

        Game game = new Game(mockedGenerator, mockedPrinter, mockedReader);

        game.start();
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(mockedPrinter, Mockito.times(1)).print("you win");
    }

    @Test
    public void shouldReturn0A0BWhenInputAllDifferentNumber() throws Exception {
        Mockito.when(this.mockedGenerator.generate()).thenReturn("1234");
        Mockito.when(this.mockedReader.read()).thenReturn("0965");
        Game game = new Game(this.mockedGenerator, this.mockedPrinter, this.mockedReader);
        game.start();
        Mockito.verify(this.mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
       Mockito.verify(this.mockedPrinter, Mockito.times(1)).print("Game Over");
    }

    @Test
    public void shouldReturn0A4BWhenInputSameNumberDifPos() throws Exception {
        Mockito.when(this.mockedGenerator.generate()).thenReturn("1234");
        Mockito.when(this.mockedReader.read()).thenReturn("4321");
        Game game = new Game(this.mockedGenerator, this.mockedPrinter, this.mockedReader);
        game.start();
        Mockito.verify(this.mockedPrinter, Mockito.times(1)).print("please input a 4 digit number:");
        Mockito.verify(this.mockedPrinter, Mockito.times(6)).print("0A4B");
    }

}