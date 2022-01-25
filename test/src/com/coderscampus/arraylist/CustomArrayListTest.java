package src.com.coderscampus.arraylist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {

	@Test
	void should_add_20_elements_to_list() {
		CustomList<String> sut = new CustomArrayList<>();
		for(int i = 0; i < 20; i++) {
			sut.add("Element " + i);
		}
		for(int i = 0; i < sut.getSize(); i++) {
			System.out.println(sut.get(i));
		}
		assertEquals(20,sut.getSize());
	}
	
	@Test
	void should_add_item_at_specified_index() {
		CustomList<String> sut = new CustomArrayList<>();
		for(int i = 0; i < 15; i++) {
			sut.add("Element " + i);
		}
		sut.add(5, "Cheese");
		System.out.println(sut.get(5));
		assertEquals("Cheese", sut.get(5));
	}
	@Test
	void should_throw_index_out_of_bounds_expection_for_adding_a_item_bigger_than_its_size() {
		CustomList<String> sut = new CustomArrayList<>();
		for(int i = 0; i < 8; i++) {
			sut.add("Element " + i);
		}
		assertThrows(IndexOutOfBoundsException.class, () -> sut.add(10, "CheesePie"));
		
	}
	
	@Test
	void should_remove_item_at_specified_index() {
		CustomList<String> sut = new CustomArrayList<>();
		for(int i = 0; i < 15; i++) {
			sut.add("Element " + i);
		}
		sut.remove(1);
		assertEquals("Element 2", sut.get(1));
		for(int i = 0; i < sut.getSize(); i++) {
			System.out.println(sut.get(i));
		}
	}
	
	@Test
	void should_throw_index_out_of_bounds_expection_for_removing_a_item_bigger_than_its_size() {
		CustomList<String> sut = new CustomArrayList<>();
		for(int i = 0; i < 8; i++) {
			sut.add("Element " + i);
		}
		assertThrows(IndexOutOfBoundsException.class, () -> sut.remove(10));
	}

}
