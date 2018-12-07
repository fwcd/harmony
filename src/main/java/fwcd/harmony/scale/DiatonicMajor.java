package fwcd.harmony.scale;

import static fwcd.harmony.Step.HALF;
import static fwcd.harmony.Step.WHOLE;

import java.util.List;

import fwcd.harmony.NoteClass;

public class DiatonicMajor extends TemplateScaleClass {
	private final RelativeNote key;
	private final List<RelativeNote> notes;

	public DiatonicMajor(NoteClass key) { this(new RelativeNote(key)); }

	public DiatonicMajor(RelativeNote key) {
		this.key = key;
		notes = ScaleUtils.createDiatonicScale(key,
			WHOLE, WHOLE, HALF,
			WHOLE, WHOLE, WHOLE, HALF
		);
	}

	@Override
	public List<RelativeNote> getNotes() { return notes; }

	@Override
	protected boolean isDegreeValid(ScaleDegree degree) { return degree instanceof DiatonicMajorDegree; }

	@Override
	public RelativeNote getKey() { return key; }
}
