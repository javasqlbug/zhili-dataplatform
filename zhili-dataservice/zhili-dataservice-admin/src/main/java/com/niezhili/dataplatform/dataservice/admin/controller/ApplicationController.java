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

package com.niezhili.dataplatform.dataservice.admin.controller;

import com.niezhili.dataplatform.dataservice.admin.service.ApplicationService;
import com.niezhili.dataplatform.dataservice.admin.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 * @author niezhili
 * @date 2021-05-29
 * 应用管理controller
 */
@Api(tags = "应用管理")
@RestController
@RequestMapping("application")
public class ApplicationController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    @Autowired
    private ApplicationService applicationService;

    /**
     * create data source
     *
     * @return create result code
     */
    @ApiOperation(value = "createDataSource", notes = "CREATE_DATA_SOURCE_NOTES")
    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Result createDataSource() {
        applicationService.test();
        return null;
    }

    @ApiOperation(value = "列表", notes = "QUERY_ALERT_GROUP_LIST_NOTES")
    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    public void list() {
        System.out.println("测试");
    }


    @PostMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestParam(value = "id") int id,
                                   @RequestParam(value = "name") String name) {


    }


    @PostMapping(value = "/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam(value = "id") int id) {
    }
}
