package org.yelong.javascript.lang;

/**
 * 不知道映射的Java对象类型的JS对象
 * 
 * @see UnknownObject
 */
public abstract class JSUnknownObject extends JSObject<UnknownObject> {

	protected JSUnknownObject() {
		super(UnknownObject.INSTANCE);
	}

}
