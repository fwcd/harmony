package com.fwcd.harmony;

public enum Step {
	HALF(1), WHOLE(2);

	private final int halfSteps;

	private Step(int halfSteps) {
		this.halfSteps = halfSteps;
	}

	public int getHalfSteps() { return halfSteps; }
}
