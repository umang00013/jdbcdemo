package test;

import static org.junit.Assert.*;

import org.junit.Test;

import business.JUnitMessage;

public class JUnitMessageTest {
	public String message = "Raj";                       
    JUnitMessage junitMessage = new JUnitMessage(message);

	@Test
	public void testPrintMessage() {
		System.out.println("Junit Message is printing ");           
		junitMessage.printMessage();
	}

	@Test
	public void testPrintHiMessage() {
		message = "Hi " + message;                       
        System.out.println("Junit Hi Message is printing ");           
        assertEquals(message, junitMessage.printHiMessage());
	}

}
