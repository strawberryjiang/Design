package com.atguigu.juc.pc;

/**
 * @description: 生产者
 * @author: yangjiang
 * @create: 2020-10-27 18:19
 **/


/**
 * 线程通信问题：线程交替执行,线程操作同一个变量 num=0
 * <p>
 * A num+1
 * B num-1
 */
public class A {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "B").start();

    }
}


//判断等待，业务，通知
class Data {//资源类，需要控制线程并发。只要是并发编程，一定要加锁

    private int number = 0;

    public synchronized void increment() {
        if (number != 0) {
           /* try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //等待
        }*/

        }else{
            number++;
            System.out.println(Thread.currentThread().getName() + "=>" + number);

        }

        }

        //通知其他线程，我+1完毕了
        //this.notifyAll();



    public synchronized void decrement() {
        if (number == 0) {
          /*  try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //等待
        }*/
        }
            else{
                number--;
                System.out.println(Thread.currentThread().getName() + "=>" + number);
            }

        }

        //通知其他线程，我-1完毕了
        //this.notifyAll();

    }
