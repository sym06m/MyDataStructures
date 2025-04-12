public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        this.heap = new MyArrayList<>();
    }

    public void insert(T item) {
        heap.addLast(item);
        siftUp(heap.size() - 1);
    }

    public T extractMin() {
        if (heap.size() == 0) throw new IllegalStateException("Heap is empty");
        T min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.removeLast();
        siftDown(0);
        return min;
    }

    public T peek() {
        if (heap.size() == 0) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) >= 0) break;
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void siftDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallest = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallest)) < 0)
            smallest = leftChildIndex;
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallest)) < 0)
            smallest = rightChildIndex;

        if (smallest != index) {
            swap(index, smallest);
            siftDown(smallest);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }
}
