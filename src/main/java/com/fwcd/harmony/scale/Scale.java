package com.fwcd.harmony.scale;

import java.util.List;

import com.fwcd.harmony.Note;

public interface Scale {
	Note getKey();

	/**
	 * Returns the notes from the key upwards.
	 */
	List<Note> getNotes();
}