package org.yelong.javascript.lang;

/**
 * JS变量名称。该对象一般用在属性值上面。
 * 
 * var name = "123";
 * 
 * var myName = name;
 * 
 */
public class JSVariateName extends JSObject<String> {

	public JSVariateName(String varName) {
		super(Validator.requireNonBlank(varName));
	}

	@Override
	public JSCode toJSCode() {
		return new JSCode(getValue());
	}

}
