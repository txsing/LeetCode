package com.leetcode.algorithm;

import java.util.Stack;

/**
 * using two stack to simulate a queue
 * we divided the whole queue into two parts, 
 * output: FIFO order; input: LIFO order
 * @author txsing
 *
 */
class Q232_ImplementQueueusingStacks {
    Stack<Integer> input = new Stack<Integer>();
    Stack<Integer> output = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        output.peek();
        output.pop();
    }

    // Get the front element.
    public int peek() {
        if(output.empty()){
            while(!input.empty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return input.empty() && output.empty();
    }
}
