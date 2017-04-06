package org.framestudy.redis.repository.impl;

import javax.annotation.Resource;

import org.framestudy.redis.entitys.UserInfo;
import org.framestudy.redis.repository.UserInfoRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
/**
 * redis操作简单对象
 * @author Administrator
 *
 */
@Repository
public class UserInfoRepositoryImpl implements UserInfoRepository {

	@Resource
    private RedisTemplate<String,UserInfo> redisTemplate;//创建一个关于UserInfo的缓存模板
	//这里可以放置其他的Session

	@Override
	public void optObject() {
		// TODO Auto-generated method stub
		UserInfo user = new UserInfo(1L, "小明", 12, "123123");
		redisTemplate.opsForValue().set(user.getKey(), user);//添加对象
		
		user.setAge(18);
		redisTemplate.opsForValue().set(user.getKey(), user);//更新对象
		
		System.out.println(redisTemplate.opsForValue().get(user.getKey()));//获取对象
		
		
		
		
	}

	@Override
	public void optHashMap() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void optList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void optSet() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void optSort() {
		// TODO Auto-generated method stub
		
	}
	


}
