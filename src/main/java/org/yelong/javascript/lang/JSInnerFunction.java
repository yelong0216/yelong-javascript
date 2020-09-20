package org.yelong.javascript.lang;

import java.util.stream.Collectors;

/**
 * JS内部函数。无需指定函数名称
 * 
 * function(){}
 * 
 */
public class JSInnerFunction extends JSAbstractFunction {

	@Override
	public JSCode toJSCode() {
		StringBuilder code = new StringBuilder();
		code.append(FUNCTION_NAME);
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
