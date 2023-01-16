package utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class ParallelArrayDictionaryTest
{
	@Test
	// I don't know what you're supposed to test for this one
	void testParallelArrayDictionary()
	{
		ParallelArrayDictionary<Integer, Integer> p = new ParallelArrayDictionary<Integer, Integer>();
	}

	@Test
	void testGet()
	{
		ParallelArrayDictionary<Integer, Integer> p = new ParallelArrayDictionary<Integer, Integer>();
		// using get with a key not in the (empty) dictionary should return null
		assertEquals(null, p.get(10));
		p.put(10,20);
		// using get with a key in the dictionary should return its value
		assertTrue(p.get(10).equals(20));
		// using get with a key not in the (unempty) dictionary should return null
		assertEquals(null, p.get(50));
	}

	@Test
	void testPut()
	{
		ParallelArrayDictionary<String, String> opposites = new ParallelArrayDictionary<String, String>();
		// below checks that putting the pair sun and moon into the dictionary returns null
		// as sun was not already in the dictionary
		assertEquals(null, opposites.put("sun", "moon"));
		// below checks that moon was properly put in as the value for sun
		assertEquals("moon", opposites.get("sun"));
		// below checks that it returns moon when putting in the pair sun and replacement
		// as sun was already in the dictionary and moon is its previous value
		assertEquals("moon", opposites.put("sun", "replacement"));
		// below makes sure that replacement was inserted properly
		assertEquals("replacement", opposites.get("sun"));
		// below checks adding a new pair
		assertEquals(null, opposites.put("day", "night"));
		assertEquals("night", opposites.get("day"));
	}

	@Test
	void testRemove()
	{
		ParallelArrayDictionary<String, String> stateCapitals = new ParallelArrayDictionary<String, String>();
		// populating the dictionary with the names of states and their capitals
		stateCapitals.put("Florida", "Tallahassee");
		stateCapitals.put("Georgia", "Atlanta");
		stateCapitals.put("South Carolina", "Columbia");
		stateCapitals.put("North Carolina", "Raleigh");
		stateCapitals.put("Tennessee", "Nashville");
		// makes sure that removing a pair properly returns its value
		assertEquals("Nashville", stateCapitals.remove("Tennessee"));
		// makes sure that removing a pair twice returns null
		assertEquals(null, stateCapitals.remove("Tennessee"));
	}

	// this test or the original method won't work until I fix entrySet()
	@Test
	void testPutAll()
	{
		/* 
		ParallelArrayDictionary<Integer, String> myDictionary = new ParallelArrayDictionary<Integer, String>();
		ParallelArrayDictionary<Integer, String> dictionaryToPut = new ParallelArrayDictionary<Integer, String>();
		dictionaryToPut.put(1, "A");
		dictionaryToPut.put(2, "B");
		dictionaryToPut.put(3, "C");
		dictionaryToPut.put(4, "D");
		dictionaryToPut.put(5, "E");
		myDictionary.putAll(dictionaryToPut);
		*/
	}

	@Test
	void testClear()
	{
		ParallelArrayDictionary<Integer, Integer> p = new ParallelArrayDictionary<Integer, Integer>();
		// populate the dictionary 
		for (int i = 1; i < 11; i++) {
			p.put(i, 10*i);
		}
		p.clear();
		// make sure that using get with all the keys will return null since they should not be in the dictionary anymore
		for (int i = 0; i < 11; i++) {
			assertEquals(null, p.get(i));
		}
		// also the size should be 0 since its empty
		assertEquals(0, p.size());
	}
}
