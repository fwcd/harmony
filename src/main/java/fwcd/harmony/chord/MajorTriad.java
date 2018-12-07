package fwcd.harmony.chord;

import java.util.Arrays;
import java.util.List;

import fwcd.harmony.Pitch;

public class MajorTriad implements PitchChord {
	private final List<Pitch> pitches;
	
	public MajorTriad(Pitch root) {
		pitches = Arrays.asList(
			root,
			root.plusHalfSteps(4),
			root.plusHalfSteps(7)
		);
	}
	
	@Override
	public List<Pitch> getPitches() { return pitches; }
}
