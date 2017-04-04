package org.framestudy.redis.repository;

import org.framestudy.redis.entitys.UserInfo;

public interface UserInfoRepository {

	/**
	 * 添加一个用户
	 * @param user
	 */
	public void saveUserInfo(UserInfo user);
	
	/**
	 * 根据name查询用户
	 * @param id
	 */
	public UserInfo getUserInfoByName(String name);
	
	
	
	/**
	 * 修改一个用户
	 * @param user
	 */
	public void updateUserInfo(UserInfo user);
	
	/**
	 * 
	 * @param name
	 */
	public void deleteUserInfo(String name);
	
}
