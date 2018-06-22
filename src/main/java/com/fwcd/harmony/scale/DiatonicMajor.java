package com.fwcd.harmony.scale;

import static com.fwcd.harmony.Step.HALF;
import static com.fwcd.harmony.Step.WHOLE;

import java.util.List;

public class DiatonicMajor extends TemplateScaleClass {
	private final RelativeNote key;

	public DiatonicMajor(RelativeNote key) {
		this.key = key;
	}

	@Override
	public List<RelativeNote> getNotes() {
		return ScaleUtils.createDiatonicScale(key,
			WHOLE, WHOLE, HALF,
			WHOLE, WHOLE, WHOLE, HALF
		);
	}

	@Override
	public RelativeNote getKey() { return key; }
}