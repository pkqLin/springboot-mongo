package com.lin.mongo.demo.system.tool;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//再Txt中匹配对应的行信息，并输出文件名
public class FindStrInTxt {


    /**
     * 获取日志文件中的时间
     *
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        //匹配次数
        int matchTime = 0;
        //存匹配上的字符串
        List<String> strs = new ArrayList<>();
        try {
            String path = "D:\\转换的txt文档\\txt\\";
//            "[0-9]*ms$"
            String match = "DN20220705181254141|发送积分换哪件";
            List<String> files = new ArrayList<>();
            setFiles(path,files);
            for (String filePath : files) {
                //编码格式
                String encoding = "UTF-8";
                //文件路径
                File file = new File(filePath);
                if (file.isFile() && file.exists()) { // 判断文件是否存在
                    //输入流
                    InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    //读取一行
                    while ((lineTxt = bufferedReader.readLine()) != null) {
                        //正则表达式
                        matchTime = getMatchTime(matchTime, strs, lineTxt,match,filePath);
                    }
                    read.close();
                } else {
                    System.out.println("找不到指定的文件");
                }
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

    }

    private static int getMatchTime(int matchTime, List<String> strs, String lineTxt,String match,String path) {
        Pattern p = Pattern.compile(match,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(lineTxt);
        boolean result = m.find();
//        String find_result = null;
        if (result) {
            matchTime++;
//            find_result = m.group(0);
//            strs.add(find_result);
            System.out.println("找到的文件"+path+"文件行信息"+lineTxt);
        }
        return matchTime;
    }


    private static double getAvgTime(List<Integer> nums, int matchTime) {
        double sum = 0;
        double avg;
        for (Integer num : nums) {
            sum += num;
        }
        avg = sum / matchTime;
        return avg;
    }

    private static void setFiles(String path, List<String> files) {
        // 获得指定文件对象
        File file = new File(path);
        // 获得该文件夹内的所有文件   file数组
        File[] fileArray = file.listFiles();
        if (fileArray != null) {
            for (int i = 0; i < fileArray.length; i++) {
                //如果是文件
                if (fileArray[i].isFile() && fileArray[i].length() >= 0) {
                    // 检测到非空文件后将文件路径放入list
                    files.add(fileArray[i].getPath());
                } else if (fileArray[i].isDirectory()) {//如果是文件夹
                    //读取新文件夹
                    setFiles(fileArray[i].getPath(), files);
                }
            }
        }
    }

}
