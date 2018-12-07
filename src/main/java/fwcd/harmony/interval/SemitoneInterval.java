package fwcd.harmony.interval;

import fwcd.harmony.Pitch;

public interface SemitoneInterval extends PitchInterval {
	int getSemitones();

	@Override
	default Pitch apply(Pitch base, int times) {
		return base.plusHalfSteps(getSemitones());
	}
}
