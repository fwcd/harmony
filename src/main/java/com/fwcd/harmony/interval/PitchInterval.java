package com.fwcd.harmony.interval;

import com.fwcd.harmony.OctaveIndex;
import com.fwcd.harmony.Pitch;
import com.fwcd.harmony.PitchClass;

public interface PitchInterval {
	Pitch apply(Pitch base, int times);

	default PitchClass apply(PitchClass base, int times) {
		return apply(new Pitch(base, OctaveIndex.ZERO), times).getPitchClass();
	}
}
