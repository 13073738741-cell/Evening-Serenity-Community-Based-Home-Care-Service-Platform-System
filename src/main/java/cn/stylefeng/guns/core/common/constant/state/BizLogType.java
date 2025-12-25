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
package cn.stylefeng.1466951331.core.common.constant.state;

/**
 * 业务日志类型
 *
 * @author fengshuonan
 * @Date 2017�?�?2�?下午12:14:59
 */
public enum BizLogType {

    ALL(0, null),//全部日志
    BUSSINESS(1, "业务日志"),
    EXCEPTION(2, "异常日志");

    Integer val;
    String message;

    BizLogType(Integer val, String message) {
        this.val = val;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public static String valueOf(Integer value) {
        if (value == null) {
            return null;
        } else {
            for (BizLogType bizLogType : BizLogType.values()) {
                if (bizLogType.getVal().equals(value)) {
                    return bizLogType.getMessage();
                }
            }
            return null;
        }
    }
}
