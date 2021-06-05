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

package com.niezhili.dataplatform.common.constants;


/**
 * Constants
 */
public final class Constants {

    private Constants() {
        throw new UnsupportedOperationException("Construct Constants");
    }

    /**
     * common properties path
     */
    public static final String COMMON_PROPERTIES_PATH = "/common.properties";

    /**
     * datasource configuration path
     */
    public static final String DATASOURCE_PROPERTIES = "/datasource.properties";

    /**
     * data source config
     */

    public static final String SPRING_DATASOURCE_DRIVER_CLASS_NAME = "spring.datasource.driver-class-name";

    public static final String SPRING_DATASOURCE_URL = "spring.datasource.url";

    public static final String SPRING_DATASOURCE_USERNAME = "spring.datasource.username";

    public static final String SPRING_DATASOURCE_PASSWORD = "spring.datasource.password";

    public static final String SPRING_DATASOURCE_VALIDATION_QUERY_TIMEOUT = "spring.datasource.validationQueryTimeout";

    public static final String SPRING_DATASOURCE_INITIAL_SIZE = "spring.datasource.initialSize";

    public static final String SPRING_DATASOURCE_MIN_IDLE = "spring.datasource.minIdle";

    public static final String SPRING_DATASOURCE_MAX_ACTIVE = "spring.datasource.maxActive";

    public static final String SPRING_DATASOURCE_MAX_WAIT = "spring.datasource.maxWait";

    public static final String SPRING_DATASOURCE_TIME_BETWEEN_EVICTION_RUNS_MILLIS = "spring.datasource.timeBetweenEvictionRunsMillis";

    public static final String SPRING_DATASOURCE_TIME_BETWEEN_CONNECT_ERROR_MILLIS = "spring.datasource.timeBetweenConnectErrorMillis";

    public static final String SPRING_DATASOURCE_MIN_EVICTABLE_IDLE_TIME_MILLIS = "spring.datasource.minEvictableIdleTimeMillis";

    public static final String SPRING_DATASOURCE_VALIDATION_QUERY = "spring.datasource.validationQuery";

    public static final String SPRING_DATASOURCE_TEST_WHILE_IDLE = "spring.datasource.testWhileIdle";

    public static final String SPRING_DATASOURCE_TEST_ON_BORROW = "spring.datasource.testOnBorrow";

    public static final String SPRING_DATASOURCE_TEST_ON_RETURN = "spring.datasource.testOnReturn";

    public static final String SPRING_DATASOURCE_POOL_PREPARED_STATEMENTS = "spring.datasource.poolPreparedStatements";

    public static final String SPRING_DATASOURCE_DEFAULT_AUTO_COMMIT = "spring.datasource.defaultAutoCommit";

    public static final String SPRING_DATASOURCE_KEEP_ALIVE = "spring.datasource.keepAlive";

    public static final String SPRING_DATASOURCE_MAX_POOL_PREPARED_STATEMENT_PER_CONNECTION_SIZE = "spring.datasource.maxPoolPreparedStatementPerConnectionSize";


}
