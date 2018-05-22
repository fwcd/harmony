package com.fwcd.harmony;

public class Pitch {
	private final PitchClass pitchClass;
	private final Octave octave;

	public Pitch(PitchClass pitchClass, Octave octave) {
		this.pitchClass = pitchClass;
		this.octave = octave;
	}

	public Pitch plusHalfSteps(int halfSteps) {
		int octaves = Math.floorDiv(pitchClass.ordinal() + halfSteps, PitchClass.values().length);
		return new Pitch(
			pitchClass.plusHalfSteps(halfSteps),
			octave.plus(octaves)
		);
	}

	public Pitch plusWholeSteps(int wholeSteps) {
		return plusHalfSteps(wholeSteps * 2);
	}

	public boolean isSemitone() {
		return pitchClass.isSemitone();
	}

	public Pitch wholeStepDown() { return plusWholeSteps(-1); }

	public Pitch wholeStepUp() { return plusWholeSteps(1); }

	public Pitch halfStepDown() { return plusHalfSteps(-1); }

	public Pitch halfStepUp() { return plusHalfSteps(1); }

	public PitchClass getPitchClass() { return pitchClass; }

	public Octave getOctave() { return octave; }

	@Override
	public String toString() {
		return getPitchClass().toString() + getOctave().getSpnIndex();
	}
}