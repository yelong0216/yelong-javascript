package org.yelong.javascript.lang;

/**
 * JS变量
 */
public class JSVariate extends JSUnknownObject {

	public static final String VAR_NAME = "var";

	/**
	 * 变量名称
	 */
	private final String varName;

	/**
	 * 变量的值。支持 <code>null</code>
	 */
	private final JSObject<?> jsObject;

	public JSVariate(String varName) {
		this(varName, null);
	}

	public JSVariate(String varName, JSObject<?> jsObject) {
		this.varName = Validator.requireNonBlank(varName);
		this.jsObject = jsObject;
	}

	public String getVarName() {
		return varName;
	}

	public JSObject<?> getJsObject() {
		return jsObject;
	}

	@Override
	public JSCode toJSCode() {
		StringBuilder code = new StringBuilder(VAR_NAME).append(" ").append(varName).append("=");
		if (null == jsObject) {
			code.append("null");
		} else {
			code.append(jsObject.toJSCode().getValue());
		}
		code.append(";");
		return new JSCode(code.toString());
	}

}
