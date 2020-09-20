/**
 * 
 */
package org.yelong.javascript.lang;

import org.apache.commons.lang3.StringUtils;

/**
 * 验证器工具类，提供常用的验证方法
 */
public final class Validator {
	
	private Validator() {
	}

	/**
	 * 验证字符串是否是空白字符
	 * 
	 * @param c 需要验证的字符串
	 * @return c
	 */
	public static <T extends CharSequence> T requireNonBlank(T c) {
		if (StringUtils.isBlank(c)) {
			throw new IllegalArgumentException();
		}
		return c;
	}
	
}
