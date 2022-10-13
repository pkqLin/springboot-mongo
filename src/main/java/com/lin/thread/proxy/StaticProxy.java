package com.lin.thread.proxy;

//总结
//  代理对象可以做很多真实对象无法实现的内容
public class StaticProxy {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("实现方法")).start();
        WeddingCompany weddingCompany=new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}

interface  Marry{
    void HappyMarry();
}

class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("结婚，实现类");
    }
}

class WeddingCompany implements Marry{
    //真实目标代理过来的
    private Marry marry;
    public WeddingCompany(Marry marry){
        this.marry=marry;
    }
    @Override
    public void HappyMarry() {
        System.out.println("代理之前");
        this.marry.HappyMarry();//真实对象实现类
        System.out.println("代理之后");
    }
}
