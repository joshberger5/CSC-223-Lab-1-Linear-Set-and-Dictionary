/**
>>>>>>> Stashed changes
* This class tests the implementation of ParallelArrayDictionary.
* It attests to the functionality of the default constructor and the methods:
* get(), put(), remove(), putAll(), clear()
*
* <p>Bugs: (a list of bugs and / or other problems)
*
* @author Joshua Berger, Caden Parry
* @date 1/17/2023
*/

package utilities;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;


import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
	@Test
	void testParallelArrayDictionary()
	{
		//test existence with size 0
		ParallelArrayDictionary<Integer, String> dict = new ParallelArrayDictionary<Integer, String>();
		assertEquals(0, dict.size());
		assertTrue(dict.isEmpty());

	}

	@Test
	void testGet()
	{
		//dictionary
		ParallelArrayDictionary<Integer, String> dict = new ParallelArrayDictionary<Integer, String>();

		//get from an empty list
		assertNull(dict.get(0));

		//populate dict
		assertNull(dict.put(001, "001"));
		assertNull(dict.put(002, "002"));
		assertNull(dict.put(007, "James Bond"));

		//get basic values
		assertEquals("001", dict.get(001));
		assertEquals("002", dict.get(002));
		assertEquals("James Bond", dict.get(007));

		//get a key that does not exist
		assertNull(dict.get(99));

		//make sure get() didnt add/remove anything
		assertEquals("[1=001, 2=002, 7=James Bond]", dict.entrySet().toString());
	}

	@Test
	void testPut()
	{
		ParallelArrayDictionary<Integer, String> dict = new ParallelArrayDictionary<Integer, String>();

		//null key: should not add
		assertNull(dict.put(null, "car"));

		//null value: should not add
		assertNull(dict.put(99, null));

		//both null: should add (who cares, it wont show up)
		assertNull(dict.put(null, null));

		//empty string: should add
		assertNull(dict.put(48, ""));

		//normal: should add
		assertNull(dict.put(001, "001"));
		assertNull(dict.put(002, "002"));
		assertNull(dict.put(007, "James Bond"));

		//duplicate: should not show up twice
		assertEquals("001", dict.put(001, "001"));

		//check containment: make sure all is well and duplicate/single nulls were not added
		assertEquals("[48=, 1=001, 2=002, 7=James Bond]", dict.entrySet().toString());
	}

	@Test
	void testPutRemovePut()
	{
		//create and populate
		ParallelArrayDictionary<Integer, String> dict = new ParallelArrayDictionary<Integer, String>();
		assertNull(dict.put(000, "000"));
		assertNull(dict.put(001, "001"));
		assertNull(dict.put(002, "002"));
		assertNull(dict.put(007, "James Bond"));
		assertEquals("[0=000, 1=001, 2=002, 7=James Bond]", dict.entrySet().toString());

		//remove and check
		assertEquals("000", dict.remove(0));
		assertEquals("[1=001, 2=002, 7=James Bond]", dict.entrySet().toString());

		//add back and check
		assertNull(dict.put(000, "000"));
		assertEquals("[1=001, 2=002, 7=James Bond, 0=000]", dict.entrySet().toString());

		//remove and check
		assertEquals("002", dict.remove(2));
		assertEquals("James Bond", dict.remove(7));
		assertEquals("[1=001, 0=000]", dict.entrySet().toString());
		
		dict.remove(001);
		dict.put(001, "001");
		dict.put(002, "002");
		dict.put(007, "James Bond");
		assertEquals("[0=000, 1=001, 2=002, 7=James Bond]", dict.entrySet().toString());
	}

	@Test
	void testRemove()
	{
		ParallelArrayDictionary<Integer, String> empty = new ParallelArrayDictionary<Integer, String>(); 

		ParallelArrayDictionary<Integer, String> dict = new ParallelArrayDictionary<Integer, String>();
		assertNull(dict.put(100, "100"));
		assertNull(dict.put(200, "200"));
		assertNull(dict.put(300, "300"));
		assertNull(dict.put(400, "400"));
		assertNull(dict.put(007, "James Bond"));
		assertEquals("[100=100, 200=200, 300=300, 400=400, 7=James Bond]", dict.entrySet().toString());

		//try to remove from an empty dict
		assertNull(empty.remove(48));

		//try to remove k v pair that does not exist: null return 
		assertNull(dict.remove(999));
		assertEquals("[100=100, 200=200, 300=300, 400=400, 7=James Bond]", dict.entrySet().toString());

		//remove multiple valid k v pair
		assertEquals("100", dict.remove(100));
		assertEquals("300", dict.remove(300));
		assertEquals("400", dict.remove(400));
		assertEquals("[200=200, 7=James Bond]", dict.entrySet().toString());

	}

	// this test or the original method won't work until I fix entrySet()
	@Test
	void testPutAll()
	{
		//empty dictionary
		ParallelArrayDictionary<Integer, String> dict = new ParallelArrayDictionary<Integer, String>();

		//empty map
		Map<Integer, String> mapEmpty = new HashMap<>();

		//map populated with key value pairs
		Map<Integer, String> mapFull = new HashMap<>();
		mapFull.put(001, "001"); mapFull.put(002, "002"); mapFull.put(007, "James Bond");

		//empty map in empty dict
		dict.putAll(mapEmpty);

		//check size
		assertEquals(0, dict.size());

		//check emptiness and and attempt to get 
		assertTrue(dict.isEmpty());
		assertNull(dict.get(001));
		assertNull(dict.get(002));
		assertNull(dict.get(007));

		//putAll in an empty map
		dict.putAll(mapFull);

		//check size, keySet(), valueSet(), entrySet() before clear
		assertEquals(3, dict.size());
		assertEquals("[1, 2, 7]", dict.keySet().toString());
		assertEquals("[001, 002, James Bond]", dict.values().toString());
		assertEquals("[1=001, 2=002, 7=James Bond]", dict.entrySet().toString());

		//put an empty map in a dict with data, should have no changer
		dict.putAll(mapEmpty);

		//check size, keySet(), valueSet(), entrySet() before clear
		assertEquals(3, dict.size());
		assertEquals("[1, 2, 7]", dict.keySet().toString());
		assertEquals("[001, 002, James Bond]", dict.values().toString());
		assertEquals("[1=001, 2=002, 7=James Bond]", dict.entrySet().toString());
	}

	@Test
	void testClear()
	{
		//create dictionary
		ParallelArrayDictionary<Integer, String> dict = new ParallelArrayDictionary<Integer, String>();

		//add key value pairs
		assertNull(dict.put(001, "001"));
		assertNull(dict.put(002, "002"));
		assertNull(dict.put(007, "James Bond"));

		//check size, keySet(), valueSet(), entrySet() before clear
		assertEquals(3, dict.size());
		assertEquals("[1, 2, 7]", dict.keySet().toString());
		assertEquals("[001, 002, James Bond]", dict.values().toString());
		assertEquals("[1=001, 2=002, 7=James Bond]", dict.entrySet().toString());


		//clear the values
		dict.clear();

		//check size after clear
		assertEquals(0, dict.size());

		//check emptiness and and attempt to get 
		assertTrue(dict.isEmpty());
		assertNull(dict.get(001));
		assertNull(dict.get(002));
		assertNull(dict.get(007));

	}
}
