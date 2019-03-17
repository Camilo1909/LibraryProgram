package testCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Book;
import structures.NoSuchElementException;
import structures.Stack;

class StackTest {
	
	private Stack<Book> stack1;
	
	private void stage1() {
		stack1 = new Stack<Book>();
		Book element = new Book("12", 2, 12200);
		Book element1 = new Book("122",3,30000);
		stack1.push(element);
		stack1.push(element1);
		
	}
	
	private void stage2() {
		stack1 = new Stack<Book>();
	}

	@Test
	void testGetSize() {
		stage1();
		if(stack1.getSize()==2) {
			assert(true);
		}else {
			fail("Didn't expect this");
		}
	}

	@Test
	void testIsEmptyTrue() {
		stage2();
		if(stack1.isEmpty()) {
			assert(true);
		}else {
			fail("Didn't expect this");
		}
		
	}
	
	@Test
	void testIsEmptyFalse() {
		stage1();
		if(!stack1.isEmpty()) {
			assert(true);
		}else {
			fail("Didn't expect this");
		}		
	}

	@Test
	void testPeekNotException() {
		stage1();
		try {
			stack1.peek();
			assert(true);
		}catch(NoSuchElementException e) {
			fail("Didn't expect this");
		}
	}
	
	@Test
	void testPeekException() {
		stage2();
		try {
			stack1.peek();
			fail("Didn't expect this");
		}catch(NoSuchElementException e) {
			assert(true);
		}		
	}

	@Test
	void testPopNotException() {
		stage1();
		try {
			String isbn = stack1.pop().getIsbn();
			assertNotEquals(isbn,stack1.peek().getIsbn());
			assert(true);
		}catch(NoSuchElementException e) {
			fail("Didn't expect this");
		}
	}	
	
	@Test
	void testPopException() {
		stage2();
		try {
			stack1.pop();
			fail("Didn't expect this");
		}catch(NoSuchElementException e) {
			assert(true);
		}
	}	

	@Test
	void testPush() {
		stage1();
		String element = "12";
		String element1 = "122";
			try {
				assertEquals(element1,stack1.pop().getIsbn());
				assert(true);
				assertEquals(element,stack1.pop().getIsbn());
				assert(true);
			} catch (NoSuchElementException e) {
				fail("Didn't expect this");
			}
	}

	

}
