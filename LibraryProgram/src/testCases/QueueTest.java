package testCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Client;
import structures.NoSuchElementException;
import structures.Node;
import structures.Queue;

class QueueTest{
	
	
	private Queue<Client> queue1;
	
	private void stage1() {
		queue1 = new Queue<Client>();
		Client element = new Client("12");
		Client element1 = new Client("122");
		queue1.offer(element);
		queue1.offer(element1);
		
	}
	
	private void stage2() {
		queue1 = new Queue<Client>();		
	}
	
	
	@Test
	void testOffer() {
		stage1();
		String element = "12";
		String element1 = "122";
			try {
				assertEquals(element,queue1.poll().getId());
				assert(true);
				assertEquals(element1,queue1.poll().getId());
				assert(true);
			} catch (NoSuchElementException e) {
				fail("Didn't expect this");
			}
		}

	@Test
	void testPeekNotException() {
		stage1();
		try {
			queue1.peek();
			assert(true);
		}catch(NoSuchElementException e) {
			fail("Didn't expect this");
		}
	}
	
	@Test
	void testPeekException() {
		stage2();
		try {
			queue1.peek();
			fail("Didn't expect this");
		}catch(NoSuchElementException e) {
			assert(true);
		}
	}

	@Test
	void testPollNotException() {
		stage1();
		try {
			String id = queue1.poll().getId();
			assertNotEquals(id,queue1.peek().getId());
			assert(true);
		}catch(NoSuchElementException e) {
			fail("Didn't expect this");
		}
	}
	
	@Test
	void testPollException() {
		stage2();
		try {
			queue1.poll();
			fail("Didn't expect this");
		}catch(NoSuchElementException e) {
			assert(true);
		}
	}


	@Test
	void testIsEmptyTrue() {
		stage2();
		if(queue1.isEmpty()) {
			assert(true);
		}else {
			fail("Didn't expect this");			
		}
	}

	@Test
	void testIsEmptyFalse() {
		stage1();
		if(!queue1.isEmpty()) {
			assert(true);
		}else {
			fail("Didn't expect this");			
		}		
	}
}
