package fwcd.harmony.scale;

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

	@Override
	public boolean equals(Object obj) {
		if (!getClass().equals(obj.getClass())) return false;
		ScaleClass other = (ScaleClass) obj;
		return getNotes().equals(other.getNotes()) && getKey().equals(other.getKey());
	}

	@Override
	public int hashCode() {
		return 7 * getNotes().hashCode() * getKey().hashCode();
	}
}
