package com.fwcd.harmony.interval;

import com.fwcd.harmony.Note;
import com.fwcd.harmony.Pitch;

/**
 * An pseudo-"interval" that refers to two identical pitches/notes.
 *
 * Also called 'perfect unison', 'prime' or 'perfect prime'
 */
public class Unison implements NoteInterval, PitchInterval, DiatonicInterval {
	public static final Unison INSTANCE = new Unison();

	private Unison() {}

	@Override
	public Pitch apply(Pitch base, int times) { return base; }

	@Override
	public Note apply(Note base, int times) { return base; }

	@Override
	public int getDegrees() { return 0; }
}
