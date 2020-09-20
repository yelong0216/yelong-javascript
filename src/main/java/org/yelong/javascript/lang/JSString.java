package org.yelong.javascript.lang;

/**
 * JS字符串
 */
public class JSString extends JSObject<String> {

	public JSString(String value) {
		super(value);
	}

	@Override
	public JSCode toJSCode() {
		return new JSCode("\"" + getValue() + "\"");
	}

}
