package com.firenay.gmall.service;

import com.firenay.gmall.entity.UserInfo;

import java.util.List;

/**
 * <p>Title: UserService</p>
 * Description：
 * date：2020/4/25 22:38
 */
public interface UserService {

	List<UserInfo> findAll();

	void addUser(UserInfo userInfo);

	void upUserById(UserInfo userInfo);

	void upUserByName(UserInfo userInfo);

	/**
	 * 删除的三种方式
	 * @param userInfo
	 * @return
	 */
	int delUserById(UserInfo userInfo);

	int delUserByName(UserInfo userInfo);

	int delUserByNickName(UserInfo userInfo);

}
