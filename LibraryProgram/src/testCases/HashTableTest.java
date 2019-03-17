package testCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import model.Book;
import structures.HashTable;

class HashTableTest {
	
	
	private HashTable<String,Book> hashtable1;
	
	
	private void stage1() {
		hashtable1 = new HashTable<String,Book>();
		hashtable1.add("12", new Book("12",2,18000));
		hashtable1.add("122", new Book("122",2,28000));
	}
	
	private void stage2() {		
		hashtable1 = new HashTable<String,Book>();
	}

	@Test
	void testGetSize() {
		stage1();
		if(hashtable1.getSize()==2) {
			assert(true);
		}else {
			fail("Didn't expect this");
		}
	}

	@Test
	void testIsEmptyTrue() {
		stage2();
		if(hashtable1.isEmpty()) {
			assert(true);
		}else {
			fail("Didn't expect this");
		}
	}
	
	@Test
	void testIsEmptyFalse() {
		stage1();
		if(!hashtable1.isEmpty()) {
			assert(true);
		}else {
			fail("Didn't expect this");
		}
	}

	@Test
	void testGet() {
		stage1();
		assertEquals("12",hashtable1.get("12").getIsbn());
	}

	@Test
	void testRemove() {
		stage1();
		hashtable1.remove("12");
		if(hashtable1.get("12") == null) {
			assert(true);
		}else {			
			fail("Didn't expect this");
		}
	}

	@Test
	void testAdd() {
		stage1();
		if(hashtable1.get("12") != null) {
			assert(true);
		}else {			
			fail("Didn't expect this");
		}		
	}

}
