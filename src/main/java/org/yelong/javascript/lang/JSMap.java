package org.yelong.javascript.lang;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * JS映射对象
 */
public class JSMap extends JSObject<Map<String, JSObject<?>>> {

	/**
	 * 拓展属性。这个属性仅用于java操作
	 */
	private final Map<String, Object> extendAttributes = new HashMap<String, Object>();

	/**
	 * 使用默认的Map对象来创建JSMap对象
	 * 
	 * @see LinkedHashMap
	 */
	public JSMap() {
		this(new LinkedHashMap<String, JSObject<?>>());
	}

	/**
	 * 使用指定的Map对象来创建JSMap对象
	 * 
	 * @param value 指定的Map对象
	 */
	protected JSMap(Map<String, JSObject<?>> value) {
		super(value);
	}

	// ==================================================attribute==================================================

	// ==================================================util==================================================

	/**
	 * @return 属性的数量
	 */
	public int getAttributeCount() {
		return getValue().size();
	}

	/**
	 * 是否不存在属性
	 * 
	 * @return <code>true</code> 不存在属性
	 */
	public boolean isAttributeEmpty() {
		return getValue().isEmpty();
	}

	// ==================================================get==================================================

	/**
	 * 是否存在某属性名称的属性
	 * 
	 * @param attributeName 属性名称
	 * @return <code>true</code> 存在
	 */
	public boolean containsAttribute(String attributeName) {
		return getValue().containsKey(attributeName);
	}

	/**
	 * 获取属性的值
	 * 
	 * @param attributeName 属性名称
	 * @return 属性的值
	 */
	public JSObject<?> getAttribute(String attributeName) {
		return getValue().get(attributeName);
	}

	/**
	 * 获取属性的值
	 * 
	 * @param attributeName 属性名称
	 * @param defaultValue  不存在属性时的默认值
	 * @return 属性的值。如果不存在该属性则返回默认值
	 */
	@SuppressWarnings("unchecked")
	public <V extends JSObject<?>> V getAttribute(String attributeName, V defaultValue) {
		if (containsAttribute(attributeName)) {
			return (V) getValue().get(attributeName);
		}
		return defaultValue;
	}

	/**
	 * 获取所有的属性名称
	 * 
	 * @return 所有的属性名称
	 */
	public Set<String> getAttributeNames() {
		return getValue().keySet();
	}

	/**
	 * 获取所有的属性值
	 * 
	 * @return 所有的属性值
	 */
	public Collection<JSObject<?>> getAttributeValues() {
		return getValue().values();
	}

	/**
	 * 获取所有的属性对应映射的集合
	 * 
	 * @return 所有的属性对应映射的集合
	 */
	public Set<Entry<String, JSObject<?>>> getAttributeEntrySet() {
		return getValue().entrySet();
	}

	// ==================================================add==================================================

	/**
	 * 添加一个属性
	 * 
	 * @param attributeName 属性名称
	 * @param value         属性值
	 */
	public void addAttribute(String attributeName, JSObject<?> value) {
		getValue().put(attributeName, value);
	}

	/**
	 * 添加映射中所有的属性
	 * 
	 * @param jsMap 被添加的映射
	 */
	public void addAttributeAll(JSMap jsMap) {
		getValue().putAll(jsMap.getValue());
	}

	// ==================================================remove==================================================

	/**
	 * 移除一个属性
	 * 
	 * @param attributeName 属性名称
	 * @return 被移除的属性值。如果不存在该属性则返回 null
	 */
	public JSObject<?> removeAttribute(String attributeName) {
		return getValue().remove(attributeName);
	}

	/**
	 * 清空所有的属性
	 */
	public void clearAttribute() {
		getValue().clear();
	}

	@Override
	public JSCode toJSCode() {
		return new JSCode(getAttributeEntrySet().stream().map(x -> {
			return x.getKey() + ":" + x.getValue().toJSCode().getValue();
		}).collect(Collectors.joining(",", "{", "}")));
	}

	// ==================================================extendAttribute==================================================

	/**
	 * @return 拓展属性
	 */
	public Map<String, Object> getExtendAttributes() {
		return extendAttributes;
	}

}
