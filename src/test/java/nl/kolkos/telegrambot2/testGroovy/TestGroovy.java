package nl.kolkos.telegrambot2.testGroovy;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;



class TestGroovy {
	
	@Test
	void testGroovyScripts() {
		this.testGroovy1();
		this.testGroovy2();
		this.testGroovy3();
		
	}
	
	@Test
	void testGroovy1() {
		GroovyShell shell = new GroovyShell();
	    String script = "return 'hello world'";

	    Object result = shell.evaluate(script);
	    
	    System.out.println(result.toString());
	    
	    assertEquals(result, "hello world");
	}
	
	@Test
	void testGroovy2() {
		// Create GroovyClassLoader.
        final GroovyClassLoader classLoader = new GroovyClassLoader();
		
		// Create a String with Groovy code.
        final StringBuilder groovyScript = new StringBuilder();
        groovyScript.append("class Sample {");
        groovyScript.append("  String sayIt(name) {");
        groovyScript.append("    \"Groovy says: Cool $name!\"");
        groovyScript.append("  }");
        //groovyScript.append("  String sayIt(name) { \"Groovy says: Cool $name!\" }");
        groovyScript.append("}");
         
        // Load string as Groovy script class.
        Class groovy = classLoader.parseClass(groovyScript.toString());
        
		try {
			GroovyObject groovyObj = (GroovyObject) groovy.newInstance();
			String output = (String) groovyObj.invokeMethod("sayIt", new Object[] { "mrhaki" });
			System.out.println(output);
	        assert "Groovy says: Cool mrhaki!".equals(output);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	@Test
	void testGroovy3() {
		// gebruik van evaluate
		
		GroovyShell shell = new GroovyShell();
		
		StringBuilder groovyScript = new StringBuilder();
		groovyScript.append("def sayHello() {");
		groovyScript.append("println 'hello from Groovy script 3!' };");
		groovyScript.append("this");
		
		
		try {
			Object script = shell.evaluate(groovyScript.toString());
			Method m = script.getClass().getMethod("sayHello");
			m.invoke(script);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
