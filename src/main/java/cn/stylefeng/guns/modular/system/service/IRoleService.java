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
package cn.stylefeng.1466951331.modular.system.service;

import cn.stylefeng.1466951331.core.common.node.ZTreeNode;
import cn.stylefeng.1466951331.modular.system.model.Role;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 角色相关业务
 *
 * @author fengshuonan
 * @Date 2017�?�?0�?下午9:11:57
 */
public interface IRoleService extends IService<Role> {

    /**
     * 设置某个角色的权�?
     *
     * @param roleId 角色id
     * @param ids    权限的id
     * @date 2017�?�?3�?下午8:26:53
     */
    void setAuthority(Integer roleId, String ids);

    /**
     * 删除角色
     *
     * @author stylefeng
     * @Date 2017/5/5 22:24
     */
    void delRoleById(Integer roleId);

    /**
     * 根据条件查询角色列表
     *
     * @return
     * @date 2017�?�?2�?下午9:14:34
     */
    List<Map<String, Object>> selectRoles(String condition);

    /**
     * 删除某个角色的所有权�?
     *
     * @param roleId 角色id
     * @return
     * @date 2017�?�?3�?下午7:57:51
     */
    int deleteRolesById(Integer roleId);

    /**
     * 获取角色列表�?
     *
     * @return
     * @date 2017�?�?8�?上午10:32:04
     */
    List<ZTreeNode> roleTreeList();

    /**
     * 获取角色列表�?
     *
     * @return
     * @date 2017�?�?8�?上午10:32:04
     */
    List<ZTreeNode> roleTreeListByRoleId(String[] roleId);
}
