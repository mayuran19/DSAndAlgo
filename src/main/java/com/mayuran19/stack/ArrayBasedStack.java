package com.mayuran19.stack;


/**
 * Description: TODO Replace me
 *
 * @Author: MS
 * Date: 11/8/24
 * @license iLex
 */
public class ArrayBasedStack implements Stack<Integer>{
    public static void main(String[] args) {
        ArrayBasedStack arrayBasedStack = new ArrayBasedStack();
        arrayBasedStack.push(1);
        arrayBasedStack.push(2);
        arrayBasedStack.push(3);
        arrayBasedStack.push(4);
        arrayBasedStack.push(5);
        arrayBasedStack.push(6);
        arrayBasedStack.push(6);
        arrayBasedStack.push(6);
        arrayBasedStack.push(6);
        arrayBasedStack.push(6);

        System.out.println(arrayBasedStack.pop());
        System.out.println(arrayBasedStack.pop());
        System.out.println(arrayBasedStack.pop());
        System.out.println(arrayBasedStack.pop());
        System.out.println(arrayBasedStack.pop());
    }
    private int size = 0;
    private int top = -1;
    private int[] data = new int[10];
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size > 0;
    }

    @Override
    public void push(Integer integer) {
        if(size == data.length){
            throw new IndexOutOfBoundsException();
        }else{
            data[top + 1] = integer;
            size++;
            top++;
        }

    }

    @Override
    public Integer pop() {
        var dat = data[top];
        top--;
        size--;
        return dat;
    }

    @Override
    public Integer top() {
        return data[top];
    }
}
