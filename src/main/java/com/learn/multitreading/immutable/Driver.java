package com.learn.multitreading.immutable;

class MessageReader implements Runnable {

    private Message message;

    public MessageReader(Message msg) {
        this.message = msg;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " read " + message.getMessageText());
    }
}


public class Driver {

    public static void main(String[] args) {

        Message m1 = new Message("Hello team");

        Thread t1 = new Thread(new MessageReader(m1), "Thread1");

        Thread t2 = new Thread(new MessageReader(m1), "Thread2");

        t1.start();
        t2.start();
    }
}
