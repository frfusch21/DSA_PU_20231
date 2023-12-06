public class HashTable {
    private ListNode[] table;
    private int tableSize;

    public HashTable(int size) {
        tableSize = getClosestPrime(size);
        table = new ListNode[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = null;
        }
    }

    private int getClosestPrime(int size) {
        return size;
    }

    private int hashFunction(int key) {
        return key % tableSize;
    }

    public void insert(int key, int data) {
        int index = hashFunction(key);
        ListNode newNode = new ListNode(key, data);
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            newNode.setNext(table[index]);
            table[index] = newNode;
        }
    }

    public Integer search(int key) {
        int index = hashFunction(key);
        ListNode current = table[index];
        while (current != null) {
            if (current.getKey() == key) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean delete(int key) {
        int index = hashFunction(key);
        ListNode current = table[index];
        ListNode previous = null;
        while (current != null) {
            if (current.getKey() == key) {
                if (previous == null) {
                    table[index] = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false; // Key not found
    }

    private class ListNode {
        private int key;
        private int data;
        private ListNode next;

        public ListNode(int key, int data) {
            this.key = key;
            this.data = data;
            this.next = null;
        }

        public int getKey() {
            return key;
        }

        public int getData() {
            return data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        hashTable.insert(1, 100);
        hashTable.insert(2, 200);
        hashTable.insert(3, 300);
        hashTable.insert(11, 1100);

        Integer data = hashTable.search(2);
        if (data != null) {
            System.out.println("Found data for key 2: " + data);
        } else {
            System.out.println("Data not found for key 2");
        }

        boolean isDeleted = hashTable.delete(3);
        if (isDeleted) {
            System.out.println("Key 3 was successfully deleted.");
        } else {
            System.out.println("Key 3 was not found for deletion.");
        }

        data = hashTable.search(3);
        if (data != null) {
            System.out.println("Found data for key 3: " + data);
        } else {
            System.out.println("Data not found for key 3");
        }
    }
}
