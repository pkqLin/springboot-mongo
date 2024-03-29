package com.lin.mongo.demo.system.tool;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser;
import org.apache.poi.hssf.usermodel.HSSFCell;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

public class JsonToSql {


        public static void main(String[] args) throws Exception {
            System.out.println("========== JSON ---> 转换成 SQL 开始 ==========");
            jsonToExcel("");
            System.out.println("========== JSON ---> 转换成 SQL 结束 ==========");
        }

        private static void jsonToExcel(String a) throws Exception {
            JSONObject jsonParser = JSONObject.parseObject("");
            String PATH = "D://转换的txt文档//dingshi.txt";
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

            Set<String> keys = null;

            List<String> strsTemp = new ArrayList<>();

            //获取标题
            for (int i = 0; i < jsonArray.size(); i++) {
                if (keys == null) {
                    JSONObject item = jsonArray.getJSONObject(i);
                    keys = item.keySet();
                    for (Object s : keys) {
                        strsTemp.add(s.toString());
                    }
                } else {
                    break;
                }
            }
            /*List<String> strs=strsTemp.stream().distinct().collect(Collectors.toList());
            String sql = "insert into credit_card_city_info (";
            for(String o:strs){
                sql=sql+o+",";
            }
            sql=sql.substring(0,sql.length()-1);
            sql+=") values ";
            for (int i = 0; i < jsonArray.size(); i++) {
               JSONObject jsonElement = jsonArray.getJSONObject(i);
                *//* String name = jsonElement.get("sendorder_no").toString();
                String pinyin = jsonElement.get("VOUCHER_NO").toString();
                String sqlStr = "insert into credit_card_city_info (id, city_name, initial,state,ishot,online_time,down_time,create_time,update_time,remark) values (null,"+name+","+pinyin+",null,null,null,null,null,null,null); \r\n";
                System.out.println(sqlStr);*//*
                sql+= "(";
                for(String o:strs){
                    sql+=jsonElement.get(o.toString())==null?"null"+",":"\""+jsonElement.get(o.toString())+"\""+",";
                }
                sql=sql.substring(0,sql.length()-1);
                sql+=")";




               *//* File file = new File("/Users/hanruikai/city.sql");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(sqlStr);
                bufferedWriter.close();*//*

            }*/

            String sql1 = "";
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonElement = jsonArray.getJSONObject(i);
                String sqlStr = "update eshop_batch set system='"+ jsonElement.get("system").toString()+"',detail='"+jsonElement.get("detail").toString()+"', cron='"+jsonElement.get("cron").toString()+"',cron_explain='"+jsonElement.get("cronNew").toString()+"' where code ='"+jsonElement.get("code").toString()+"'; \r\n";
                System.out.println(sqlStr);
            }
            System.out.println(sql1);
        }


}
