package org.yelong.javascript.lang;

/**
 * JS函数参数
 */
public class JSFunctionParameter implements Comparable<JSFunctionParameter> {

	/**
	 * 参数名称
	 */
	private final String name;

	/**
	 * 参数顺序
	 */
	private final int index;

	public JSFunctionParameter(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public int compareTo(JSFunctionParameter o) {
		return Integer.compare(index, o.index);
	}

}
