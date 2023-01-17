/*
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

import java.util.Collection;

import org.junit.jupiter.api.Test;

class ArraySetTest
{
	@Test
	void testArraySetCollectionOfE()
	{		
		// checks the default constructor makes an empty set
		ArraySet<Integer> s = new ArraySet<Integer>();
		assertEquals(0, s.size());
	}

	@Test
	void testAddE()
	{
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
	}

	@Test
	void testAddAllCollectionOfQextendsE()
	{
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
	}

	@Test
	void testRetainAll()
	{
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
		
	}

	@Test
	void testRemoveAll()
	{
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
	}

	@Test
	void testAddAllIntCollectionOfQextendsE()
	{
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
	}
}
