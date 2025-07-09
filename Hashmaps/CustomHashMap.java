class Entry<K, V> {
    K key;
    V value;
    Entry<K, V> next;
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class CustomHashMap<K, V> {
    private final int SIZE = 16;
    private Entry<K, V>[] table = new Entry[SIZE];

    public void put(K key, V value) {
        int index = key.hashCode() % SIZE;
        Entry<K, V> entry = new Entry<>(key, value);
        if (table[index] == null) {
            table[index] = entry;
        } else {
            Entry<K, V> current = table[index];
            while (current.next != null && !current.key.equals(key)) {
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = entry;
            }
        }
    }

    public V get(K key) {
        int index = key.hashCode() % SIZE;
        Entry<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) return current.value;
            current = current.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = key.hashCode() % SIZE;
        Entry<K, V> current = table[index];
        Entry<K, V> prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) table[index] = current.next;
                else prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}

public class CustomHashMapTest {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        System.out.println("Value for 'one': " + map.get("one"));
        map.remove("one");
        System.out.println("Value after removal: " + map.get("one"));
    }
}