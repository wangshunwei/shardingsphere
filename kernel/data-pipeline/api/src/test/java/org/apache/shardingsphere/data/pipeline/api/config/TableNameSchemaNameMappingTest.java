/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.data.pipeline.api.config;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

public final class TableNameSchemaNameMappingTest {
    
    @Test
    public void assertConstructFromNull() {
        new TableNameSchemaNameMapping(null);
    }
    
    @Test
    public void assertConstructFromValueNullMap() {
        Map<String, String> map = new HashMap<>();
        map.put("t_order", null);
        TableNameSchemaNameMapping mapping = new TableNameSchemaNameMapping(map);
        assertNull(mapping.getSchemaName("t_order"));
    }
    
    @Test
    public void assertConstructFromMap() {
        Map<String, String> map = new HashMap<>();
        map.put("t_order", "public");
        TableNameSchemaNameMapping mapping = new TableNameSchemaNameMapping(map);
        assertThat(mapping.getSchemaName("t_order"), is("public"));
    }
}
