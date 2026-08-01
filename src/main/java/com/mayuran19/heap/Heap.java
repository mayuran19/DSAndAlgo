package com.mayuran19.heap;

public class Heap {
    int[] array;
    int capacity = 100;
    int size;

    public Heap() {
        this.array = new int[capacity];
    }

    public void add(int num){
        if(size + 1 > capacity){
            throw new RuntimeException("Exceeding the capacity");
        }

        int numIndex = size;
        // Add the end of the array
        array[size] = num;

        // Increase the size
        size++;

        int numParentIndex = parent(numIndex);
        while(num > array[numParentIndex]){
            int parentVal = array[numParentIndex];
            array[numParentIndex] = num;
            array[numIndex] = parentVal;
            numIndex = numParentIndex;
            numParentIndex = parent(numIndex);
        }
    }


    // Remove the top of the tree, max heap max value
    public int remove(){
        if(size == 0){
            throw new RuntimeException("No more element");
        }

        int rootValue = array[0];

        // Move the last element to 0th index
        array[0] = array[size - 1];
        size--;

        int curr = 0;

        while (true){
            int leftChildIndex = leftChild(curr);
            int rightChildIndex = rightChild(curr);
            int largestIndex = curr;

            if(array[leftChildIndex] > array[largestIndex] && leftChildIndex < size){
                largestIndex = leftChildIndex;
            }
            if(array[rightChildIndex] > array[largestIndex] && rightChildIndex < size){
                largestIndex = rightChildIndex;
            }

            if(largestIndex == curr){
                break;
            }

            swap(largestIndex, curr);

            curr = largestIndex;
        }

        return rootValue;
    }

    public void swap(int index1, int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public int parent(int index){
        return (index - 1) / 2;
    }

    public int leftChild(int index){
        return (2 * index) + 1;
    }

    public int rightChild(int index){
        return (2 * index) + 2;
    }

    static void main() {
        Heap heap = new Heap();
        heap.add(10);
        heap.add(9);
        heap.add(8);
        heap.add(7);
        heap.add(6);
        heap.add(5);
        heap.add(4);

        System.out.println("Array after adding:");
        for (int i = 0; i < heap.size; i++){
            System.out.print(heap.array[i] + " ");
        }
        System.out.println();

        System.out.println("Removals:");
        int size = heap.size;
        for (int i = 0; i < size; i++){
            System.out.print(heap.remove() + " ");
        }
    }
}
