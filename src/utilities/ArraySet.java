/**
 * A collection that contains no duplicate elements. More formally, sets contain no pair of elements 
 * e1 and e2 such that e1.equals(e2), and at most one null element. As implied by its name, this 
 * interface models the mathematical set abstraction.
 * 
 * 
 * @author <Caden Parry, Josh Berger>
 * @date <Jan 17 2023>
 */

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

	/**
	 *  Returns the number of elements in this set (its cardinality)
	 *  
	 *  @return integer value of the size of the set
	 */
	@Override
	public int size() 
	{
		return _list.size();
	}

	/**
	 *  Returns true if this set contains no elements
	 *  
	 *  @return boolean value indicating if the set is empty
	 */
	@Override
	public boolean isEmpty() 
	{
		return _list.isEmpty();
	}

	/**
	 *  Returns true if this set contains the specified element
	 *  
	 *  @param o the element whose presence in this set is to be tested
	 *  @return boolean value indicating if the element is present in the set
	 */
	@Override
	public boolean contains(Object o) 
	{
		return _list.contains(o);
	}

	/**
	 *  Returns an iterator over the elements in this set
	 *  
	 *  @return Iterator<E> object that can be used to iterate through the set
	 */
	@Override
	public Iterator<E> iterator() 
	{
		return _list.iterator();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence 
	 * (from first to last element).
	 * 
	 * @return an array containing all of the elements in this list in proper sequence
	 */
	@Override
	public Object[] toArray() 
	{
		return _list.toArray();
	}

	/**
	 *  Returns an array containing all of the elements in this set in the correct order; the runtime type of the returned array is that of the specified array
	 *  
	 *  @param a the array into which the elements of this set are to be stored
	 *  @return array of elements in the set
	 */
	@Override
	public <T> T[] toArray(T[] a) 
	{
		return _list.toArray(a);
	}

	/**
	 *  Adds the specified element to this set if it is not already present (optional operation)
	 *  
	 *  @param e element to be added to this set
	 *  @return boolean value indicating if the element was added
	 */
	@Override
	public boolean add(E e) 
	{
		//does not allow null to be entered
		if(e == null) return false;

		//add only if the element is not already in the set
		if(!contains(e))
		{
			return _list.add(e);
		}
		return false;
	}

	/**
	 * Removes the first occurrence of the specified element from this list, if it is 
	 * present (optional operation). If this list does not contain the element, it is 
	 * unchanged.
	 * 
	 * @param o element to be removed from this list, if present
	 * @return true if this list contained the specified element
	 * 
	 */
	@Override
	public boolean remove(Object o) 
	{
		return _list.remove(o);
	}

	/**
	 * Returns true if this list contains all of the elements of the specified collection.
	 * 
	 * @param c collection to be checked for containment in this list
	 * @return true if this list contains all of the elements of the specified collection
	 */
	@Override
	public boolean containsAll(Collection<?> c) 
	{
		return _list.containsAll(c);
	}

	/**
	 * Appends all of the elements in the specified collection to the end of this list, in 
	 * the order that they are returned by the specified collection's iterator
	 * (optional operation). 
	 * 
	 * @paramc collection containing elements to be added to this list
	 * @return true if this list changed as a result of the call
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) 
	{

		//initially set to false, will be set to true if an element is added
		boolean addCheck = false;

		for(E element : c)
		{
			if(add(element));
			{
				//valid becomes true if an element in the collection is added
				addCheck = true;
			}
		}
		return addCheck;
	}

	/**
	 * Retains only the elements in this list that are contained in the specified 
	 * collection (optional operation).
	 *
	 * @param c collection containing elements to be retained in this list
	 * @return true if this list changed as a result of the call
	 */
	@Override
	public boolean retainAll(Collection<?> c) 
	{
		return _list.retainAll(c);
		/*
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
		*/
	}

	/**
	 * Retains only the elements in this list that are contained in the specified 
	 * collection (optional operation). In other words, removes from this list 
	 * all of its elements that are not contained in the specified collection.
	 * 
	 * @param c collection containing elements to be removed from this list
	 * @return true if this list changed as a result of the call
	 */
	@Override

	public boolean removeAll(Collection<?> c) 
	{
		return _list.removeAll(c);
	}

	/**
	 * Removes all of the elements from this list (optional operation).The list will be 
	 * empty after this call returns.
	 */
	@Override
	public void clear() 
	{
		_list.clear();
	}

	/**
	 * Inserts all of the elements in the specified collection into this list at the specified
	 * position (optional operation). Shifts the element currently at that position (if any)
	 * and any subsequent elements to the right (increases their indices). The new elements will
	 * appear in this list in the order that they are returned by the specified collection's 
	 * iterator. The behavior of this operation is undefined if the specified collection is
	 * modified while the operation is in progress. (Note that this will occur if the specified
	 * collection is this list, and it's nonempty.)
	 * 
	 * @param index index at which to insert the first element from the specified collection 
	 * @param c collection containing elements to be added to this list
	 * @return true if this list changed as a result of the call
	 */
	@Override

	public boolean addAll(int index, Collection<? extends E> c) 
	{
		//initially set to false, will be set to true if an element is added
		boolean valid = false;

		//loop through elements and add non-duplicates
		for(E element : c)
		{
			if(!contains(element))
			{
				add(index, element);
				index++;

				//valid becomes true if an element in the collection is added
				valid = true;
			}
		}
		return valid;
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 */
	@Override

	public E get(int index) 
	{
		return _list.get(index);

	}



	/**
	 * Replaces the element at the specified position in this list with the specified
	 * element (optional operation).
	 * 
	 * @param index index of the element to replace
	 * @param element element to be stored at the specified position
	 * @return the element previously at the specified position
	 */
	@Override
	public E set(int index, E element) 
	{
		if(_list.contains(element))
		{
			return null;
		}
		return _list.set(index, element);
	}

	/**
	 * Inserts the specified element at the specified position in this list 
	 * (optional operation). Shifts the element currently at that position 
	 * (if any) and any subsequent elements to the right (adds one to their indices).
	 * 
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 */
	@Override
	public void add(int index, E element) 
	{
		//add only if the element is not already in the set
		if(!contains(element))
		{
			_list.add(index, element);
		}
	}

	/**
	 * Removes the element at the specified position in this list (optional operation).
	 * 
	 * @param index the index of the element to be removed
	 * @return the element previously at the specified position
	 */
	@Override
	public E remove(int index) 
	{
		return _list.remove(index);
	}

	/**
	 * Returns the index of the first occurrence of the specified element in this list, or -1 if this 
	 * list does not contain the element.
	 * 
	 * @param o element to search for
	 * @return the index of the first occurrence of the specified element in this list,
	 * or -1 if this list does not contain the element
	 */
	@Override
	public int indexOf(Object o) 
	{
		return _list.indexOf(o);
	}

	/**
	 * Returns the index of the last occurrence of the specified element in this list, or -1 if this
	 * list does not contain the element. 
	 *  
	 * @param o element to search for
	 * @return the index of the last occurrence of the specified element in this list , or -1 if this 
	 * list does not contain the element
	 */
	@Override
	public int lastIndexOf(Object o) 
	{
		return _list.lastIndexOf(o);
	}

	/**
	 * Returns a list iterator over the elements in this list (in proper sequence).
	 * 
	 * @return a list iterator over the elements in this list (in proper sequence)
	 */
	@Override
	public ListIterator<E> listIterator() 
	{
		return _list.listIterator();
	}

	/**`
	 * Returns a list iterator over the elements in this list (in proper sequence), starting 
	 * at the specified position in the list. 
	 * 
	 * @param index index of the first element to be returned from the list iterator (by a call to next)
	 * @return a list iterator over the elements in this list (in proper sequence), starting at
	 * the specified position in the list
	 */
	@Override
	public ListIterator<E> listIterator(int index) 
	{
		return _list.listIterator(index);
	}

	/**
	 * Returns a view of the portion of this list between the specified fromIndex, inclusive,
	 * and toIndex, exclusive. 
	 * 
	 * @param fromIndex low endpoint (inclusive) of the subList
	 * @param toIndex high endpoint (exclusive) of the subList
	 * @return a view of the specified range within this list
	 */
	@Override
	public List<E> subList(int fromIndex, int toIndex)
	{
		return _list.subList(fromIndex, toIndex);
	}

	/**
	 * The Spliterator reports Spliterator.SIZED and Spliterator.ORDERED. Implementations should
	 * document the reporting of additional characteristic values.
	 * 
	 * @return a Spliterator over the elements in this list
	 */
	@Override
	public Spliterator<E> spliterator() 
	{
		return _list.spliterator();
	}

	public String toString()
	{
		return _list.toString();
	}
}
