package fwcd.harmony;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import fwcd.harmony.utils.Lazy;

public class KeySignature {
	private final Lazy<Set<NoteClass>> noteClasses;
	private final Alteration symbolType;

	public KeySignature() {
		noteClasses = Lazy.literal(Collections.emptySet());
		symbolType = Alteration.NONE;
	}

	public KeySignature(Alteration symbolType, String... noteNames) {
		this.symbolType = symbolType;
		noteClasses = Lazy.of(() -> Arrays.stream(noteNames).map(NoteClass::of).collect(Collectors.toSet()));
	}

	public KeySignature(Alteration symbolType, NoteClass... noteClasses) {
		this.symbolType = symbolType;
		this.noteClasses = Lazy.literalSet(noteClasses);
	}

	public Alteration getSymbolType() { return symbolType; }

	public Set<NoteClass> getNoteClasses() { return noteClasses.get(); }
}
