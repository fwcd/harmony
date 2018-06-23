package com.fwcd.harmony.scale;

import static com.fwcd.harmony.Step.HALF;
import static com.fwcd.harmony.Step.WHOLE;

import java.util.List;

import com.fwcd.harmony.NoteClass;

public class DiatonicNaturalMinor extends TemplateScaleClass {
	private final RelativeNote key;
	private final List<RelativeNote> notes;

	public DiatonicNaturalMinor(NoteClass key) { this(new RelativeNote(key)); }

	public DiatonicNaturalMinor(RelativeNote key) {
		this.key = key;

		notes = ScaleUtils.createDiatonicScale(key,
			WHOLE, HALF,
			WHOLE, WHOLE, HALF,
			WHOLE, WHOLE
		);
	}

	@Override
	public List<RelativeNote> getNotes() { return notes; }

	@Override
	protected boolean isDegreeValid(ScaleDegree degree) { return degree instanceof DiatonicNaturalMinorDegree; }

	@Override
	public RelativeNote getKey() { return key; }
}
