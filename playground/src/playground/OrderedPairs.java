package playground;

public class OrderedPairs<K, V> implements Pairs<K, V>{

	private K key;
	private V value;
	
	public OrderedPairs(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		
		return this.key;
	}

	@Override
	public V getValue() {
		
		return this.value;
	}
	
}
