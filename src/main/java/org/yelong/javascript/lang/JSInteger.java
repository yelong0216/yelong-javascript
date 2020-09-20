package org.yelong.javascript.lang;

/**
 * JS数值类型
 */
public class JSInteger extends JSObject<Integer> {

	public JSInteger(Integer value) {
		super(value);
	}

	@Override
	public JSCode toJSCode() {
		return new JSCode(getValue().toString());
	}

}
