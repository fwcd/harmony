package com.fwcd.harmony.test;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import static com.fwcd.harmony.test.TestUtils.assertThrows;

import com.fwcd.harmony.Note;
import com.fwcd.harmony.NoteClass;
import com.fwcd.harmony.scale.DiatonicMajor;
import com.fwcd.harmony.scale.DiatonicMajorDegree;
import com.fwcd.harmony.scale.DiatonicNaturalMinor;
import com.fwcd.harmony.scale.DiatonicNaturalMinorDegree;
import com.fwcd.harmony.scale.Scale;
import com.fwcd.harmony.scale.ScaleClass;

import org.junit.Test;

public class ScaleTest {
	@Test
	public void testDiatonicMajorScale() {
		assertEquals("[C3, D3, E3, F3, G3, A3, B3, C4]", Scale.createMajor(new Note("C3")).toString());
		assertEquals("[Db0, Eb0, F0, Gb0, Ab0, Bb0, C1, Db1]", Scale.createMajor(new Note("Db0")).toString());
	}

	@Test
	public void testDiatonicNaturalMinorScale() {
		assertEquals("[C4, D4, Eb4, F4, G4, Ab4, Bb4, C5]", Scale.createNaturalMinor(new Note("C4")).toString());
		assertEquals("[A1, B1, C2, D2, E2, F2, G2, A2]", Scale.createNaturalMinor(new Note("A1")).toString());
		assertEquals("[G#5, A#5, B5, C#6, D#6, E6, F#6, G#6]", Scale.createNaturalMinor(new Note("G#5")).toString());
	}

	@Test
	public void testChromaticScale() {
		assertEquals("[C2, C#2, D2, D#2, E2, F2, F#2, G2, G#2, A2, A#2, B2, C3]", Scale.createChromatic(new Note("C2")).toString());
	}

	@Test
	public void testDegrees() {
		ScaleClass cMajor = new DiatonicMajor(NoteClass.C);
		assertEquals("C", cMajor.getDegree(DiatonicMajorDegree.TONIC).getNoteClass().toString());
		assertEquals("D", cMajor.getDegree(DiatonicMajorDegree.SUPERTONIC).getNoteClass().toString());
		assertEquals("E", cMajor.getDegree(DiatonicMajorDegree.MEDIANT).getNoteClass().toString());
		assertEquals("F", cMajor.getDegree(DiatonicMajorDegree.SUBDOMINANT).getNoteClass().toString());
		assertEquals("G", cMajor.getDegree(DiatonicMajorDegree.DOMINANT).getNoteClass().toString());

		ScaleClass cSharpMinor = new DiatonicNaturalMinor(NoteClass.C_SHARP);
		assertEquals("C#", cSharpMinor.getDegree(DiatonicNaturalMinorDegree.TONIC).getNoteClass().toString());
		assertEquals("D#", cSharpMinor.getDegree(DiatonicNaturalMinorDegree.SUPERTONIC).getNoteClass().toString());
		assertEquals("E", cSharpMinor.getDegree(DiatonicNaturalMinorDegree.MEDIANT).getNoteClass().toString());
		assertEquals("F#", cSharpMinor.getDegree(DiatonicNaturalMinorDegree.SUBDOMINANT).getNoteClass().toString());
		assertEquals("G#", cSharpMinor.getDegree(DiatonicNaturalMinorDegree.DOMINANT).getNoteClass().toString());
		assertEquals("A", cSharpMinor.getDegree(DiatonicNaturalMinorDegree.SUBMEDIANT).getNoteClass().toString());
		assertEquals("B", cSharpMinor.getDegree(DiatonicNaturalMinorDegree.SUBTONIC).getNoteClass().toString());

		assertThrows(() -> cMajor.getDegree(DiatonicNaturalMinorDegree.SUBTONIC), IllegalArgumentException.class);
		assertThrows(() -> cSharpMinor.getDegree(DiatonicMajorDegree.MEDIANT), IllegalArgumentException.class);
	}
}
