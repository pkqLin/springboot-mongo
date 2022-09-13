package com.lin.mongo.demo.system.tool;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.Set;

//将
public class JSONToExcel {

    public static void main(String[] args) throws IOException {
        Set<String> keys = null;
        // 创建HSSFWorkbook对象
        HSSFWorkbook wb = new HSSFWorkbook();
        // 创建HSSFSheet对象
        HSSFSheet sheet = wb.createSheet("sheet0");
        //需要转换的jsonTXT名称
        String jsonTXT = "D:\\转换的txt文档\\20220913.txt";
        //转换jsonExcel名称
        String jsonExcel = "D:\\转换的txt文档\\20220913.xls";
        File dir = new File(jsonTXT);
        FileReader reader = new FileReader(dir);
        BufferedReader br = new BufferedReader(reader);
        String str = null;
        int roleNo = 0;
        int rowNo = 0;


        String s1 = "";
        StringBuilder sb = new StringBuilder();
        while ((s1 = br.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s1 + "\n");//将读取的字符串添加换行符后累加存放在缓存中
//            System.out.println(s1);
        }
        str = sb.toString();

        //单独json数据单行处理
       /* if (str != null) {
            JSONObject jsonObject = JSONObject.parseObject(str);
            // 创建HSSFRow对象
            HSSFRow row = sheet.createRow(roleNo++);
            // 创建HSSFCell对象
            if (keys == null) {
                //标题
                keys = jsonObject.keySet();
                for (String s : keys) {
                    HSSFCell cell = row.createCell(rowNo++);
                    cell.setCellValue(s);
                }
                rowNo = 0;
                row = sheet.createRow(roleNo++);
            }

            for (String s : keys) {
                HSSFCell cell = row.createCell(rowNo++);
                cell.setCellValue(jsonObject.getString(s));
            }
            rowNo = 0;
            System.out.println(rowNo);
        }*/
        if (str != null) {
            //多行处理
            HSSFRow row = sheet.createRow(0);
           /* JSONObject jsonObject = JSONObject.getJSONArray(str);
            //{result:[{},{},{},{}]
            // a:{}
            // }
            //a:没有取出,这里只要result 数组对象的json,
            JSONArray jsonArray = jsonObject.getJSONArray("result");*/
            JSONArray jsonArray = JSONArray.parseArray(str);
            //获取标题
            for (int i = 0; i < jsonArray.size(); i++) {
                if (keys == null) {
                    JSONObject item = jsonArray.getJSONObject(i);
                    keys = item.keySet();
                    for (Object s : keys) {
                        HSSFCell cell = row.createCell(rowNo++);
                        cell.setCellValue(s.toString());
                    }

                } else {
                    break;
                }
            }
            // 获取数据一次循环一行
            for (int i = 0; i < jsonArray.size(); i++) {
                rowNo = 0;
                JSONObject item = jsonArray.getJSONObject(i);
                row = sheet.createRow(i + 1);
                keys = item.keySet();
                for (Object s : keys) {
                    HSSFCell cell = row.createCell(rowNo++);
                    cell.setCellValue(item.getString(s.toString()));
                }
            }

        }
        br.close();
        reader.close();

        // 输出Excel文件
        FileOutputStream output = new FileOutputStream(jsonExcel);
        wb.write(output);
        wb.close();
        output.flush();
        output.close();
    }
}

