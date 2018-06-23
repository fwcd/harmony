package com.fwcd.harmony.test;

import static org.junit.Assert.assertEquals;

import com.fwcd.harmony.OctaveIndex;
import com.fwcd.harmony.Pitch;
import com.fwcd.harmony.PitchClass;

import org.junit.Test;

public class PitchTest {
	@Test
	public void testPitchClass() {
		assertEquals(PitchClass.B, PitchClass.C.plusHalfSteps(-1));
		assertEquals(PitchClass.A, PitchClass.F.plusHalfSteps(-8));
		assertEquals(PitchClass.D, PitchClass.A.plusHalfSteps(5));
		assertEquals(1, PitchClass.A.halfStepsTo(PitchClass.A_SHARP_B_FLAT));
		assertEquals(2, PitchClass.C.halfStepsTo(PitchClass.D));
		assertEquals(1, PitchClass.E.halfStepsTo(PitchClass.F));
		assertEquals(1, PitchClass.B.halfStepsTo(PitchClass.C));
		assertEquals(2, PitchClass.B.halfStepsTo(PitchClass.C_SHARP_D_FLAT));
		assertEquals(3, PitchClass.B.halfStepsTo(PitchClass.D));
	}

	@Test
	public void testPitch() {
		Pitch a = new Pitch(PitchClass.A_SHARP_B_FLAT, OctaveIndex.SMALL);
		Pitch b = a.plusHalfSteps(3);
		assertEquals(PitchClass.C_SHARP_D_FLAT, b.getPitchClass());
		assertEquals(OctaveIndex.ONE_LINED, b.getOctave());
		Pitch c = a.plusHalfSteps(-16);
		assertEquals(PitchClass.F_SHARP_G_FLAT, c.getPitchClass());
		assertEquals(OctaveIndex.GREAT, c.getOctave());
	}
}
