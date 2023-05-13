public class myHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public myHashTable(){
        this.chainArray = new HashNode[M];
        this.size = 0;
    }

    public myHashTable(int M){
        this.M = M;
        this.chainArray = new HashNode[M];
        this.size = 0;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value){
        int hash = hash(key);
        HashNode<K, V> node = chainArray[hash];
        while (node != null){
            if(node.key.equals(key)){
                node.value = value;
                return;
            }
            node = node.next;
        }
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[hash];
        chainArray[hash] = newNode;
        size++;
    }

    public V get(K key){
        int hash = hash(key);
        HashNode<K, V> node = chainArray[hash];
        while(node != null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        int hash = hash(key);
        HashNode<K, V> node = chainArray[hash];
        HashNode<K, V> prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev != null) {
                    prev.next = node.next;
                } else {
                    chainArray[hash] = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }


    public boolean contains(V value){
        for(int i = 0; i < M; i++){
            HashNode<K, V> node = chainArray[i];
            while(node != null){
                if(node.value.equals(value)){
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public K getKey(V value){
        for(int i = 0; i < M; i++){
            HashNode<K, V> node = chainArray[i];
            while(node != null){
                if(node.value.equals(value)){
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }
}
