package fwcd.harmony;

import fwcd.harmony.interval.PitchInterval;

public enum Step implements PitchInterval {
	HALF(1), WHOLE(2);

	private final int halfSteps;

	private Step(int halfSteps) {
		this.halfSteps = halfSteps;
	}

	public int getHalfSteps() { return halfSteps; }

	@Override
	public Pitch apply(Pitch base, int times) {
		switch (this) {
			case WHOLE: return base.plusWholeSteps(1);
			case HALF: return base.plusHalfSteps(1);
			default: throw new UnsupportedOperationException(toString() + " can not be applied as a pitch interval.");
		}
	}
}
