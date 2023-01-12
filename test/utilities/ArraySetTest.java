package utilities;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class ArraySetTest
{
	@Test
	void testArraySetCollectionOfE()
	{
	}

	@Test
	void testAddE()
	{
		ArraySet <Integer> s = new ArraySet <Integer>();
		s.add(10);
		assertEquals(1,s.size());
		s.add(10);
		assertEquals(1,s.size());
	}

	@Test
	void testAddAllCollectionOfQextendsE()
	{
	}

	@Test
	void testRetainAll()
	{
	}

	@Test
	void testRemoveAll()
	{
	}

	@Test
	void testAddAllIntCollectionOfQextendsE()
	{
	}
}
