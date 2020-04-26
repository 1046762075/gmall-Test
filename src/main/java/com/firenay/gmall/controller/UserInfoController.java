package com.firenay.gmall.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.firenay.gmall.entity.UserInfo;
import com.firenay.gmall.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Title: UserInfoController</p>
 * Description：
 * date：2020/4/25 22:44
 */
@RestController
public class UserInfoController {

	@Resource
	private UserService userService;

	@GetMapping("findAll")
	public List<UserInfo> findAll(){
		return userService.findAll();
	}

	@RequestMapping("addUser")
	public void addUser(UserInfo userInfo){
		String name = UUID.randomUUID().toString().substring(0, 5);
		userInfo.setLoginName(name);
		userInfo.setNickName(name);
		userInfo.setName(name);
		userInfo.setPhoneNum("1" + RandomUtil.randomNumbers(10));
		userInfo.setPasswd(UUID.randomUUID().toString().substring(0,9));
		userInfo.setEmail(name + "@qq.com");
		userInfo.setHeadImg("3");
		userInfo.setUserLevel("3");
		userService.addUser(userInfo);

		System.out.println("添加之后的主键：" + userInfo.getId());
	}

	@RequestMapping("upById")
	public String upUserById(UserInfo userInfo){
		userInfo.setName("fireNay");
		userInfo.setId("6");
		userService.upUserById(userInfo);
		return "OK";
	}

	@RequestMapping("upByName")
	public String upUserByName(UserInfo userInfo){
		userInfo.setName("fireNay");
		userInfo.setLoginName("fireNay");
		userService.upUserByName(userInfo);
		return "OK";
	}

	@RequestMapping("delUserById")
	public String delUserById(UserInfo userInfo){
		if (userService.delUserById(userInfo) > 0){
			return "OK";
		}
		return "FAIL";
	}

	@RequestMapping("delUserByName")
	public String delUserByName(UserInfo userInfo){
		if (userService.delUserByName(userInfo) > 0){
			return "OK";
		}
		return "FAIL";
	}

	@RequestMapping("delUserByNickName")
	public String delUserByNickName(UserInfo userInfo){
		if (userService.delUserByNickName(userInfo) > 0){
			return "OK";
		}
		return "FAIL";
	}
}
