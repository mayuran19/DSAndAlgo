package com.mayuran19.stack;/**
 * Description: TODO Replace me
 *
 * @Author: MS
 * Date: 11/8/24
 * @license iLex
 */

/**
 * Description: TODO Replace me
 * Author: Mayuran Satchithanantham
 * Date: 11/8/24
 * @license iLex
 */

public interface Stack<E> {
    int size();
    boolean isEmpty();
    void push(E e);
    E pop();
    E top();
}
