package lektion3binarytreeMedDictionary.dictionary;

import java.util.Objects;

public class DictionaryBST<K extends Comparable<K>, V> implements Dictionary<K, V> {

	private Node root;

	public DictionaryBST() {
		root = null;
	}

	@Override
	public V get(K key) {
		if (find(key) == null) {
			return null;
		} else {
            return find(key) != null ? Objects.requireNonNull(find(key)).value : null;
		}
	}

	private Node find(K key) {
		Node current = root;
		boolean found = false;
		while (!found && current != null) {
			int d = current.key.compareTo(key);
			if (d == 0) {
				found = true;
			} else if (d > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (found) {
			return current;
		} else {
			return null;
		}

	}

	@Override
	public boolean isEmpty() {
        return root == null;
	}

	@Override
	public V put(K key, V value) {
		if (key != null && value != null) {
			if (find(key) != null) {
				V oldValue = find(key).value;
				Objects.requireNonNull(find(key)).value = value;
				return oldValue;
			} else {
				root = new Node(key, value);
			}
		}
		return null;

	}

	@Override
	public V remove(K key) {
		if  (find(key) != null) {
			V oldValue = find(key).value;
			Objects.requireNonNull(find(key)).value = oldValue;
			return oldValue;
		}  else {
			return null;
		}
	}

	@Override
	public int size() {
		// TODO
		return -1;
	}

	private class Node {
		private K key;
		private V value;
		private Node left;
		private Node right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
}
