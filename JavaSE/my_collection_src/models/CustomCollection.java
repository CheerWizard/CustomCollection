package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class CustomCollection<TData> {

	private ArrayList<TData> list;
	private int size;
	
	public CustomCollection() {
		list = new ArrayList<>();
		size = list.size();
	}
	
	public void add(TData data) {
		list.add(data);
		size++;
	}
	
	public TData get(int position) {
		return list.get(position);
	}
	
	public void remove(TData data) {
		list.remove(data);
		size--;
	}
	
	public void remove(int position) {
		list.remove(position);
		size--;
	}
	
	public int size() {
		return size;
	}
	
	public TData getFirst() {
		if (size == 0) {
			return null;
		}
		else {
			return list.get(0);
		}
	}
	
	public TData getLast() {
		if (size == 0) {
			return null;
		}
		else {
			return list.get(size - 1);
		}
	}

	//TODO input your custom class that implement the interface Comparator
	//TODO method compare() must return the value 1 , -1 , 0
	public TData maxValue(Comparator<TData> comparator) {
		TData maxValue = list.get(0);
		for (int i = 0 ; i < size ; i++) {
			switch (comparator.compare(maxValue , list.get(i))) {
				case 1 :
					break;
				case -1 :
					maxValue = list.get(i);
					break;
				case 0 :
					break;
			}
		}
		return maxValue;
	}
	
	//TODO input your custom class that implement the interface Comparator
	//TODO method compare() must return the value 1 , -1 , 0
	public TData minValue(Comparator<TData> comparator) {
		TData minValue = list.get(0);
		for (int i = 0 ; i < size ; i++) {
			switch (comparator.compare(minValue , list.get(i))) {
				case 1 :
					minValue = list.get(i);
					break;
				case -1 :
					break;
				case 0 :
					break;
			}
		}
		return minValue;
	}
	
	//TODO if comparable return 1 -> exist
	//TODO if comparable return -1 -> not exist
	//TODO input your custom class that implement the interface Comparable
	public TData search(Comparable<TData> comparable) {
		TData data = null;
		for (int i = 0 ; i < size ; i++) {
			switch (comparable.compareTo(list.get(i))) {
				case 1 : 
					data = list.get(i);
					break;
				case -1 :
					break;
			}
		}
		return data;
	}
	
	//TODO bubble sort method
	//TODO sorts only by number values
	//TODO input your custom class that implement the interface Comparator
	public void sort(Comparator<TData> comparator) {
		for (int i = 1 ; i < size ; i++) {
			for (int j = size - 1 ; j >= 1 ; j--) {
				
				switch (comparator.compare(list.get(j-1) , list.get(j))) {
					case 1 :
						Collections.swap(list, j-1, j);
						break;
					case -1 :
						break;
					case 0 :
						break;
				}
				
			}
		}
		
	}
	
    public Iterator<TData> iterator() {
        return new CustomCollectionIterator();
    }
	
	private class CustomCollectionIterator implements Iterator<TData> {
		private int position = 0;
	 
		public boolean hasNext() {
            if (position < size)
                return true;
            else
                return false;
        }
 
        public TData next() {
            if (this.hasNext())
                return list.get(position++);
            else
                return null;
        }
 
	}
	
}
