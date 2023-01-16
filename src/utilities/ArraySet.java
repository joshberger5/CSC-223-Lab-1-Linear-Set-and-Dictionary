package utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Spliterator;

public class ArraySet<E> implements List<E>, Set<E>
{
	protected ArrayList<E> _list;
	
	public ArraySet() 
	{
		_list = new ArrayList<E>();
	}

	@Override
	public int size() 
	{
		return _list.size();
	}

	@Override
	public boolean isEmpty() 
	{
		return _list.isEmpty();
	}

	@Override
	public boolean contains(Object o) 
	{
		return _list.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return _list.iterator();
	}

	@Override
	public Object[] toArray() 
	{
		return _list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) 
	{
		return _list.toArray(a);
	}

	@Override
	public boolean add(E e) 
	{
		if(contains(e))
		{
			return false;
		}
		return _list.add(e);
	}

	@Override
	public boolean remove(Object o) 
	{
		return _list.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return _list.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) 
	{
		// adds the stuff that is passed in except if it is already in the set
		boolean valid = false;
		for(E element : c)
		{
			if(!contains(element))
			{
				add(element);
				valid = true;
			}
		}
		return valid;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// this set only keeps the stuff that is passed in
		boolean change = false;
		// the below for loop goes from back to front so you don't lose your place when remove stuff
		for (int i = size() - 1; i >= 0; i--) {
			if (!c.contains(get(i))) {
				remove(i);
				change = true;
			}
		}
		return change;
	}

	@Override
	public boolean removeAll(Collection<?> c) { 
		// this set removes all the stuff that is passed in
		boolean change = false;
		for (Object cElement : c) {
			if (contains(cElement)) {
				remove(cElement);
				change = true;
			}
		}
		return change;
	}

	@Override
	public void clear() {
		_list.clear();
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// adds everything that is passed in at the specified index and moves everything already there to the right
		boolean changed = false;
		for (E element : c) {
			if (!contains(element)) {
				add(index, element);
				changed = true;
				index++;
			}
		}
		return changed;
	}

	@Override
	public E get(int index) {
		return _list.get(index);
	}

	@Override
	public E set(int index, E element) {
		return _list.set(index, element);
	}

	@Override
	public void add(int index, E element) 
	{
		if(!contains(element))
		{
			_list.add(index, element);
		}
	}

	@Override
	public E remove(int index) {
		return _list.remove(index);
	}

	@Override
	public int indexOf(Object o) 
	{
		return _list.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return _list.lastIndexOf(o);
	}

	@Override
	public ListIterator<E> listIterator() 
	{
		return _list.listIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) 
	{
		return _list.listIterator(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex)
	{
		return _list.subList(fromIndex, toIndex);
	}

	
	@Override
	public Spliterator<E> spliterator() 
	{
		return _list.spliterator();
	}
}
