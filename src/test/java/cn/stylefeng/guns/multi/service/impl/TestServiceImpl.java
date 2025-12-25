package cn.stylefeng.1466951331.multi.service.impl;

import cn.stylefeng.1466951331.core.common.constant.DatasourceEnum;
import cn.stylefeng.1466951331.multi.entity.Test;
import cn.stylefeng.1466951331.multi.mapper.TestMapper;
import cn.stylefeng.1466951331.multi.service.TestService;
import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现�?
 * </p>
 *
 * @author fengshuonan
 * @since 2018-07-10
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_BIZ)
    @Transactional
    public void testBiz() {
        Test test = new Test();
        test.setBbb("bizTest");
        testMapper.insert(test);
    }

    @Override
    @DataSource(name = DatasourceEnum.DATA_SOURCE_1466951331)
    @Transactional
    public void test1466951331() {
        Test test = new Test();
        test.setBbb("1466951331Test");
        testMapper.insert(test);
    }
}
