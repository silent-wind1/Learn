package com.demo1;

public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();
        WeddingCompany weddingCompany = new WeddingCompany(you);
        weddingCompany.HappyMarry();
    }

}
// 结婚接口
interface Marry {
    void HappyMarry();
}
// 真实角色
class You implements Marry {
    @Override
    public void HappyMarry() {
        System.out.println("叶枫结婚了~");
    }
}

// 代理角色，帮助你布置婚礼
class WeddingCompany implements Marry {
//    真是角色
    private Marry target;


    public WeddingCompany (Marry target) {
        this.target = target;
    }

    public void before() {
        System.out.println("布置婚礼现场");
    }

    public void after() {
        System.out.println("收尾款");
    }
    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }
}