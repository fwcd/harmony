package com.fwcd.harmony.scale;

import static com.fwcd.harmony.Step.HALF;
import static com.fwcd.harmony.Step.WHOLE;

import java.util.List;

public class DiatonicNaturalMinor extends TemplateScaleClass {
	private final RelativeNote key;

	public DiatonicNaturalMinor(RelativeNote key) {
		this.key = key;
	}

	@Override
	public List<RelativeNote> getNotes() {
		return ScaleUtils.createDiatonicScale(key,
			WHOLE, HALF,
			WHOLE, WHOLE, HALF,
			WHOLE, WHOLE
		);
	}

	@Override
	public RelativeNote getKey() { return key; }
}