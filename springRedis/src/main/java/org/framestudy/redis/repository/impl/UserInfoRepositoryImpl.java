package org.framestudy.redis.repository.impl;

import javax.annotation.Resource;

import org.framestudy.redis.entitys.UserInfo;
import org.framestudy.redis.repository.UserInfoRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoRepositoryImpl implements UserInfoRepository {

	@Resource
    private RedisTemplate<String,UserInfo> redisTemplate;
	//这里可以放置其他的Session
	
	@Override
	public void saveUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		System.out.println(user);
		redisTemplate.opsForValue().set(user.getUserName(), user);
	}
	
	
	@Override
	public UserInfo getUserInfoByName(String userName) {
		// TODO Auto-generated method stub
		System.out.println(userName);
		return redisTemplate.opsForValue().get(userName);
	}
	
	@CacheEvict(value="default",key="#userName")//清空ID为多少的对象
	@Override
	public void deleteUserInfo(String userName) {
		// TODO Auto-generated method stub
		
		 /*redisTemplate.opsForList(); 
        redisTemplate.opsForSet(); 
        redisTemplate.opsForHash()*/ 
		
		
		redisTemplate.opsForValue().getOperations().delete(userName);
	}

	@Override
	public void updateUserInfo(UserInfo user) {
		// TODO Auto-generated method stub
		redisTemplate.opsForValue().set(user.getUserName(), user);
	}

}
