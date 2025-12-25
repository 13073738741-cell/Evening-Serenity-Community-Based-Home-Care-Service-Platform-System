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
package cn.stylefeng.1466951331.core.shiro.service;

import cn.stylefeng.1466951331.core.shiro.ShiroUser;
import cn.stylefeng.1466951331.modular.system.model.User;
import org.apache.shiro.authc.SimpleAuthenticationInfo;

import java.util.List;

/**
 * 定义shirorealm所需数据的接�?
 *
 * @author fengshuonan
 * @date 2016�?2�?�?上午10:23:34
 */
public interface UserAuthService {

    /**
     * 根据账号获取登录用户
     *
     * @param account 账号
     */
    User user(String account);

    /**
     * 根据系统用户获取Shiro的用�?
     *
     * @param user 系统用户
     */
    ShiroUser shiroUser(User user);

    /**
     * 获取权限列表通过角色id
     *
     * @param roleId 角色id
     */
    List<String> findPermissionsByRoleId(Integer roleId);

    /**
     * 根据角色id获取角色名称
     *
     * @param roleId 角色id
     */
    String findRoleNameByRoleId(Integer roleId);

    /**
     * 获取shiro的认证信�?
     */
    SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName);

}
