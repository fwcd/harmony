package com.fwcd.harmony.scale;

import static com.fwcd.harmony.Step.HALF;
import static com.fwcd.harmony.Step.WHOLE;

import java.util.List;

import com.fwcd.harmony.Note;

public class DiatonicNaturalMinorScale extends TemplateScale {
	private final Note key;

	public DiatonicNaturalMinorScale(Note key) {
		this.key = key;
	}

	@Override
	public List<Note> getNotes() {
		return ScaleUtils.createDiatonicScale(key,
			WHOLE, HALF,
			WHOLE, WHOLE, HALF,
			WHOLE, WHOLE
		);
	}

	@Override
	public Note getKey() { return key; }
}