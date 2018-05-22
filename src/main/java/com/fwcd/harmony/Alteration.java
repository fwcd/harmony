package com.fwcd.harmony;

import java.util.NoSuchElementException;

public enum Alteration {
	NONE(""),
	FLAT("b"),
	SHARP("#");

	private final String stringRepresentation;

	private Alteration(String stringRepresentation) {
		this.stringRepresentation = stringRepresentation;
	}

	public boolean isAltered() {
		return this != NONE;
	}

	@Override
	public String toString() {
		return stringRepresentation;
	}

	public static Alteration of(char alterationChar) {
		if (alterationChar == '\0') { return NONE; }

		for (Alteration alteration : values()) {
			String str = alteration.stringRepresentation;
			if (str.length() > 0 && str.charAt(0) == alterationChar) {
				return alteration;
			}
		}

		throw new NoSuchElementException("No alternation that matches '" + alterationChar + "'");
	}
}