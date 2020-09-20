package org.yelong.javascript.lang;

public final class JSBoolean extends JSObject<Boolean> {

	public JSBoolean(boolean value) {
		super(value);
	}

	@Override
	public JSCode toJSCode() {
		return new JSCode(getValue() + "");
	}

}
