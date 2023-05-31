package ImplementQueue;

import Queue.MyLinkedListQueue;

public class CircularLinkedListQueue {
    class Node {
        private int data;
        private Node link;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return this.data;
        }
    }

    private Node front;
    private Node rear;

    CircularLinkedListQueue() {
        front = null;
        rear = null;
    }

    public void enQueue(int data) {
        Node temp = new Node(data);
        if (this.rear == null) {
            front = rear = temp;
        }
        rear.link = temp;
        rear = temp;
        rear.link = front;
    }
    public Node deQueue() {
        if (this.rear == null)
            return null;
        Node temp = this.front;
        if (this.front == this.rear) {
            front = rear = null;
            return temp;
        }
        front = front.link;
        rear.link = front;
        return temp;
    }
}
