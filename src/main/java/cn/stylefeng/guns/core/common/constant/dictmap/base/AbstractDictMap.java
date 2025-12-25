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
package cn.stylefeng.1466951331.core.common.constant.dictmap.base;

import java.util.HashMap;

/**
 * 字典映射抽象�?
 *
 * @author fengshuonan
 * @date 2017-05-06 14:58
 */
public abstract class AbstractDictMap {

    protected HashMap<String, String> dictory = new HashMap<>();
    protected HashMap<String, String> fieldWarpperDictory = new HashMap<>();

    public AbstractDictMap() {
        put("id", "主键id");
        init();
        initBeWrapped();
    }

    /**
     * 初始化字段英文名称和中文名称对应的字�?
     *
     * @author stylefeng
     * @Date 2017/5/9 19:39
     */
    public abstract void init();

    /**
     * 初始化需要被包装的字�?例如:性别�?:�?2:�?需要被包装为汉�?
     *
     * @author stylefeng
     * @Date 2017/5/9 19:35
     */
    protected abstract void initBeWrapped();

    public String get(String key) {
        return this.dictory.get(key);
    }

    public void put(String key, String value) {
        this.dictory.put(key, value);
    }

    public String getFieldWarpperMethodName(String key) {
        return this.fieldWarpperDictory.get(key);
    }

    public void putFieldWrapperMethodName(String key, String methodName) {
        this.fieldWarpperDictory.put(key, methodName);
    }
}
