package com.fwcd.harmony.test;

import static org.junit.Assert.assertEquals;

import com.fwcd.harmony.Note;
import com.fwcd.harmony.NoteClass;
import com.fwcd.harmony.Octave;
import com.fwcd.harmony.Step;

import org.junit.Test;

public class NoteTest {
	@Test
	public void testNoteClass() {
		assertEquals(NoteClass.D_FLAT, NoteClass.C.plusDiatonicStep(Step.HALF));
		assertEquals(NoteClass.D, NoteClass.C.plusDiatonicStep(Step.WHOLE));
		assertEquals(NoteClass.F, NoteClass.E.plusDiatonicStep(Step.HALF));
		assertEquals(NoteClass.A_FLAT, NoteClass.G_FLAT.plusDiatonicStep(Step.WHOLE));
		assertEquals(NoteClass.D_SHARP, NoteClass.C_SHARP.plusDiatonicStep(Step.WHOLE));
		assertEquals(NoteClass.C, NoteClass.B.plusDiatonicStep(Step.HALF));
		assertEquals(NoteClass.C_SHARP, NoteClass.B.plusDiatonicStep(Step.WHOLE));
	}

	@Test
	public void testNote() {
		Note dFlat = new Note("Db3");
		assertEquals(NoteClass.D_FLAT, dFlat.getNoteClass());
		assertEquals("Db3", dFlat.toString());
		assertEquals(Octave.nr(3), dFlat.getOctave());
	}
}