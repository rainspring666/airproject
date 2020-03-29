package com.example.demo;

import com.example.demo.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.mapper.*;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Test
//	public void testGetUserResultMap() {
//		// mybatis和spring整合，整合之后，交给spring管理
//		SqlSession sqlSession = this.sqlSessionFactory.openSession();
//		// 创建Mapper接口的动态代理对象，整合之后，交给spring管理
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//
//		// 使用userMapper执行根据条件查询用户，结果封装到Order类中<
//		User user = userMapper.Sel(1111);
//		System.out.println(user);
//		// mybatis和spring整合，整合之后，交给spring管理
//		sqlSession.close();
//	}
}
