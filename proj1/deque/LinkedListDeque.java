package deque;

public class LinkedListDeque<T> {
    private class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item){
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(Node i = sentinel.next; i != sentinel; i = i.next){
            if(i.next == sentinel){
                System.out.println(i.item);
                break;
            }
            System.out.println(i.item + " ");
        }
    }

    public T removeFirst(){
        if(this.isEmpty()){
            return null;
        }
        T removedItem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return removedItem;
    }

    public T removeLast(){
        if(this.isEmpty()){
            return null;
        }
        T removedItem = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return removedItem;
    }

    public T get(int index){
        if(size < index){
            return null;
        }
        Node node = sentinel.next;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node.item;
    }

    public T getRecursive(int index){
        if(size < index){
            return null;
        }
        Node node = sentinel.next;
        return getRecursive(node, index);
    }

    public T getRecursive(Node node, int index){
        if(index == 0){
            return node.item;
        }else{
            node = node.next;
            index--;
        }
        return getRecursive(node, index);
    }
}
