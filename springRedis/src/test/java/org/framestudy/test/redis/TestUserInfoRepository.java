package org.framestudy.test.redis;

import javax.annotation.Resource;

import org.framestudy.redis.repository.UserInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:config/spring-data-redis.xml"})
public class TestUserInfoRepository {

	@Resource
	private UserInfoRepository userInfoRepositoryImpl;
	
	@Test
	public void testOptObject(){
		userInfoRepositoryImpl.optObject();
	}
	
	
	
	
	
}
