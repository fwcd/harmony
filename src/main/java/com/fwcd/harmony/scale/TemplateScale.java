package com.fwcd.harmony.scale;

abstract class TemplateScale implements Scale {
	@Override
	public String toString() {
		return getNotes().toString();
	}
}