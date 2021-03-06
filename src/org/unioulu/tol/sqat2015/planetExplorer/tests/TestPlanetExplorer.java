package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	@Test
	public void testPlanet() {
		PlanetExplorer pe = new PlanetExplorer(1, 1, "");
		assertEquals(0, pe.getX());
	}
	
	@Test
	public void testPlanet2() {
		PlanetExplorer pe = new PlanetExplorer(1, 1, "");
		assertEquals(0, pe.getY());
	}
	
	@Test
	public void testTurning() {
		PlanetExplorer pe = new PlanetExplorer(1, 1, "");
		assertEquals("(0,0,N)", pe.executeCommand(""));
	}
	
	@Test
	public void testTurning2() {
		PlanetExplorer pe = new PlanetExplorer(1, 1, "");
		assertEquals("(0,0,E)", pe.executeCommand("r"));
		assertEquals("(0,0,N)", pe.executeCommand("l"));
		assertEquals("(0,0,W)", pe.executeCommand("l"));
	}
	
	@Test
	public void testMoving() {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "");
		assertEquals("(2,2,E)", pe.executeCommand("ffrff"));
	}
	
	@Test
	public void testLocatingObstacles() {
		PlanetExplorer pe = new PlanetExplorer(3, 3, "(2,2)");
		assertEquals("(1,2,E)(2,2)", pe.executeCommand("ffrfff"));
	}
	
	@Test
	public void testLocatingObstacles2() {
		PlanetExplorer pe = new PlanetExplorer(5, 5, "(2,2)(2,1)");
		assertEquals("(1,1,E)(2,2)(2,1)", pe.executeCommand("ffrfffrflf"));
	}
	
	@Test
	public void testLocatingObstacles3() {
		PlanetExplorer pe = new PlanetExplorer(6, 6, "(2,2)(0,5)(5,0)");
		assertEquals("(0,0,N)(2,2)(0,5)(5,0)", pe.executeCommand("ffrfffrbbblllfrfrbbl"));
	}
	
}
