package nl.kolkos.java.nl.kolkos.telegrambot2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGroovy {

	@Test
	public void test() {
		GroovyShell shell = new GroovyShell();
	    String script = "return 'hello world'";

	    Object result = shell.evaluate(script);
	    assertEquals(result, "hello world");
	}

}
