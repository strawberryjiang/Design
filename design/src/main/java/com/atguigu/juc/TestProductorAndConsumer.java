package com.atguigu.juc;

/**
 * @description:
 * @author: yangjiang
 * @create: 2020-10-22 19:37
 **/
public class TestProductorAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(producer, "生产者A").start();
        new Thread(consumer, "消费者B").start();


    }


    //店员
    static class Clerk {
        private int product = 0;


        //进货
        public synchronized void get() {
            if (product >= 10) {
                System.out.println("产品已满");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + ":" + ++product);
                this.notifyAll();

            }

        }

        //卖货
        public synchronized void sale() {
            if (product <= 0) {
                System.out.println("缺货");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + ":" + --product);
                this.notifyAll();
            }
        }
    }


    //生产者
    static class Producer implements Runnable {
        private Clerk clerk;

        public Producer(Clerk clerk) {
            this.clerk = clerk;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                clerk.get();

            }
        }
    }

    //消费者
    static class Consumer implements Runnable {
        private Clerk clerk;

        public Consumer(Clerk clerk) {
            this.clerk = clerk;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                clerk.sale();
            }
        }
    }
}
