package src.com.coderscampus.arraylist;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	int index = 0;
	int indexSize = 0;

	@Override
	public boolean add(T item) {
		if(items.length == index) {
			expandArray();
		}
		items[index] = item;
		index++;
		return true;
	}

	private void expandArray() {
		Object[] oldArray = items;
		items = new Object[index * 2];
		indexSize = items.length;
		for(int i = 0; i < oldArray.length; i++) {
			items[i] = oldArray[i];
		}
		
	}

	@Override
	public int getSize() {
		return index;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		return (T) items[index];
	}

	@SuppressWarnings("null")
	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		if(index > this.index) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		if(items.length == this.index) {
			expandArray();
		}
		for(int i = this.index + 1; i > index; i--) {
			items[i] = items[i - 1];
		}
		items[index] = item;
		this.index++;
		
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		if(index >= this.index) {
			throw new IndexOutOfBoundsException();
		}
		for(int i = index; i < this.index; i++) {
			items[i] = items[i+1];
		}
		this.index--;
		return (T) items;
	}
	
}
