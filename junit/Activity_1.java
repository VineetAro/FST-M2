import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Activity_1 {
	static ArrayList<String> list;

	@BeforeAll
	public static void setUp(){
		// Initialize a new ArrayList
		list = new ArrayList<String>();

		// Add values to the list
		list.add("alpha"); // at index 0
		list.add("beta"); // at index 1
	}

	@Test
	public void insertTest() {

		assertEquals(2, list.size(), "Wrong size");

		list.add(2, "Test1");

		assertEquals(3, list.size(), "Wrong size");

		assertEquals("alpha", list.get(0), "Wrong element");
		assertEquals("Test1", list.get(2), "Wrong element");

		assertEquals("beta", list.get(1), "Wrong element");

		
	}

	// Test method to test the replace operation

	@Test

	public void replaceTest() {

		// Replace new element

		list.set(1, "Test1");

		assertEquals(2, list.size(), "Wrong size");

		assertEquals("alpha", list.get(0), "Wrong element");

		assertEquals("Test1", list.get(1), "Wrong element");

	}

}