package com.yefeng.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private int balance;
    private final ReentrantLock lock = new ReentrantLock();

    public Account(int balance) {
        this.balance = balance;
    }

    /**
     * 存钱
     * @param balance 钱
     */
    public void deposit(int balance) {
        lock.lock();
        try {
            this.balance += balance;
            System.out.println("存入金额：" + balance + ",当前余额为：" + this.balance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int balance) {
        lock.lock();
        try {
            if(this.balance > balance) {
                this.balance -= balance;
                System.out.println("取出金额：" + balance + ",当前余额为：" + this.balance);
            }else {
                System.out.println("余额不足");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final Account account = new Account(100);

        // 启动一个线程进行存钱操作
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(100);
                try {
                    Thread.sleep(100);  // 模拟延时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 启动一个线程进行取钱操作
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(50);
                try {
                    Thread.sleep(100);  // 模拟延时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
