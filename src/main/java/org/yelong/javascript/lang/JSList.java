package org.yelong.javascript.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * JS集合类型
 */
public class JSList<E extends JSObject<?>> extends JSObject<List<E>> implements JSCollection<E> {

	/**
	 * 使用默认的集合对象来创建JS集合对象
	 * 
	 * @see ArrayList
	 */
	public JSList() {
		this(new ArrayList<E>());
	}

	/**
	 * 指定对应的集合类型来创建JS集合对象
	 * 
	 * @param value 指定的集合对象
	 */
	public JSList(List<E> value) {
		super(value);
	}

	@Override
	public int size() {
		return getValue().size();
	}

	@Override
	public boolean isEmpty() {
		return getValue().isEmpty();
	}

	@Override
	public boolean contains(E element) {
		return getValue().contains(element);
	}

	@Override
	public void add(E element) {
		getValue().add(element);
	}

	/**
	 * 将元素添加到指定的位置
	 * 
	 * @param index   位置
	 * @param element 对象
	 */
	public void add(int index, E element) {
		getValue().add(index, element);
	}

	public void sort(Comparator<? super E> c) {
		getValue().sort(c);
	}

	@Override
	public boolean remove(E element) {
		return getValue().remove(element);
	}

	@Override
	public void addAll(JSCollection<? extends E> jsCollection) {
		getValue().addAll(jsCollection.getCollection());
	}

	@Override
	public void removeAll(JSCollection<E> jsCollection) {
		getValue().removeAll(jsCollection.getCollection());
	}

	@Override
	public void clear() {
		getValue().clear();
	}

	@Override
	public Collection<E> getCollection() {
		return getValue();
	}

}
