package com.fwcd.harmony.chord;

import java.util.Arrays;
import java.util.List;

import com.fwcd.harmony.Pitch;

public class MinorTriad implements PitchChord {
	private final List<Pitch> pitches;
	
	public MinorTriad(Pitch root) {
		pitches = Arrays.asList(
			root,
			root.plusHalfSteps(3),
			root.plusHalfSteps(7)
		);
	}
	
	@Override
	public List<Pitch> getPitches() { return pitches; }
}
