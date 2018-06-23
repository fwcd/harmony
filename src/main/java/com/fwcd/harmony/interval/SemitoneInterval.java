package com.fwcd.harmony.interval;

import com.fwcd.harmony.Pitch;

public interface SemitoneInterval extends PitchInterval {
	int getSemitones();

	@Override
	default Pitch apply(Pitch base, int times) {
		return base.plusHalfSteps(getSemitones());
	}
}
