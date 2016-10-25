package org.rulez.magwas.javacourse;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

public class MainFrameTest extends MainClassTest {

	protected JFrame mainFrame;
	
	@Before
	public void setUp() {
		super.setUp();
		mainFrame = theMain.getMainFrame();
	}

	@Test
	public void test_mainFrame_title_contains_hello() {
		assertTrue(mainFrame.getTitle().contains("hello"));
	}

	@Test
	public void test_mainFrame_size_is_200x200() {
		assertEquals(mainFrame.getSize().getWidth(),200, 0.001);
		assertEquals(mainFrame.getSize().getHeight(),200, 0.001);
	}

	@Test
	public void test_mainFrame_is_visible() {
		assertTrue(mainFrame.isVisible());
	}

}
