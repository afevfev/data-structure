package LabExam3;

import java.util.Stack;

public class LinearQueueUsingStacks{
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public LinearQueueUsingStacks() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void enqueue(int data) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(data);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        public int dequeue() {
            if (stack1.isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return stack1.pop();
        }

        public int peek() {
            if (stack1.isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return stack1.peek();
        }

        public boolean isEmpty() {
            return stack1.isEmpty();
        }

        public int size() {
            return stack1.size();
        }

        public static void main(String[] args) {
            LinearQueueUsingStacks queue = new LinearQueueUsingStacks();
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            System.out.println("Size: " + queue.size()); // Output: 3
            System.out.println("Dequeued item: " + queue.dequeue()); // Output: 10
            System.out.println("Peeked item: " + queue.peek()); // Output: 20
            System.out.println("Is queue empty? " + queue.isEmpty()); // Output: false
        }
    }



