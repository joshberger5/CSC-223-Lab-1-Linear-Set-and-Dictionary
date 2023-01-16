package utilities;

import java.util.Collection;
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

	@Override
	public boolean containsValue(Object value) {
		return _values.contains(value);
	}

	@Override
	public Value get(Object key) {
		// checks to see if the passed in key is the same as one of the keys the dictionary already has
		// then it returns the value at the corresponding index in the dictionary
		for (int i = 0; i < size(); i++) {
			if (key.equals(_keys.get(i))) {
				return _values.get(i);
			}
		}
		// returns null if the key is not in the dictionary
		return null;
	}

	@Override
	public Value put(Key key, Value value) {
		// if the passed-in key is the same as one of the existing keys, replace its value with the one passed in
		for (int i = 0; i < size(); i++) {
			if (key.equals(_keys.get(i))) {
				Value temp = _values.get(i);
				_values.remove(i);
				_values.add(i, value);
				return temp;
			}
		}
		// if the passed key is not in the dictionary add it and the passed value
		_keys.add(key);
		_values.add(value);
		return null;
	}
	
	@Override
	public Value remove(Object key) {
		// if the passed key is in the dictionary remove it and return its key
		for (int i = 0; i < size(); i++) {
			if (key.equals(_keys.get(i))) {
				Value temp = _values.get(i);
				_keys.remove(i);
				_values.remove(i);
				return temp;
			}
		}
		// if it is not in the 
		return null;
	}

	/*
	for each key in the passed map checks to see if the dictionary already includes it
	if so, replace the value
	if not, add the key and value
	*/
	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) {
		for (Entry<? extends Key, ? extends Value> e : m.entrySet()) {
			boolean repeat = false;
			for (int i = 0; i < size(); i++) {
				if (_keys.get(i).equals(e.getKey())) {
					repeat = true;
					_values.remove(i);
					_values.add(i, e.getValue());
				}
			}
			if (repeat == false) {
			_keys.add(e.getKey());
			_values.add(e.getValue());
			}
		}
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

	// I have absolutely no idea how to do this one
	@Override
	public Set<Entry<Key, Value>> entrySet() {
		/* ArraySet<Entry<Key, Value>> s = new ArraySet<Entry<Key, Value>>();
		for (int i = 0; i < _keys.size(); i++) {
			s.add(entry(_keys.get(i),_values.get(i)));
		}
		return s; */
		return null;
	}

}
