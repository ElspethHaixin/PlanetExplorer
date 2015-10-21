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
	}
	
}
