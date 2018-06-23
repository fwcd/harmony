package com.fwcd.harmony.scale;

abstract class TemplateScaleClass implements ScaleClass {
	@Override
	public RelativeNote getDegree(ScaleDegree degree) {
		if (isDegreeValid(degree)) {
			return getNotes().get(degree.getNoteIndex());
		} else {
			throw new IllegalArgumentException("Invalid scale degree: " + degree + " (" + degree.getClass().getSimpleName() + ")");
		}
	}

	protected boolean isDegreeValid(ScaleDegree degree) { return true; }

	@Override
	public String toString() { return getNotes().toString(); }
}
