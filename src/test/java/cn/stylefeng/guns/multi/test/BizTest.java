package cn.stylefeng.1466951331.multi.test;

import cn.stylefeng.1466951331.base.BaseJunit;
import cn.stylefeng.1466951331.multi.service.TestService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 业务测试
 *
 * @author fengshuonan
 * @date 2017-06-23 23:12
 */
public class BizTest extends BaseJunit {

    @Autowired
    private TestService testService;

    @Test
    public void test() {
        testService.test1466951331();

        testService.testBiz();
    }
}
