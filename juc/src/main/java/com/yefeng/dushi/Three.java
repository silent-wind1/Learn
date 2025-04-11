package com.yefeng.dushi;

/**
 * @Author: 叶枫
 * @Date: 2025/04/11/17:38
 * @Description: 考察点：异常处理
 * catch (父类) 能捕获 throw 子类 的异常。
 *
 * throw 抛出的是实际对象，所以外层 catch (子类) 仍然能匹配。
 *
 * finally 永远执行，无论是否 return、break、continue、异常终止。
 */
class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}

public class Three {
    public static void main(String[] args) {
        try {
            try {
                throw new Sneeze();
            } catch (Annoyance a) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } catch (Sneeze e) {
            System.out.println("Caught Sneeze");
           return;
        } finally {
            System.out.println("hello world");
        }
    }
}
