package de.tum.in.ase.eist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class QueryProcessorTest {

	private final QueryProcessor queryProcessor = new QueryProcessor();

	@Test
	void testEmptyStringIfCannotProcessQuery() {
		assertEquals("", queryProcessor.process("test"));
	}

	@Test
	void testKnowsAboutShakespeare() {
		String actual = queryProcessor.process("Shakespeare");
		if (!actual.contains("playwright")) {
			fail("The QueryProcessor does not know about Shakespeare.");
		}
	}

	@Test
	void isNotCaseSensitive() {
		String actual = queryProcessor.process("shakespeare");
		if (!actual.contains("playwright")) {
			fail("Your QueryProcessor should not be case sensitive.");
		}
	}
	@Test
	void testName(){
		String  result= queryProcessor.process("which of the following numbers is the largest: 763, 2");
		assertEquals("763", result);
	}
	@Test
	void testPlus(){
		String  result= queryProcessor.process("what is 15 plus 12");
		assertEquals("27", result);
	}
	@Test
	void testMul(){
		String  result= queryProcessor.process("what is 15 multiplied by 12");
		assertEquals("180", result);
	}

}
