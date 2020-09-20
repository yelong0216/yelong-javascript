package org.yelong.javascript.lang;

/**
 * JS代码
 */
public class JSCode extends JSObject<String> {

	public JSCode(String value) {
		super(value);
	}

	@Override
	public JSCode toJSCode() {
		return this;
	}

	@Override
	public String toString() {
		return getValue();
	}

}
