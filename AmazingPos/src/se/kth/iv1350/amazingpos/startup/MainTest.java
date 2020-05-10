package se.kth.iv1350.amazingpos.startup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.amazingpos.controller.OperationFailedException;
import se.kth.iv1350.amazingpos.integration.AddItemException;
import se.kth.iv1350.amazingpos.integration.ItemCatalogException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
	
	private Main instanceToTest;
	private ByteArrayOutputStream printout;
	private PrintStream originalSystemOut;
	
	@BeforeEach
	public void setUp() {
		instanceToTest = new Main();
		
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
	public void testUIHasStarted() throws AddItemException, ItemCatalogException, OperationFailedException, IOException {
		String[] args = null;
		Main.main(args);
		String printouts = printout.toString();
		String expectedOutput = "started";
		assertTrue(printouts.contains(expectedOutput));
	}

}
