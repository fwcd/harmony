package com.fwcd.harmony.test;

import static org.junit.Assert.assertEquals;

import com.fwcd.harmony.Note;
import com.fwcd.harmony.NoteClass;
import com.fwcd.harmony.OctaveIndex;
import com.fwcd.harmony.Step;
import com.fwcd.harmony.scale.RelativeNote;

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
	public void testRelativeNote() {
		assertEquals(new RelativeNote(NoteClass.D_FLAT, -2), new RelativeNote(NoteClass.C, -2).plusDiatonicStep(Step.HALF));
		assertEquals(new RelativeNote(NoteClass.D, 4), new RelativeNote(NoteClass.C, 4).plusDiatonicStep(Step.WHOLE));
		assertEquals(new RelativeNote(NoteClass.F), new RelativeNote(NoteClass.E).plusDiatonicStep(Step.HALF));
		assertEquals(new RelativeNote(NoteClass.A_FLAT), new RelativeNote(NoteClass.G_FLAT).plusDiatonicStep(Step.WHOLE));
		assertEquals(new RelativeNote(NoteClass.D_SHARP), new RelativeNote(NoteClass.C_SHARP).plusDiatonicStep(Step.WHOLE));
		assertEquals(new RelativeNote(NoteClass.C, 1), new RelativeNote(NoteClass.B).plusDiatonicStep(Step.HALF));
		assertEquals(new RelativeNote(NoteClass.C_SHARP, 5), new RelativeNote(NoteClass.B, 4).plusDiatonicStep(Step.WHOLE));
	}

	@Test
	public void testNote() {
		Note dFlat = new Note("Db3");
		assertEquals(NoteClass.D_FLAT, dFlat.getNoteClass());
		assertEquals("Db3", dFlat.toString());
		assertEquals(OctaveIndex.nr(3), dFlat.getOctave());
		assertEquals(new Note(NoteClass.D_FLAT, OctaveIndex.nr(-2)), new Note(NoteClass.C, OctaveIndex.nr(-2)).plusDiatonicStep(Step.HALF));
	}
}
