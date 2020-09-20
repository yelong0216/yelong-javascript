package org.yelong.javascript.lang;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * JS集合对象
 * 
 * @param <E> element type
 */
public interface JSCollection<E extends JSObject<?>> extends JSCodeConvertible {

	/**
	 * @return 集合中元素的数量
	 */
	public int size();

	/**
	 * 集合是否不存在元素
	 * 
	 * @return <code>true</code>集合中不存在元素
	 */
	public boolean isEmpty();

	/**
	 * 集合中是否包含某元素
	 * 
	 * @param element 判断是否被包含的元素对象
	 * @return <code>true</code> 集合中包含该元素
	 */
	public boolean contains(E element);

	/**
	 * 添加一个元素到集合中
	 * 
	 * @param element 被添加的到集合中的元素
	 */
	public void add(E element);

	/**
	 * 移除集合中指定的元素。如果这个元素出现多次，这只会移除第一次出现的那个元素。
	 * 
	 * @param element 被移除的元素
	 * @return <code>true</code> 成功移除 <code>false</code> 元素不存在
	 */
	public boolean remove(E element);

	/**
	 * 将集合中的所有元素添加到该集合中
	 * 
	 * @param jsCollection 需要添加的元素集合
	 */
	public void addAll(JSCollection<? extends E> jsCollection);

	/**
	 * 
	 * 移除指定集合中的所有出现的元素
	 * 
	 * @param jsCollection 需要被移除的元素集合
	 */
	public void removeAll(JSCollection<E> jsCollection);

	/**
	 * 清空集合
	 */
	public void clear();

	/**
	 * 获取集合中所有的元素
	 * 
	 * @return 集合中所有的元素
	 */
	public Collection<E> getCollection();

	@Override
	default JSCode toJSCode() {
		return new JSCode(getCollection().stream().map(JSObject::toJSCode).map(JSCode::getValue)
				.collect(Collectors.joining(",", "[", "]")));
	}

}
