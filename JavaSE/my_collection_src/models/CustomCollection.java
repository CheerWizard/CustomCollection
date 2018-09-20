package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CustomCollection<TData> {

	private List<TData> list;
	private int size;
	
	//create collection without size and null elements
	public CustomCollection() {
		list = new ArrayList<>();
		size = list.size();
	}
	
	//create collection with required size
	public CustomCollection(int size) {
		list = new ArrayList<>(size);
		this.size = size;
	}
	
	//create collection with inserted elements
	public CustomCollection(List<TData> list) {
		this.list = list;
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
		return size == 0 ? null : list.get(0);
	}
	
	public TData getLast() {
		return size == 0 ? null : list.get(size - 1);
	}

	//TODO input your custom class that implements the interface Comparator
	public TData maxValue(Comparator<TData> comparator) {
		TData maxValue = list.get(0);
		for (int i = 0 ; i < size ; i++) {
			if(comparator.compare(maxValue , list.get(i)) < 0) maxValue = list.get(i);
		}
		return maxValue;
	}
	
	//TODO input your custom class that implements the interface Comparator
	public TData minValue(Comparator<TData> comparator) {
		TData minValue = list.get(0);
		for (int i = 0 ; i < size ; i++) {
			if(comparator.compare(minValue , list.get(i)) > 0) minValue = list.get(i);
		}
		return minValue;
	}
	
	//TODO if comparable return 1 -> exist
	//TODO if comparable return -1 -> not exist
	//TODO input your custom class that implement the interface Comparable
	public CustomCollection<TData> filter(ISelector<TData> selector , TData data) {
		CustomCollection<TData> collection = new CustomCollection<>();
		collection.add(data);
		for (int i = 0 ; i < size ; i++) {
			if (selector.select(data).equals(selector.select(list.get(i)))) collection.add(list.get(i));
		}
		return collection;
	}
	
	//TODO bubble sort method
	//TODO sorts only by number values
	//TODO input your custom class that implement the interface Comparator
	public void sort(Comparator<TData> comparator) {
		for (int i = 1 ; i < size ; i++) {
			for (int j = size - 1 ; j >= 1 ; j--) {
				//decreasing sort!
				if(comparator.compare(list.get(j-1) , list.get(j)) > 0) Collections.swap(list, j-1, j);
			}
		}
	}
	
    public Iterator<TData> iterator() {
        return new CustomCollectionIterator();
    }
	
	private class CustomCollectionIterator implements Iterator<TData> {
		private int position = 0;
	 
		public boolean hasNext() {
            return position < size;
        }
 
        public TData next() {
            if (this.hasNext())
                return list.get(position++);
            else
                return null;
        }
 
	}
	
}
