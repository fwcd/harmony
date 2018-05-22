package com.fwcd.harmony.test;

import static org.junit.Assert.assertEquals;

import com.fwcd.harmony.Note;
import com.fwcd.harmony.scale.ChromaticScale;
import com.fwcd.harmony.scale.DiatonicMajorScale;
import com.fwcd.harmony.scale.DiatonicNaturalMinorScale;

import org.junit.Test;

public class ScaleTest {
	@Test
	public void testDiatonicMajorScale() {
		assertEquals("[C3, D3, E3, F3, G3, A3, B3, C4]", new DiatonicMajorScale(new Note("C3")).toString());
		assertEquals("[Db0, Eb0, F0, Gb0, Ab0, Bb0, C1, Db1]", new DiatonicMajorScale(new Note("Db0")).toString());
	}

	@Test
	public void testDiatonicNaturalMinorScale() {
		assertEquals("[C4, D4, Eb4, F4, G4, Ab4, Bb4, C5]", new DiatonicNaturalMinorScale(new Note("C4")).toString());
		assertEquals("[A1, B1, C2, D2, E2, F2, G2, A2]", new DiatonicNaturalMinorScale(new Note("A1")).toString());
		assertEquals("[G#5, A#5, B5, C#6, D#6, E6, F#6, G#6]", new DiatonicNaturalMinorScale(new Note("G#5")).toString());
	}

	@Test
	public void testChromaticScale() {
		assertEquals("[C2, C#2, D2, D#2, E2, F2, F#2, G2, G#2, A2, A#2, B2, C3]", new ChromaticScale(new Note("C2")).toString());
	}
}