package fwcd.harmony.chord;

import java.util.Arrays;
import java.util.List;

import fwcd.harmony.Pitch;

public class DiminishedTriad implements PitchChord {
	private final List<Pitch> pitches;
	
	public DiminishedTriad(Pitch root) {
		pitches = Arrays.asList(
			root,
			root.plusHalfSteps(3),
			root.plusHalfSteps(6)
		);
	}
	
	@Override
	public List<Pitch> getPitches() { return pitches; }
}
