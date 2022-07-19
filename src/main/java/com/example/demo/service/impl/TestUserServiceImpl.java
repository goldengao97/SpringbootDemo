package com.example.demo.service.impl;

import com.alibaba.fastjson2.JSON;
import com.example.demo.bean.TestUser;
import com.example.demo.dao.TestUserDao;
import com.example.demo.service.TestUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LegionGolden
 */
@Repository
public class TestUserServiceImpl implements TestUserService {
    public static Logger logger = LoggerFactory.getLogger(TestUserServiceImpl.class);

    @Autowired
    TestUserDao testUserDao;

    /**
     * @description: 查找用户
     * @date: 2021/7/13 16:31
     * @author: Golden
     */
    @Override
    public String findUser(String id) {
        TestUser testUser = testUserDao.selectByPrimaryKey(Integer.valueOf(id));
        return (null==testUser?"查无此人": JSON.toJSONString(testUser));
    }

    /**
     * @description: 新增用户
     * @date: 2021/7/13 16:31
     * @author: Golden
     */
    @Override
    public String registUser(List<TestUser> testUsers) {
        int count = 0;
        int errCount = 0;
        for (TestUser testUser:testUsers) {
            try {
                if (1 == testUserDao.insert(testUser)) {
                    count++;
                }
            }catch (Exception e){
                logger.error("用户新增报错---------->"+e.getCause());
                errCount++;
                continue;
            }
        }
        logger.info("添加成功"+count+"个用户，失败"+errCount+"个");
        return "添加成功"+count+"个用户，失败"+errCount+"个";
    }

    /**
     * @description: 删除用户
     * @date: 2021/7/17 11:30
     * @author: Golden
     */
    @Override
    public String deleteUser(List<TestUser> testUsers) {
        int count = 0;
        int errCount = 0;
        for (TestUser testUser:testUsers) {
            if (1 == testUserDao.deleteByPrimaryKey(testUser.getId())) {
                count++;
            }else {
                errCount++;
            }

        }
        logger.info("删除成功"+count+"个用户，失败"+errCount+"个");
        return "删除成功"+count+"个用户，失败"+errCount+"个";
    }
}
