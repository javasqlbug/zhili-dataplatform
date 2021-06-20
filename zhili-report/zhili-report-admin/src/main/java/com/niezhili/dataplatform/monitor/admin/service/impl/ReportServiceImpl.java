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

package com.niezhili.dataplatform.monitor.admin.service.impl;

import com.niezhili.dataplatform.monitor.dao.entity.Project;
import com.niezhili.dataplatform.monitor.dao.mapper.ProjectMapper;
import com.niezhili.dataplatform.monitor.admin.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public void test() {
        Date now = new Date();
        Project project = Project
                .newBuilder()
                .name("测试项目")
                .description("ssss")
                .userId(111)
                .userName("niezhili")
                .createTime(now)
                .updateTime(now)
                .build();

        projectMapper.insert(project);
    }
}
