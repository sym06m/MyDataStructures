public class Main {
    public static void main(String[] args) {
        // MyArrayList
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        System.out.println("MyArrayList: " + arrayList.get(0) + ", " + arrayList.get(1));

        // MyLinkedList
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("Hello");
        linkedList.add("World");
        System.out.println("MyLinkedList: " + linkedList.get(0) + ", " + linkedList.get(1));

        // MyStack
        MyStack<Integer> stack = new MyStack<>();
        stack.push(100);
        stack.push(200);
        System.out.println("MyStack: " + stack.pop() + ", " + stack.peek());

        // MyQueue
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("First");
        queue.enqueue("Second");
        System.out.println("MyQueue: " + queue.dequeue() + ", " + queue.peek());

        // MyMinHeap
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        System.out.println("MyMinHeap: " + minHeap.extractMin() + ", " + minHeap.peek());
    }
}
