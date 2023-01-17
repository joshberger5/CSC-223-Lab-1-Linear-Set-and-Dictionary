/*
* This class implements the Map interface.
* It overrides the abstract methods of the Map interface.
*
* <p>Bugs: (a list of bugs and / or other problems)
*
* @author Joshua Berger, Caden Parry
* @date 1/17/2023
*/

package utilities;

import java.util.Collection;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class ParallelArrayDictionary<Key, Value> implements Map<Key, Value>
{

	protected ArraySet<Key> _keys;
	protected ArrayList<Value> _values;
	
	public ParallelArrayDictionary()
	{
		_keys = new ArraySet<Key>();
		_values = new ArrayList<Value>();
	}

	@Override
	public int size() {
		return _keys.size();
	}

	@Override
	public boolean isEmpty() {
		return _keys.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return _keys.contains(key);
	}
	
	private int indexOf(Object key) {
		for (int i = 0; i < size(); i++) {
			if (key.equals(_keys.get(i))) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean containsValue(Object value) {
		return _values.contains(value);
	}

	@Override
	public Value get(Object key) {
		// checks to see if the passed in key is the same as one of the keys the dictionary already has
		// then it returns the value at the corresponding index in the dictionary
		int index = indexOf(key);
		if (index > -1) return _values.get(index);
		// returns null if the key is not in the dictionary
		return null;
	}
	
	@Override
	public Value remove(Object key) {
		// if the passed key is in the dictionary remove it and return its key
		int index = indexOf(key);
		if (index > -1) {
			Value temp = _values.get(index);
			_keys.remove(index);
			_values.remove(index);
			return temp;
		}
		// if the passed key is not in the dictionary return null
		return null;
	}

	// calls put for each key in the map that is passed in
	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) {
		for (Entry<? extends Key, ? extends Value> e : m.entrySet()) {
			put(e.getKey(), e.getValue());
		}
	}
	
	@Override
	public Value put(Key key, Value value) {
		// if the passed-in key is the same as one of the existing keys, replace its value with the one passed in
		int index = indexOf(key);
		if (index > -1) {
			Value temp = _values.get(index);
			_values.remove(index);
			_values.add(index, value);
			return temp;
		}
		// if the passed key is not in the dictionary add it and the passed value
		_keys.add(key);
		_values.add(value);
		return null;
	}

	@Override
	public void clear() {
		_keys.clear();
		_values.clear();
	}

	@Override
	public Set<Key> keySet() {
		return _keys;
	}

	@Override
	public Collection<Value> values() {
		return _values;
	}

	// still don't really understand
	@Override
	public Set<Entry<Key, Value>> entrySet() {
		/* 
		Set<Entry<Key, Value>> s = new HashSet<Entry<Key, Value>>();
		for (int i = 0; i < size(); i++) {
		}
		*/
		return null;
	}

}
