/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.niezhili.dataplatform.metadata;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * https://www.cnblogs.com/chy18883701161/p/12594889.html
 * Druid动态连接池的使用
 * 前端页面配置数据源的时候，将下面的参数替换成页面参数，就可以实现数据源配置
 * @author niezhili
 * @date 2022-01-15
 */
public class DruidTest {

    @Test
    public void testDruidSource() {
        try {
            //数据源配置
            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setUrl("jdbc:mysql://127.0.0.1/db_student?serverTimezone=UTC");
            dataSource.setDriverClassName("com.mysql.jdbc.Driver"); //这个可以缺省的，会根据url自动识别
            dataSource.setUsername("root");
            dataSource.setPassword("abcd");

            //下面都是可选的配置
            dataSource.setInitialSize(10);  //初始连接数，默认0
            dataSource.setMaxActive(30);  //最大连接数，默认8
            dataSource.setMinIdle(10);  //最小闲置数
            dataSource.setMaxWait(2000);  //获取连接的最大等待时间，单位毫秒
            dataSource.setPoolPreparedStatements(true); //缓存PreparedStatement，默认false
            dataSource.setMaxOpenPreparedStatements(20); //缓存PreparedStatement的最大数量，默认-1（不缓存）。大于0时会自动开启缓存PreparedStatement，所以可以省略上一句代码

            //获取连接
            Connection connection = dataSource.getConnection();

            //Statement接口
            Statement statement = connection.createStatement();
            String sql1 = "insert into tb_student (name,age) values ('chy',20)";
            statement.executeUpdate(sql1);

            //PreparedStatement接口
            String sql2 = "insert into tb_student (name,age) values ('chy',21)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.execute();

            //关闭连接
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
