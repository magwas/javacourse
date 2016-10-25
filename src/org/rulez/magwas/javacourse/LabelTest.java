package org.rulez.magwas.javacourse;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

public class LabelTest extends MainFrameTest{

	private JLabel theLabel;

	@Before
	public void setUp() {
		super.setUp();
		theLabel = getLabelFrom(mainFrame);
	}

	@Test
	public void test_mainFrame_have_a_label() {
		assertTrue(theLabel instanceof JLabel);
	}

	@Test
	public void test_label_contains_hello_world_string() {
		assertTrue(theLabel.getText().contains("Hello World"));
	}

	private JLabel getLabelFrom(Container k) {
		for (Component comp : k.getComponents()) {
			if(comp instanceof JLabel) {
				return (JLabel) comp;
			}
			if(comp instanceof Container) {
				JLabel c = getLabelFrom((Container) comp);
				if (null != c) {
					return c;
				}
			}
		}
		return null;
	}
}
