package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	@Test
	public void testPlanet() {
		PlanetExplorer pe = new PlanetExplorer(1, 1, "");
		assertEquals(1, pe.x);
	}
	
	
}
