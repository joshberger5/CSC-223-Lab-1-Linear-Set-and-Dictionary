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
		for (int i = 0; i < size(); i++) {
			if (key == _keys.get(i)) {
				return _values.get(i);
			}
		}
		return null;
	}

	@Override
	public Value put(Key key, Value value) {
		for (int i = 0; i < size(); i++) {
			if (key.equals(_keys.get(i))) {
				Value temp = _values.get(i);
				_values.remove(i);
				_values.add(i, value);
				return temp;
			}
		}
		_keys.add(key);
		_values.add(value);
		return null;
	}
	
	@Override
	public Value remove(Object key) {
		for (int i = 0; i < size(); i++) {
			if (key.equals(_keys.get(i))) {
				Value temp = _values.get(i);
				_keys.remove(i);
				_values.remove(i);
				return temp;
			}
		}
		return null;
	}

	/*
	checks to see if the map already includes a key to be copied
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

	@Override
	public Set<Entry<Key, Value>> entrySet() {
		return null;
	}

}
