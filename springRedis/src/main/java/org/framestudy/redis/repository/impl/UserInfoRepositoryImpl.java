package org.framestudy.redis.repository.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
	
	@Override
	public void optObject() {
		// TODO Auto-generated method stub
		UserInfo user = new UserInfo(1L, "小明", 12, "123123");
		redisTemplate.opsForValue().set(user.getKey(), user);//添加对象
		user.setAge(18);
		redisTemplate.opsForValue().set(user.getKey(), user);//更新对象
		
		// 5 代表user对象在redis服务器中，可以存在的最长时间
		redisTemplate.opsForValue().set("user", user,5,TimeUnit.SECONDS);
		
		try {
			Thread.sleep(6000);
			System.out.println(redisTemplate.opsForValue().get("user"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(redisTemplate.opsForValue().get(user.getKey()));//获取对象
	}

	@Override
	public void optHashMap() {
		// TODO Auto-generated method stub
//		redisTemplate.opsForHash()
		
	}

	@Override
	public void optList() {
		// TODO Auto-generated method stub
//		redisTemplate.opsForList()
		
		
	}

	@Override
	public void optSet() {
		// TODO Auto-generated method stub
		redisTemplate.opsForSet().add("users", new UserInfo(),new UserInfo(),new UserInfo());
	}

	@Override
	public void optSort() {
		// TODO Auto-generated method stub
		//查看以下网址
//		https://blog.csdn.net/weixin_37490221/article/details/78135815
	}
	


}
