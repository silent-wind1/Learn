package com.yefeng.behavior.template;

public abstract class Fridge {
    /**
     * 模板方法 不能被修改 , 使用 final 修饰 , 不允许子类覆盖该方法
     * 防止子类修改模板方法的流程
     */
    protected final void store() {
        openDoor();
        closeDoor();

        // 这个钩子方法可以让子类控制模板方法的执行流程
        if (needColdStorage()) {
            codeStorage();
        }

        put();
    }

    /**
     * 该方法是不变的 , 不允许子类修改
     */
    final void openDoor() {
        System.out.println("打开冰箱门");
    }

    final void codeStorage() {
        System.out.println("打开冷藏功能");
    }

    /**
     * 钩子方法 , 子类可以进行覆盖
     * 将适当的权限开放给应用层 , 用于控制模板方法流程
     *
     * @return
     */
    protected boolean needColdStorage() {
        return false;
    }

    /**
     * 抽象方法 , 需要子类进行实现
     */
    abstract void put();

    final void closeDoor() {
        System.out.println("关闭冰箱门");
    }
}
