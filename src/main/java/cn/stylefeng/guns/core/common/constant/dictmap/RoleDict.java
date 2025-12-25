/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.stylefeng.1466951331.core.common.constant.dictmap;

import cn.stylefeng.1466951331.core.common.constant.dictmap.base.AbstractDictMap;

/**
 * 角色的字�?
 *
 * @author fengshuonan
 * @date 2017-05-06 15:01
 */
public class RoleDict extends AbstractDictMap {

    @Override
    public void init() {
        put("roleId", "角色名称");
        put("num", "角色排序");
        put("pid", "角色的父�?);
        put("name", "角色名称");
        put("deptid", "部门名称");
        put("tips", "备注");
        put("ids", "资源名称");
    }

    @Override
    protected void initBeWrapped() {
        putFieldWrapperMethodName("pid", "getSingleRoleName");
        putFieldWrapperMethodName("deptid", "getDeptName");
        putFieldWrapperMethodName("roleId", "getSingleRoleName");
        putFieldWrapperMethodName("ids", "getMenuNames");
    }
}
