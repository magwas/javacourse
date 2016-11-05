package org.rulez.magwas.javacourse;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GroundTest {

	public class FakeCanvas implements ITurtleCanvas {

		public String drawnObject;
		public int x1;
		public int y1;
		public int x2;
		public int y2;

		@Override
		public void drawLine(int x1, int y1, int x2, int y2) {
			drawnObject="line";
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			
		}

		@Override
		public void drawTurtle(int x, int y, double direction) {
			drawnObject="turtle";
			this.x1 = x;
			this.y1 = y;
			this.x2 = (int) direction;
		}

		@Override
		public void clearTurtles() {
			drawnObject="clearTurtles";
		}
		
	}

	Ground ground;
	private FakeCanvas fakeCanvas;

	@Before
	public void setUp(){
		fakeCanvas = new FakeCanvas();
		ground = new Ground(fakeCanvas);
	}
	
	@Test
	public void test_main_have_getGround_method() {
		assertTrue(ground instanceof Ground);
	}
	
	@Test
	public void test_getCanvas_returns_the_canvas() {
		assertEquals(fakeCanvas, ground.getCanvas());
	}
	
	@Test
	public void test_drawLine_draws_a_line_on_the_canvas() {
		ground.drawLine(20,30,40,50);
		assertEquals("line", fakeCanvas.drawnObject);
		assertEquals(20, fakeCanvas.x1);
		assertEquals(30, fakeCanvas.y1);
		assertEquals(40, fakeCanvas.x2);
		assertEquals(50, fakeCanvas.y2);
	}
	
	@Test
	public void test_drawLine_records_the_drawn_line() {
		ground.drawLine(20,30,40,50);
		List<IDrawnObject> drawnObjects = ground.getDrawnObjects();
		IDrawnObject dO = drawnObjects.get(drawnObjects.size()-1);
		assertEquals("line", dO.getType());
		assertEquals(20, dO.getX1());
		assertEquals(30, dO.getY1());
		assertEquals(40, dO.getX2());
		assertEquals(50, dO.getY2());
	}
	
	@Test
	public void test_drawTurtle_draws_the_turtle() {
		ground.drawTurtle(100, 110, 45);
		assertEquals("turtle", fakeCanvas.drawnObject);
		assertEquals(100, fakeCanvas.x1);
		assertEquals(110, fakeCanvas.y1);
		assertEquals(45, fakeCanvas.x2);
	}


	@Test
	public void test_drawTurtle_records_the_turtle() {
		ground.drawTurtle(100, 110, 45);
		List<IDrawnObject> drawnObjects = ground.getDrawnObjects();
		IDrawnObject dO = drawnObjects.get(drawnObjects.size()-1);
		assertEquals("turtle", dO.getType());
		assertEquals(100, dO.getX1());
		assertEquals(110, dO.getY1());
		assertEquals(45, dO.getX2());
	}

}
