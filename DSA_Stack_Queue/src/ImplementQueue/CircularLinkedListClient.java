package ImplementQueue;

import Queue.MyLinkedListQueue;

public class CircularLinkedListClient {
    public static void main(String[] args) {
        CircularLinkedListQueue circularLinkedListQueue = new CircularLinkedListQueue();
        circularLinkedListQueue.enQueue(10);
        circularLinkedListQueue.enQueue(20);

        System.out.println(circularLinkedListQueue.deQueue().getData());
        System.out.println(circularLinkedListQueue.deQueue().getData());
        System.out.println(circularLinkedListQueue.deQueue().getData());

        circularLinkedListQueue.enQueue(30);
        circularLinkedListQueue.enQueue(40);
        circularLinkedListQueue.enQueue(50);
    }
}
