/**
* This class tests the implementation of ArraySet.
* It attests to the functionality of the default constructor and the methods:
* add(), addAll(), retainAll(), removeAll(), AddAll(passing the index to start at)
*
* <p>Bugs: (a list of bugs and / or other problems)
*
* @author Joshua Berger, Caden Parry
* @date 1/17/2023
*/

package utilities;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


import org.junit.jupiter.api.Test;

class ArraySetTest
{
	@Test
	void testArraySetCollectionOfE()
	{
		//check for creation
		ArraySet<Integer> set = new ArraySet<Integer>();
		assertEquals(0, set.size());
		assertTrue(set.isEmpty());

	}

	@Test
	void testAddE()
	{
		ArraySet<Integer> set = new ArraySet<Integer>();

		//check emptiness: empty
		assertTrue(set.isEmpty());

		//attempt to add null and check size
		assertFalse(set.add(null));
		assertEquals(0, set.size());

		//add -3 to 3
		for(int x = -3; x <= 3; x++) assertTrue(set.add(x));

		//check to see if set contains -3 to 3
		for(int x = -3; x <= 3; x++) assertTrue(set.contains(x));

		//attempt to add all of the same values, fail because they're already added
		for(int x = -3; x <= 3; x++) assertFalse(set.add(x));

		//check the size
		assertEquals(7, set.size());
	}

	@Test
	void testAddRemoveAddE()
	{
		ArraySet<String> set = new ArraySet<String>();

		// Strings
		set.add("cat"); set.add("mat"); set.add("rat"); set.add("bat");

		//check size and proper containment
		assertEquals(4, set.size());
		assertEquals(Arrays.asList("cat", "mat", "rat", "bat"), set);

		//index and object based remove
		set.remove("cat");
		set.remove(2);

		//check size and proper containment
		assertEquals(2, set.size());
		assertEquals(Arrays.asList("mat", "rat"), set);

		//index and object based add
		set.add(0, "bat");
		set.add("cat");

		//check size and proper containment
		assertEquals(4, set.size());
		assertEquals(Arrays.asList("bat", "mat", "rat", "cat"), set);
	}

	@Test
	void testAddAllCollectionOfQextendsE()
	{
		//empty sets
		ArraySet<Integer> nullAddTest = new ArraySet<Integer>();
		ArraySet<Integer> emptySet1 = new ArraySet<Integer>();
		ArraySet<Integer> emptySet2 = new ArraySet<Integer>();

		//populated set
		ArraySet<Integer> setNegThreeToThree = new ArraySet<Integer>();
		for(int x = -3; x <= 3; x++) assertTrue(setNegThreeToThree.add(x));

		//various lists
		List<Integer> emptyCollection = Arrays.asList();
		List<Integer> negThreeToThreeCollection = Arrays.asList(-3, -2, -1, 0, 1, 2, 3);
		List<Integer> ThreeToSixCollection = Arrays.asList(3, 4, 5, 6);

		//test adding a null value
		Collection<Integer> c = Arrays.asList(1, 2, null);
		assertTrue(nullAddTest.addAll(c));
		assertEquals(Arrays.asList(1, 2), nullAddTest);

		//add nothing to nothing
		//add and empty collection to an empty set: end and index based methods
		assertFalse(emptySet1.addAll(emptyCollection));
		assertFalse(emptySet1.addAll(5, emptyCollection));
		assertEquals(0, emptySet2.size());

		//add something to nothing 
		//add -3...3 to an empty set
		assertTrue(emptySet2.addAll(negThreeToThreeCollection));
		assertEquals(Arrays.asList(-3, -2, -1, 0, 1, 2, 3), emptySet2);
		assertEquals(7, emptySet2.size());

		emptySet2.clear();

		//add -3...3 to an empty set using index based add
		assertTrue(emptySet2.addAll(0, negThreeToThreeCollection));
		assertEquals(Arrays.asList(-3, -2, -1, 0, 1, 2, 3), emptySet2);
		assertEquals(7, emptySet2.size());

		//nothing to something
		//add an empty collection to a set with values: fail
		assertFalse(setNegThreeToThree.addAll(emptyCollection));

		//something to something
		//add 3...6 to the -3...3: expect no duplicate 3
		assertEquals(Arrays.asList(-3, -2, -1, 0, 1, 2, 3), setNegThreeToThree);
		assertTrue(setNegThreeToThree.addAll(ThreeToSixCollection));
		assertEquals(Arrays.asList(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6), setNegThreeToThree);

		//add collection at index first, middle, and last index
		assertTrue(setNegThreeToThree.addAll(0, Arrays.asList(100, -76, 3)));
		assertTrue(setNegThreeToThree.addAll(setNegThreeToThree.size() / 2, Arrays.asList(9, -8)));
		assertTrue(setNegThreeToThree.addAll(setNegThreeToThree.size(), Arrays.asList(19)));
		assertEquals(Arrays.asList(100, -76, -3, -2, -1, 0, 9, -8, 1, 2, 3, 4, 5, 6, 19),
				setNegThreeToThree);

	}

	@Test
	void testRetainAllWithANullValueInTheCollection()
	{

		//create and populate
		ArraySet<Integer> set = new ArraySet<Integer>();
		set.addAll(Arrays.asList(-2, -1, 0, 1, 2));

		//create collection with a null values
		List<Integer> c = Arrays.asList(2, 1, null);

		assertTrue(set.retainAll(c));

		//make sure null was not included and function still returns true
		assertEquals(2, set.size());
		assertEquals(Arrays.asList(1, 2), set);
	}

	@Test
	void testRetainAllOnAnEmptySet()
	{
		//create and populates
		ArraySet<Integer> set = new ArraySet<Integer>();
		set.addAll(Arrays.asList(-2, -1, 0, 1, 2));

		//create an empty collection
		List<Integer> c = Arrays.asList();

		assertTrue(set.retainAll(c));

		//make sure the set is empty and nothing is retained
		assertEquals(Arrays.asList(), set);
	}

	@Test
	void testRetainAllWithDuplicatesInTheCollection()
	{
		//create and populate
		ArraySet<Integer> set = new ArraySet<Integer>();
		set.addAll(Arrays.asList(-2, -1, 0, 1, 2));

		//create a collection with duplicates
		List<Integer> c = Arrays.asList(1, 2, -1, -1, 2);

		assertTrue(set.retainAll(c));

		//make sure duplicates are not found in the set
		assertEquals(Arrays.asList(-1, 1, 2), set);
	}

	@Test
	void testRetainAllWithACollectionThatMirrorsTheSet()
	{
		//create and populate a set
		ArraySet<Integer> set = new ArraySet<Integer>();
		set.addAll(Arrays.asList(-2, -1, 0, 1, 2));

		//create a collection that mirrors the set
		List<Integer> c = Arrays.asList(-2, -1, 0, 1, 2);

		assertFalse(set.retainAll(c));

		//check to make sure that all values were retains, ie. no change
		assertEquals(Arrays.asList(-2, -1, 0, 1, 2), set);
	}
	
	@Test
	void testRetainAllWithACollectionWithNoValuesInTheSet()
	{
		//create and populate a set
		ArraySet<Integer> set = new ArraySet<Integer>();
		set.addAll(Arrays.asList(-2, -1, 0, 1, 2));

		//create a collection that mirrors the set
		List<Integer> c = Arrays.asList(99);

		assertTrue(set.retainAll(c));

		//check to make sure that all values were retains, ie. no change
		assertEquals(Arrays.asList(), set);

	}

	@Test
	void testRemoveAll()
	{
		//create sets with various properties
		ArraySet<Integer> emptySet = new ArraySet<Integer>();

		ArraySet<Integer> unchangedSet = new ArraySet<Integer>();
		for(int x = -3; x <= 3; x++) assertTrue(unchangedSet.add(x));

		ArraySet<Integer> changedSetWithItems = new ArraySet<Integer>();
		for(int x = -3; x <= 3; x++) assertTrue(changedSetWithItems.add(x));

		ArraySet<Integer> changedSetWithItems2 = new ArraySet<Integer>();
		for(int x = -3; x <= 3; x++) assertTrue(changedSetWithItems2.add(x));

		ArraySet<Integer> changedSetEndsEmpty = new ArraySet<Integer>();
		for(int x = -3; x <= 3; x++) assertTrue(changedSetEndsEmpty.add(x));

		//create collections with various properties
		List<Integer> emptyCollection = Arrays.asList();
		List<Integer> noneInSetAllBelow = Arrays.asList(-10, -4, -9);
		List<Integer> noneInSetAllAbove = Arrays.asList(10, 4, 9);
		List<Integer> noneInSetAllBelowAndAbove = Arrays.asList(10, 4, 9);
		List<Integer> someInSet = Arrays.asList(-4, -3, 0, 5, 6);
		List<Integer> allInSet = Arrays.asList(-3, 0, 3);
		List<Integer> mirrorOfSet = Arrays.asList(-3, -2, -1, 0, 1, 2, 3);

		//remove nothing from something: return false because nothing was removed
		assertFalse(unchangedSet.removeAll(emptyCollection));

		//remove something from nothing 
		assertFalse(emptySet.removeAll(mirrorOfSet));

		//remove nothing from nothing
		assertFalse(emptySet.removeAll(emptyCollection));

		//attempt to remove values all less than values in unchangedSet: should fail
		assertFalse(unchangedSet.removeAll(noneInSetAllBelow));
		assertEquals(Arrays.asList(-3, -2, -1, 0, 1, 2, 3), unchangedSet);

		//attempt to remove values all greater than values in unchangedSet: should fail
		assertFalse(unchangedSet.removeAll(noneInSetAllAbove));
		assertEquals(Arrays.asList(-3, -2, -1, 0, 1, 2, 3), unchangedSet);

		//attempt to remove values less than and greater than values in unchangedSet: should fail
		assertFalse(unchangedSet.removeAll(noneInSetAllBelowAndAbove));
		assertEquals(Arrays.asList(-3, -2, -1, 0, 1, 2, 3), unchangedSet);

		//remove collections with values in and out of the set: should pass and remove -3, 0
		assertEquals(Arrays.asList(-3, -2, -1, 0, 1, 2, 3), changedSetWithItems);
		assertTrue(changedSetWithItems.removeAll(someInSet));
		assertEquals(Arrays.asList(-2, -1, 1, 2, 3), changedSetWithItems);

		//remove collection with values that are all in the set: should remove -3, 0, 3
		assertEquals(Arrays.asList(-3, -2, -1, 0, 1, 2, 3), changedSetWithItems2);
		assertTrue(changedSetWithItems2.removeAll(allInSet));
		assertEquals(Arrays.asList(-2, -1, 1, 2), changedSetWithItems2);

		//remove collection that contains all of the values in the set: should clear the set
		assertEquals(Arrays.asList(-3, -2, -1, 0, 1, 2, 3), changedSetEndsEmpty);
		assertTrue(changedSetEndsEmpty.removeAll(mirrorOfSet));
		assertEquals(Arrays.asList(), changedSetEndsEmpty);

	}

	@Test
	void testAddAllIntCollectionOfQextendsE()
	{
		//create and populates
		ArraySet<Integer> set = new ArraySet<Integer>();
		set.addAll(Arrays.asList(-2, -1, 0, 1, 2));

		//create collection
		List<Integer> allGreater = Arrays.asList(3, 4, 5);
		List<Integer> allSmaller = Arrays.asList(-5, -4, -3);

		//add greater at the front and smaller at the back
		assertTrue(set.addAll(0, allGreater));
		assertTrue(set.addAll(set.size(), allSmaller));

		//check to make sure the collection were added properly, no sorting
		assertEquals(Arrays.asList(3, 4, 5, -2, -1, 0, 1, 2, -5, -4, -3), set);
	}
	
	@Test
	void testAddAllIntCollectionOfQextendsEAddToMiddle()
	{
		ArraySet<Integer> set = new ArraySet<Integer>();
		for(int x = -3; x <= 3; x++) assertTrue(set.add(x));

		//add collection at index first, middle, and last index
		assertTrue(set.addAll(0, Arrays.asList(100, -76, 3)));
		assertTrue(set.addAll(set.size() / 2, Arrays.asList(9, -8)));
		assertTrue(set.addAll(set.size(), Arrays.asList(19)));
		assertEquals(Arrays.asList(100, -76, -3, -2, 9, -8, -1, 0, 1, 2, 3, 19),
				set);
		
		
	}
	
}
