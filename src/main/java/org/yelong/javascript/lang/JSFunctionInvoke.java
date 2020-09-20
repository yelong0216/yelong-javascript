package org.yelong.javascript.lang;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * JS函数调用 functionName(param1,param2,...);
 */
public class JSFunctionInvoke extends JSUnknownObject {

	public static final String FUNCTION_NAME = "function";

	private final String functionName;

	private final JSObject<?>[] functionParams;

	public JSFunctionInvoke(String functionName, JSObject<?>... functionParams) {
		this.functionName = Validator.requireNonBlank(functionName);
		this.functionParams = functionParams;
	}

	public String getFunctionName() {
		return functionName;
	}

	public JSObject<?>[] getFunctionParams() {
		return functionParams;
	}

	@Override
	public JSCode toJSCode() {
		return new JSCode(Arrays.asList(functionParams).stream().map(x -> x.toJSCode().getValue())
				.collect(Collectors.joining(",", functionName + "(", ")")));
	}

}
