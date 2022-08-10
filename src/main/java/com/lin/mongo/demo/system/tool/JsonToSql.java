package com.lin.mongo.demo.system.tool;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser;

import java.io.*;

public class JsonToSql {


        public static void main(String[] args) throws Exception {
            System.out.println("========== JSON ---> 转换成 SQL 开始 ==========");
            jsonToExcel("");
            System.out.println("========== JSON ---> 转换成 SQL 结束 ==========");
        }

        private static void jsonToExcel(String a) throws Exception {
            JSONObject jsonParser = JSONObject.parseObject("");
            String PATH = "D://转换的txt文档//11.txt";
            File dir = new File(PATH);
            FileReader reader = new FileReader(dir);
            BufferedReader br = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            String s1 = "";
            while ((s1 = br.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
                sb.append(s1 + "\n");//将读取的字符串添加换行符后累加存放在缓存中
//            System.out.println(s1);
            }
            a = sb.toString();
            JSONArray jsonArray = JSONArray.parseArray(a);
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonElement = jsonArray.getJSONObject(i);
                String name = jsonElement.get("sendorder_no").toString();
                String pinyin = jsonElement.get("VOUCHER_NO").toString();
                String sqlStr = "insert into credit_card_city_info (id, city_name, initial,state,ishot,online_time,down_time,create_time,update_time,remark) values (null,"+name+","+pinyin+",null,null,null,null,null,null,null); \r\n";
                System.out.println(sqlStr);
               /* File file = new File("/Users/hanruikai/city.sql");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(sqlStr);
                bufferedWriter.close();*/
            }
        }

}
