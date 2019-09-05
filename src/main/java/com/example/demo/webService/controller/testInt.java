package com.example.demo.webService.controller;

import com.example.demo.webService.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class testInt {
    @Autowired
    private JdbcTemplate template;

    /**
     * 导入数据至数据库
     *
     * @return
     * @throws Exception
     */
    public void input(String file) throws Exception {

        String sql = "INSERT INTO dept VALUES (?,?)";
        //读取已有文件中的数据加入数据库表中
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputReader = new InputStreamReader(inputStream);
        BufferedReader bufferReader = new BufferedReader(inputReader);
        // 读取一行
        String line;
        //开始时间
        Long startTime = System.currentTimeMillis();
        Test test = new Test();
        final List<Test> list = new ArrayList<Test>();
        while ((line = bufferReader.readLine()) != null) {
            // 按照相应规则截取字符串
            String a[] = line.split("\t");
            String s = "";
            for (int i = 1; i < a.length; i++) {
                s += a[i] + " ";
            }
            // 去掉字符串开头和结尾的空格
            final String ss = s.trim();
            test.setId(Integer.parseInt(a[0]));
            test.setValue(Integer.parseInt(ss));
            list.add(new Test(test.getId(), test.getValue()));
        }
        template.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1, list.get(i).getId());
                preparedStatement.setInt(2, list.get(i).getValue());
            }

            @Override
            public int getBatchSize() {
                return list.size();
            }
        });
        //结束时间
        Long endTime = System.currentTimeMillis();
        System.out.println("导入完成！");
        System.out.println("导入数据" + list.size() + "条,用时：" + (endTime - startTime) + "毫秒");
    }

}
