
/**
 * This class implements the Map interface.
* It overrides the abstract methods of the Map interface.
 *
 * <p>Bugs: (a list of bugs and / or other problems)
 *
 * @author Joshua Berger, Caden Parry
 * @date <Jan 17 2023>
 */

package utilities;

import java.util.Collection;

import java.util.AbstractMap;
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
	
	/**
	 * Returns the number of key-value mappings in this map. If the map contains more
	 * than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
	 * 
	 * @return the number of key-value mappings in this map
	 */
	@Override
	public int size() 
	{
		return _values.size();
	}

	/**
	 * Returns true if this map contains no key-value mappings.
	 * 
	 * @return true if this map contains no key-value mappings
	 */
	@Override
	public boolean isEmpty() 
	{
		return _keys.isEmpty();
	}

	/**
	 * Returns true if this map contains a mapping for the specified key.
	 * 
	 * @param key key whose presence in this map is to be tested
	 * @return true if this map contains a mapping for the specified key
	 */
	@Override
	public boolean containsKey(Object key) 
	{
		return _keys.contains(key);
	}

	/**
	 * Returns true if this map maps one or more keys to the specified value.
	 * 
	 * @param value value whose presence in this map is to be tested
	 * @return true if this map maps one or more keys to the specified value
	 */
	@Override
	public boolean containsValue(Object value) 
	{
		return _values.contains(value);
	}

	/**
	 * Returns the value to which the specified key is mapped, or null if this map contains
	 * no mapping for the key.
	 * 
	 * @param key the key whose associated value is to be returned
	 * @return true if this map maps one or more keys to the specified value
	 * 
	 */
	@Override
	public Value get(Object key) 
	{
		if(!containsKey(key)) return null;
		return _values.get(_keys.indexOf(key));
	}

	/**
	 * Associates the specified value with the specified key in this map (optional operation). 
	 * 
	 * @param key key with which the specified value is to be associated
	 * @param value value to be associated with the specified key
	 * @return the previous value associated with key, or null if there was no mapping for key.
	 * (A null return can also indicate that the map previously associated null with key, if the
	 * implementation supports null values.)
	 */
	@Override
	public Value put(Key key, Value value) 
	{
		if(key == null || value == null) return null;
		if(_keys.contains(key))
		{
			return _values.set(_keys.indexOf(key), value);
		}

		_keys.add(key); 
		_values.add(value);

		return null;
	}

	/**
	 * Removes the mapping for a key from this map if it is present (optional operation).
	 * 
	 * @param key key whose mapping is to be removed from the map
	 * @return the previous value associated with key, or null if there was no mapping for key.
	 */
	public Value remove(Object key) 
	{	
		if(!containsKey(key)) return null;

		Value v = _values.remove(_keys.indexOf(key));
		_keys.remove(_keys.indexOf(key));
		return v;		
	}

	/**
	 * Copies all of the mappings from the specified map to this map (optional operation). 
	 * 
	 * @param m mappings to be stored in this map
	 */
	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) 
	{
		for (Entry<? extends Key, ? extends Value> entry : m.entrySet())
		{
			put(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * Removes all of the mappings from this map (optional operation). The map will be empty after this call returns.
	 */
	@Override
	public void clear() 
	{
		_keys.clear();
		_values.clear();
	}

	/** 
	 * Returns a Set view of the keys contained in this map. 
	 * 
	 * @return a set view of the keys contained in this map
	 */
	@Override
	public Set<Key> keySet() 
	{
		return _keys;
	}

	/**
	 * Returns a Collection view of the values contained in this map.
	 * 
	 * @return a collection view of the values contained in this map
	 */
	@Override
	public Collection<Value> values() 
	{
		return _values;
	}

	/**
	 * Returns a Set view of the mappings contained in this map.
	 * 
	 * @return a set view of the mappings contained in this map
	 */
	@Override
	public Set<Entry<Key, Value>> entrySet() 
	{
		//create map to be returned
		Set<Map.Entry<Key, Value>> entries = new ArraySet<>();

		//create a loop that will runs size() number of times
		for (int i = 0; i < size(); i++) 
		{
			//crazy scary fancy add
			entries.add(new AbstractMap.SimpleEntry<>(_keys.get(i), _values.get(i)));
		}
		return entries;	
	}
}
