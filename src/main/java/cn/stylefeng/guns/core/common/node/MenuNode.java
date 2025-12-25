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
package cn.stylefeng.1466951331.core.common.node;

import cn.stylefeng.roses.kernel.model.enums.YesOrNotEnum;

import java.util.*;

/**
 * @author fengshuonan
 * @Description 菜单的节�?
 * @date 2016�?2�?�?上午11:34:17
 */
public class MenuNode implements Comparable {

    /**
     * 节点id
     */
    private Long id;

    /**
     * 父节�?
     */
    private Long parentId;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 按钮级别
     */
    private Integer levels;

    /**
     * 按钮级别
     */
    private Integer ismenu;

    /**
     * 按钮的排�?
     */
    private Integer num;

    /**
     * 节点的url
     */
    private String url;

    /**
     * 节点图标
     */
    private String icon;

    /**
     * 子节点的集合
     */
    private List<MenuNode> children;

    /**
     * 查询子节点时候的临时集合
     */
    private List<MenuNode> linkedList = new ArrayList<MenuNode>();

    public MenuNode() {
        super();
    }

    public MenuNode(Long id, Long parentId) {
        super();
        this.id = id;
        this.parentId = parentId;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public static MenuNode createRoot() {
        return new MenuNode(0L, -1L);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuNode> getChildren() {
        return children;
    }

    public void setChildren(List<MenuNode> children) {
        this.children = children;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getIsmenu() {
        return ismenu;
    }

    public void setIsmenu(Integer ismenu) {
        this.ismenu = ismenu;
    }

    @Override
    public String toString() {
        return "MenuNode{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", levels=" + levels +
                ", num=" + num +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", children=" + children +
                ", linkedList=" + linkedList +
                '}';
    }

    /**
     * 重写排序比较接口，首先根据等级排序，然后更具排序字段排序
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        MenuNode menuNode = (MenuNode) o;
        Integer num = menuNode.getNum();
        Integer levels = menuNode.getLevels();
        if (num == null) {
            num = 0;
        }
        if (levels == null) {
            levels = 0;
        }
        if (this.levels.compareTo(levels) == 0) {
            return this.num.compareTo(num);
        } else {
            return this.levels.compareTo(levels);
        }

    }

    /**
     * 构建页面菜单列表
     */
    public static List<MenuNode> buildTitle(List<MenuNode> nodes) {
        if (nodes.size() <= 0) {
            return nodes;
        }
        //剔除非菜�?
        nodes.removeIf(node -> !node.getIsmenu().equals(YesOrNotEnum.Y.getCode()));
        //对菜单排序，返回列表按菜单等级，序号的排序方式排�?
        Collections.sort(nodes);
        return mergeList(nodes, nodes.get(nodes.size() - 1).getLevels(), null);
    }

    /**
     * 递归合并数组为子数组，最后返回第一�?
     *
     * @param menuList
     * @param listMap
     * @return
     */
    private static List<MenuNode> mergeList(List<MenuNode> menuList, int rank, Map<Long, List<MenuNode>> listMap) {
        //保存当次调用总共合并了多少元�?
        int n;
        //保存当次调用总共合并出来的list
        Map<Long, List<MenuNode>> currentMap = new HashMap<>();
        //由于按等级从小到大排序，需要从后往前排�?
        //判断该节点是否属于当前循环的等级,不等于则跳出循环
        for (n = menuList.size() - 1; n >= 0 && menuList.get(n).getLevels() == rank; n--) {
            //判断之前的调用是否有返回以该节点的id为key的map，有则设置为children列表�?
            if (listMap != null && listMap.get(menuList.get(n).getId()) != null) {
                menuList.get(n).setChildren(listMap.get(menuList.get(n).getId()));
            }
            if (menuList.get(n).getParentId() != null && menuList.get(n).getParentId() != 0) {
                //判断当前节点所属的pid是否已经创建了以该pid为key的键值对，没有则创建新的链表
                currentMap.computeIfAbsent(menuList.get(n).getParentId(), k -> new LinkedList<>());
                //将该节点插入到对应的list的头�?
                currentMap.get(menuList.get(n).getParentId()).add(0, menuList.get(n));
            }
        }
        if (n < 0) {
            return menuList;
        } else {
            return mergeList(menuList.subList(0, n + 1), menuList.get(n).getLevels(), currentMap);
        }
    }


}
