package org.rulez.magwas.javacourse;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

public class MainClassTest {

	protected Main theMain;

	@Before
	public void setUp() {
		theMain = new Main();
	}

	@Test
	public void test_have_a_getMainFrame_method_returning_a_JFrame() {
		//note that the getMainFrame method only exists to facilitate testing
		assertTrue(theMain.getMainFrame() instanceof JFrame);
	}

}
