<<<<<<< Updated upstream
/*
=======
/**
>>>>>>> Stashed changes
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


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.Test;

class ArraySetTest
{
	@Test
	void testArraySetCollectionOfE()
<<<<<<< Updated upstream
	{		
		// checks the default constructor makes an empty set
		ArraySet<Integer> s = new ArraySet<Integer>();
		assertEquals(0, s.size());
=======
	{
		//check for creation
		ArraySet<Integer> set = new ArraySet<Integer>();
		assertEquals(0, set.size());
		assertTrue(set.isEmpty());

>>>>>>> Stashed changes
	}

	@Test
	void testAddE()
	{
<<<<<<< Updated upstream
		ArraySet<Integer> s = new ArraySet<Integer>();
		s.add(10); 
		// makes sure that adding 1 int of value 10 results in the increase of size by 1
		assertEquals(1,s.size());
		s.add(10);
		// makes sure that it doesn't add a repeat (an int of value 10 again)
		assertEquals(1,s.size()); 
		s.add(25);
		// makes sure that adding a non-repeat works
		assertEquals(2,s.size());
=======
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
>>>>>>> Stashed changes
	}

	@Test
	void testAddAllCollectionOfQextendsE()
	{
<<<<<<< Updated upstream
		ArraySet<Integer> s = new ArraySet<Integer>();
		ArraySet<Integer> t = new ArraySet<Integer>();
		for (int i = 1; i < 11; i++) { // populating both ArraySets
			s.add(i);
			t.add(i+20);
		}
		s.addAll(t);
		assertEquals(20, s.size()); // checks to see if s is bigger by 10 after adding t
		// makes sure each int that was in t was correctly added to s
		for (int i = 0; i < t.size(); i++) {
			assertTrue(s.contains(t.get(i)));
		}
		s.addAll(t);
		assertEquals(20, s.size()); // makes sure you can't add repeats
=======
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

>>>>>>> Stashed changes
	}

	@Test
	void testRetainAllWithANullValueInTheCollection()
	{
<<<<<<< Updated upstream
		// testing retain all by passing a subset that is smaller than this one but has the same values
		ArraySet<Integer> one = new ArraySet<Integer>();
		ArraySet<Integer> two = new ArraySet<Integer>();
		for (int i = 1; i < 11; i++) {
			one.add(10*i);
			if (i > 3 && i < 9) {
				two.add(10*i);
			}
		}
		one.retainAll(two);
		assertEquals(5, two.size());
		// below checks to see if the sets are the same afterwards
		for (int i = 0; i < one.size(); i++) {
			assertTrue(one.contains(two.get(i)));
		}
		// testing retain all by passing a set that is larger than this one but has the same values
		ArraySet<Integer> three = new ArraySet<Integer>();
		ArraySet<Integer> four = new ArraySet<Integer>();
		for (int i = 1; i < 11; i++) {
			three.add(10*i);
			if (i > 3 && i < 9) {
				four.add(10*i);
			}
		}
		assertFalse(four.retainAll(three));
		// testing completely different sets
		ArraySet<Integer> five = new ArraySet<Integer>();
		ArraySet<Integer> six = new ArraySet<Integer>();
		five.add(1);
		five.add(2);
		five.add(3);
		six.add(4);
		six.add(5);
		six.add(6);
		assertTrue(five.retainAll(six));
		// testing the same sets
		ArraySet<Integer> seven = new ArraySet<Integer>();
		ArraySet<Integer> eight = new ArraySet<Integer>();
		seven.add(1);
		seven.add(2);
		seven.add(3);
		eight.add(1);
		eight.add(2);
		eight.add(3);
		assertFalse(seven.retainAll(eight));
		
=======

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

>>>>>>> Stashed changes
	}

	@Test
	void testRemoveAll()
	{
<<<<<<< Updated upstream
		// below checks passing a set with less stuff
		ArraySet<Integer> mySet = new ArraySet<Integer>();
		ArraySet<Integer> stuffToBeRemoved = new ArraySet<Integer>();
		mySet.add(10);
		mySet.add(20);
		mySet.add(30);
		mySet.add(40);
		mySet.add(50);
		stuffToBeRemoved.add(10);
		stuffToBeRemoved.add(20);
		stuffToBeRemoved.add(30);
		stuffToBeRemoved.add(31);
		assertTrue(mySet.removeAll(stuffToBeRemoved)); // makes sure it returns true, like its supposed to
		// below makes sure the stuff to be removed isn't in mySet anymore
		boolean mySetDoesNotIncludeSTBR = true;
		for (int iMS = 0; iMS < mySet.size(); iMS++) {
			for (int iSTBR = 0; iSTBR < stuffToBeRemoved.size(); iSTBR++) {
				if (mySet.get(iMS).equals(stuffToBeRemoved.get(iSTBR))) {
					mySetDoesNotIncludeSTBR = false;
				}
			}
		}
		assertTrue(mySetDoesNotIncludeSTBR);
		// below checks passing a set with more stuff
		ArraySet<Integer> anotherSet = new ArraySet<Integer>();
		ArraySet<Integer> biggerSTBR = new ArraySet<Integer>();
		for (int i = 1; i < 6; i++) {
			biggerSTBR.add(10*i);
			if (i > 2) {
				anotherSet.add(10*i);
			}
		}
		assertTrue(anotherSet.removeAll(biggerSTBR));
		boolean anotherSetDoesNotIncludeBSTBR = true;
		for (int iAS = 0; iAS < anotherSet.size(); iAS++) {
			for (int iBSTBR = 0; iBSTBR < biggerSTBR.size(); iBSTBR++) {
				if (anotherSet.get(iAS).equals(biggerSTBR.get(iBSTBR))) {
					anotherSetDoesNotIncludeBSTBR = false;
				}
			}
		}
		assertTrue(anotherSetDoesNotIncludeBSTBR);
		// below checks passing a completely different set of the same size
		ArraySet<Integer> day = new ArraySet<Integer>();
		ArraySet<Integer> night = new ArraySet<Integer>();
		day.add(10);
		day.add(20);
		day.add(30);
		night.add(50);
		night.add(60);
		night.add(70);
		assertFalse(day.removeAll(night));
=======
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

>>>>>>> Stashed changes
	}

	@Test
	void testAddAllIntCollectionOfQextendsE()
	{
<<<<<<< Updated upstream
		ArraySet<Integer> mySet = new ArraySet<Integer>();
		ArraySet<Integer> stuffToAdd = new ArraySet<Integer>();
		ArraySet<Integer> mySetOriginal = new ArraySet<Integer>();
		for (int i = 1; i < 6; i++) {
			mySet.add(10*i);
			mySetOriginal.add(10*i);
			stuffToAdd.add(10*i+5);
		}
		mySet.addAll(1,stuffToAdd);
		// checks to see if mySet's parts are correct
		boolean valid = true;
		for (int i = 0; i < mySet.size(); i++) {
			if (i < 1 && !mySet.get(i).equals(mySetOriginal.get(i))) {
				valid = false;
				break;
			}
			else if (i >= 1 && i <= stuffToAdd.size() && !mySet.get(i).equals(stuffToAdd.get(i-1))) {
				valid = false;
				break;
			}
			else if (i > stuffToAdd.size() && !mySet.get(i).equals(mySetOriginal.get(i-stuffToAdd.size()))) {
				valid = false;
				break;
			}
		}
		assertTrue(valid);
=======
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
		
		
>>>>>>> Stashed changes
	}
	
}
