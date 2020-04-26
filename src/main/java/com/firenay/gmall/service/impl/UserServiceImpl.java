package com.firenay.gmall.service.impl;

import com.firenay.gmall.entity.UserInfo;
import com.firenay.gmall.mapper.UserInfoMapper;
import com.firenay.gmall.service.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Title: UserServiceImpl</p>
 * Description：
 * date：2020/4/25 22:39
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserInfoMapper userInfoMapper;

	@Override
	public List<UserInfo> findAll() {
		return userInfoMapper.selectAll();
	}

	@Override
	public void addUser(UserInfo userInfo) {
		// 有选择的添加
		userInfoMapper.insertSelective(userInfo);
	}

	@Override
	public void upUserById(UserInfo userInfo) {
		userInfoMapper.updateByPrimaryKeySelective(userInfo);
	}

	@Override
	public void upUserByName(UserInfo userInfo) {
		Example example = new Example(UserInfo.class);
		// 第一个参数表示要修改的字段 第二个参数表示要修改的值
		example.createCriteria().andEqualTo("name",userInfo.getName());
		// 第二个参数表示根据什么条件修改
		userInfoMapper.updateByExampleSelective(userInfo,example);
	}

	@Override
	public int delUserById(UserInfo userInfo) {
		return userInfoMapper.deleteByPrimaryKey(userInfo);
	}

	public int delUserByName(UserInfo userInfo) {
		Example example = new Example(UserInfo.class);

		// 根据 name 来删除
		example.createCriteria().andEqualTo("name",userInfo.getName());
		return userInfoMapper.deleteByExample(example);
	}

	@Override
	public int delUserByNickName(UserInfo userInfo) {
		return userInfoMapper.delete(userInfo);
	}
}
