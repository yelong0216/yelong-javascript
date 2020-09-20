package org.yelong.javascript.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 抽象的JS函数
 */
public abstract class JSAbstractFunction extends JSUnknownObject {

	public static final String FUNCTION_NAME = "function";

	/**
	 * 函数的参数
	 */
	private final List<JSFunctionParameter> parameters = new ArrayList<JSFunctionParameter>();

	/**
	 * 函数的返回值类型。返回值类型是允许多个的。如果这个集合为空，可能该函数没有返回值
	 */
	private final List<Class<? extends JSObject<?>>> returnTypes = new ArrayList<Class<? extends JSObject<?>>>();

	/**
	 * 函数的代码内容
	 */
	private JSCode functionCode;

	// ==================================================parameter==================================================

	/**
	 * 添加一个函数参数
	 * 
	 * @param jsParameter JS函数参数
	 */
	public void addParameter(JSFunctionParameter jsParameter) {
		parameters.add(jsParameter);
	}

	/**
	 * 添加多个函数参数
	 * 
	 * @param jsParameters 函数参数集合
	 */
	public void addParameters(List<JSFunctionParameter> jsParameters) {
		parameters.addAll(jsParameters);
	}

	/**
	 * 获取函数的所有参数，并根据参数出现顺序进行排序
	 * 
	 * @return 函数的所有参数并根据参数出现顺序进行排序
	 */
	public List<JSFunctionParameter> getParameters() {
		return parameters.stream().sorted().collect(Collectors.toList());
	}

	// ==================================================returnType==================================================

	/**
	 * 添加一个返回值类型
	 * 
	 * @param returnType 返回值类型
	 */
	public void addReturnType(Class<? extends JSObject<?>> returnType) {
		this.returnTypes.add(returnType);
	}

	/**
	 * 添加多个返回值类型
	 * 
	 * @param returnTypes 返回值类型集合
	 */
	public void addReturnTypes(List<Class<? extends JSObject<?>>> returnTypes) {
		this.returnTypes.addAll(returnTypes);
	}

	/**
	 * 获取函数的所有返回值类型
	 * 
	 * @return 函数的所有返回值类型数组
	 */
	public List<Class<? extends JSObject<?>>> getReturnTypes() {
		return returnTypes;
	}

	// ==================================================functionCode==================================================

	/**
	 * 获取函数的代码内容
	 * 
	 * @return 函数的代码内容
	 */
	public JSCode getFunctionCode() {
		return functionCode;
	}

	/**
	 * 设置函数的代码内容
	 * 
	 * @param functionCode 函数代码内容
	 */
	public void setFunctionCode(JSCode functionCode) {
		this.functionCode = functionCode;
	}

}
