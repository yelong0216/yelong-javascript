package org.yelong.javascript.lang;

import java.util.Objects;

/**
 * JS对象。这是所有JS对象的超类。可以转换为JS代码。
 *
 * @param <T> JS对象对应的Java对象类型
 */
public abstract class JSObject<T> implements JSCodeConvertible{

	/**
	 * 对应的Java对象
	 */
	private final T value;

	/**
	 * 这个对象不支持直接实例化，必须实例化其子类
	 * 
	 * @param value 对应的Java对象。这个对象不允许为 <code>null</code>
	 */
	protected JSObject(final T value) {
		this.value = Objects.requireNonNull(value);
	}

	/**
	 * @return 对应的java类型对象
	 */
	public T getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof JSObject) {
			JSObject<?> jsObject = (JSObject<?>) obj;
			return value.equals(jsObject.value);
		}
		return false;
	}

	@Override
	public String toString() {
		return toJSCode().getValue();
	}

}
