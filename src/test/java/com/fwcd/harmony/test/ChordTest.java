package com.fwcd.harmony.test;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;

import com.fwcd.harmony.Note;
import com.fwcd.harmony.Pitch;
import com.fwcd.harmony.chord.AugmentedTriad;
import com.fwcd.harmony.chord.DiminishedTriad;
import com.fwcd.harmony.chord.MajorTriad;
import com.fwcd.harmony.chord.MinorTriad;
import com.fwcd.harmony.chord.PitchChord;

import org.junit.Test;

public class ChordTest {
	@Test
	public void testTriads() {
		assertChordEquals("[C1, E1, G1]", chordOf("C1", MajorTriad::new));
		assertChordEquals("[F#/Gb0, A0, C#/Db1]", chordOf("F#0", MinorTriad::new));
		assertChordEquals("[B3, D4, F4]", chordOf("B3", DiminishedTriad::new));
		assertChordEquals("[A-1, C#/Db0, F0]", chordOf("A-1", AugmentedTriad::new));
	}
	
	private void assertChordEquals(String expected, PitchChord actual) {
		assertEquals(expected, actual.getPitches().toString());
	}
	
	private PitchChord chordOf(String root, Function<Pitch, PitchChord> constructor) {
		return constructor.apply(new Note(root).getPitch());
	}
}
