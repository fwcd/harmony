package com.fwcd.harmony.chord;

import java.util.Arrays;
import java.util.List;

import com.fwcd.harmony.Pitch;

public class AugmentedTriad implements PitchChord {
	private final List<Pitch> pitches;
	
	public AugmentedTriad(Pitch root) {
		pitches = Arrays.asList(
			root,
			root.plusHalfSteps(4),
			root.plusHalfSteps(8)
		);
	}
	
	@Override
	public List<Pitch> getPitches() { return pitches; }
}
