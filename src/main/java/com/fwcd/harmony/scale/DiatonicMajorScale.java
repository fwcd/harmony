package com.fwcd.harmony.scale;

import static com.fwcd.harmony.Step.HALF;
import static com.fwcd.harmony.Step.WHOLE;

import java.util.List;

import com.fwcd.harmony.Note;

public class DiatonicMajorScale extends TemplateScale {
	private final Note key;

	public DiatonicMajorScale(Note key) {
		this.key = key;
	}

	@Override
	public List<Note> getNotes() {
		return ScaleUtils.createDiatonicScale(key,
			WHOLE, WHOLE, HALF,
			WHOLE, WHOLE, WHOLE, HALF
		);
	}

	@Override
	public Note getKey() { return key; }
}