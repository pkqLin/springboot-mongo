package com.lin.thread.realize;

import org.apache.tomcat.util.http.fileupload.FileUtils;

public class Threadtwo extends Thread{
    private String url;
    private String name;

    public  Threadtwo(String url,String name){
        this.url=url;
        this.name=name;
    }
    @Override
    public void run() {
        WedDownload wedDownload =new WedDownload();
        wedDownload.download(url,name);
        System.out.println("下载了文件:"+name);
    }

    public static void main(String[] args) {
        Threadtwo thread1=new Threadtwo("1","2");
        Threadtwo thread2=new Threadtwo("1","2");
        Threadtwo thread3=new Threadtwo("1","2");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class WedDownload{
    public void download(String URL,String name){
        //下载图片方法
    }
}