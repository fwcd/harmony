package com.fwcd.harmony;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fwcd.harmony.utils.Chooser;

public enum NoteClass {
	C("C", PitchClass.C, Alteration.NONE),
	C_SHARP("C#", PitchClass.C_SHARP_D_FLAT, Alteration.SHARP),
	D_FLAT("Db", PitchClass.C_SHARP_D_FLAT, Alteration.FLAT),
	D("D", PitchClass.D, Alteration.NONE),
	D_SHARP("D#", PitchClass.D_SHARP_E_FLAT, Alteration.SHARP),
	E_FLAT("Eb", PitchClass.D_SHARP_E_FLAT, Alteration.FLAT),
	E("E", PitchClass.E, Alteration.NONE),
	F("F", PitchClass.F, Alteration.NONE),
	F_SHARP("F#", PitchClass.F_SHARP_G_FLAT, Alteration.SHARP),
	G_FLAT("Gb", PitchClass.F_SHARP_G_FLAT, Alteration.FLAT),
	G("G", PitchClass.G, Alteration.NONE),
	G_SHARP("G#", PitchClass.G_SHARP_A_FLAT, Alteration.SHARP),
	A_FLAT("Ab", PitchClass.G_SHARP_A_FLAT, Alteration.FLAT),
	A("A", PitchClass.A, Alteration.NONE),
	A_SHARP("A#", PitchClass.A_SHARP_B_FLAT, Alteration.SHARP),
	B_FLAT("Bb", PitchClass.A_SHARP_B_FLAT, Alteration.FLAT),
	B("B", PitchClass.B, Alteration.NONE);

	private static final Map<String, NoteClass> NAME_LOOKUP_TABLE = new HashMap<>();
	private static final Map<Character, Map<Alteration, NoteClass>> CHAR_LOOKUP_TABLE = new HashMap<>();
	private final String ncName;
	private final PitchClass pitchClass;
	private final Alteration alteration;

	static {
		for (NoteClass noteClass : values()) {
			NAME_LOOKUP_TABLE.put(noteClass.ncName, noteClass);
			char character = noteClass.getCharacter();
			CHAR_LOOKUP_TABLE.putIfAbsent(character, new HashMap<>());
			CHAR_LOOKUP_TABLE.get(character).put(noteClass.alteration, noteClass);

			noteClass.pitchClass.addNoteClass(noteClass);
		}
	}

	private NoteClass(String ncName, PitchClass pitchClass, Alteration alteration) {
		this.ncName = ncName;
		this.pitchClass = pitchClass;
		this.alteration = alteration;
	}

	public static NoteClass of(String name) {
		return Objects.requireNonNull(NAME_LOOKUP_TABLE.get(name));
	}

	public int halfStepsTo(NoteClass next) {
		return pitchClass.halfStepsTo(next.pitchClass);
	}

	private NoteClass next() {
		NoteClass[] vals = values();
		return vals[(ordinal() + 1) % vals.length];
	}

	private NoteClass plusHalfStepsWithDifferentChar(int halfSteps) {
		char thisChar = getCharacter();
		NoteClass nextNC = this;
		do {
			nextNC = nextNC.next();
		} while (nextNC.getCharacter() == thisChar || halfStepsTo(nextNC) < halfSteps);
		return nextNC;
	}

	public NoteClass plus(Step step, Chooser<NoteClass> enharmonicVariantChooser) {
		return enharmonicVariantChooser.chooseFrom(pitchClass.plusHalfSteps(1).getNoteClasses());
	}

	public NoteClass plusDiatonicStep(Step step) {
		return plusHalfStepsWithDifferentChar(step.getHalfSteps());
	}

	public char getCharacter() { return ncName.charAt(0); }

	public PitchClass getPitchClass() { return pitchClass; }

	public Alteration getAlteration() { return alteration; }

	@Override
	public String toString() {
		return ncName;
	}
}
