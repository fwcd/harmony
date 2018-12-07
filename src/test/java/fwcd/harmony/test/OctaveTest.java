package fwcd.harmony.test;

import static org.junit.Assert.assertEquals;

import fwcd.harmony.OctaveIndex;

import org.junit.Test;

public class OctaveTest {
	@Test
	public void testOctave() {
		assertEquals(OctaveIndex.SUB_CONTRA, OctaveIndex.CONTRA.plus(-1));
		assertEquals(OctaveIndex.THREE_LINED, OctaveIndex.GREAT.plus(4));
		assertEquals(OctaveIndex.GREAT, OctaveIndex.CONTRA.up());
		assertEquals(OctaveIndex.ONE_LINED, OctaveIndex.TWO_LINED.down());
	}
}
