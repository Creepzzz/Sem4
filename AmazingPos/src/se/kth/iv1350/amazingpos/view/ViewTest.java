package se.kth.iv1350.amazingpos.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.integration.CatalogCreator;
import se.kth.iv1350.amazingpos.integration.Printer;
import se.kth.iv1350.amazingpos.integration.SystemCreator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ViewTest {
	
	private View instanceToTest;
	private ByteArrayOutputStream printout;
	private PrintStream originalSystemOut;
	
	@BeforeEach
	public void setUp() throws IOException {
		Controller ctrl = new Controller(new SystemCreator(), new CatalogCreator(), new Printer());
		instanceToTest = new View(ctrl);
		
		printout = new ByteArrayOutputStream();
		PrintStream inMemSysOut = new PrintStream(printout);
		originalSystemOut = System.out;
		System.setOut(inMemSysOut);
	}
	
	@AfterEach
	public void tearDown() {
		instanceToTest = null;
		
		printout = null;
		System.setOut(originalSystemOut);
	}

	@Test
	public void testRunFakeExecution() {
		instanceToTest.runFakeExecution();
		String printouts = printout.toString();
		String expectedOutput = "started";
		System.out.println(printouts);
		assertTrue(printouts.contains(expectedOutput));
		
	}

}
