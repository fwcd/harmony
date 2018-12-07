package fwcd.harmony.interval;

import fwcd.harmony.OctaveIndex;
import fwcd.harmony.Pitch;
import fwcd.harmony.PitchClass;

public interface PitchInterval {
	Pitch apply(Pitch base, int times);

	default PitchClass apply(PitchClass base, int times) {
		return apply(new Pitch(base, OctaveIndex.ZERO), times).getPitchClass();
	}
}
