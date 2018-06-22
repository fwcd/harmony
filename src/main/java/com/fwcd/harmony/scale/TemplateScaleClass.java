package com.fwcd.harmony.scale;

abstract class TemplateScaleClass implements ScaleClass {
	@Override
	public String toString() {
		return getNotes().toString();
	}
}