package com.fwcd.harmony.scale;

import static com.fwcd.harmony.Step.HALF;
import static com.fwcd.harmony.Step.WHOLE;

import java.util.List;

public class DiatonicMajor extends TemplateScaleClass {
	private final RelativeNote key;
	private final List<RelativeNote> notes;

	public DiatonicMajor(RelativeNote key) {
		this.key = key;
		notes = ScaleUtils.createDiatonicScale(key,
			WHOLE, WHOLE, HALF,
			WHOLE, WHOLE, WHOLE, HALF
		);
	}

	@Override
	public List<RelativeNote> getNotes() { return notes; }

	public RelativeNote getDegree(DiatonicMajorDegree degree) { return notes.get(degree.getIndex()); }

	@Override
	public RelativeNote getKey() { return key; }
}