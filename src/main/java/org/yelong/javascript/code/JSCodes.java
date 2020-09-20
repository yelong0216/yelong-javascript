package org.yelong.javascript.code;

import java.util.List;
import java.util.stream.Collectors;

import org.yelong.javascript.lang.JSObject;

/**
 * JS代码工具类
 */
public final class JSCodes {

	private JSCodes() {
	}

	/**
	 * 将多个JS对象转换为JS代码字符串
	 * 
	 * @param jsObjects JS对象集合
	 * @return JS代码字符串
	 */
	public static String toJSCode(List<JSObject<?>> jsObjects) {
		return jsObjects.stream().map(x -> x.toJSCode().getValue()).collect(Collectors.joining());
	}

	/**
	 * 将JS对象转换为JS代码字符串
	 * 
	 * @param jsObject JS对象
	 * @return JS代码字符串
	 */
	public static String toJSCode(JSObject<?> jsObject) {
		return jsObject.toJSCode().getValue();
	}

}
