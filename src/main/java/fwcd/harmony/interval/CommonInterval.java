package fwcd.harmony.interval;

public enum CommonInterval implements SemitoneInterval {
	PERFECT_UNISON(0),
	MINOR_SECOND(1),
	MAJOR_SECOND(2),
	MINOR_THIRD(3),
	MAJOR_THIRD(4),
	PERFECT_FOURTH(5),
	PERFECT_FIFTH(7),
	MINOR_SIXTH(8),
	MAJOR_SIXTH(9),
	MINOR_SEVENTH(10),
	MAJOR_SEVENTH(11),
	PERFECT_OCTAVE(12);

	private final int semitones;

	private CommonInterval(int semitones) {
		this.semitones = semitones;
	}

	@Override
	public int getSemitones() { return semitones; }
}
