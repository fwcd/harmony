package fwcd.harmony;

public class Pitch {
	private final PitchClass pitchClass;
	private final OctaveIndex octave;

	public Pitch(PitchClass pitchClass, OctaveIndex octave) {
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

	public OctaveIndex getOctave() { return octave; }

	@Override
	public String toString() {
		return getPitchClass().toString() + getOctave().getSpnIndex();
	}

	@Override
	public int hashCode() {
		return 7 * pitchClass.hashCode() * octave.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Pitch other = (Pitch) obj;
		return pitchClass.equals(other.pitchClass) && octave.equals(other.octave);
	}
}
