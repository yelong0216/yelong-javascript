package org.yelong.javascript.lang;

import java.util.stream.Collectors;

/**
 * JS普通的函数
 * 
 * function getName(){}
 * 
 */
public class JSFunction extends JSAbstractFunction {

	/**
	 * 函数名称
	 */
	private final String name;

	/**
	 * @param name 函数名称。不允许为空白字符串
	 */
	public JSFunction(String name) {
		this.name = Validator.requireNonBlank(name);
	}

	/**
	 * @return 函数名称
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public JSCode toJSCode() {
		StringBuilder code = new StringBuilder();
		code.append(FUNCTION_NAME);
		code.append(" "+name);
		code.append(getParameters().stream().map(JSFunctionParameter::getName).collect(Collectors.joining(",", "(", ")")));
		code.append("{");
		JSCode functionCode = getFunctionCode();
		if (null != getFunctionCode()) {
			code.append(functionCode.getValue());
		}
		code.append("}");
		return new JSCode(code.toString());
	}

}
