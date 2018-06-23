package com.fwcd.harmony.test;

import static org.junit.Assert.assertEquals;

import com.fwcd.harmony.Octave;

import org.junit.Test;

public class OctaveTest {
	@Test
	public void testOctave() {
		assertEquals(Octave.SUB_CONTRA, Octave.CONTRA.plus(-1));
		assertEquals(Octave.THREE_LINED, Octave.GREAT.plus(4));
		assertEquals(Octave.GREAT, Octave.CONTRA.up());
		assertEquals(Octave.ONE_LINED, Octave.TWO_LINED.down());
	}
}
