package cn.no7player.controller;

import java.util.List;

import cn.no7player.model.User;
import cn.no7player.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zl on 2015/8/27.
 */
@Controller
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/getUserInfo")
	@ResponseBody
	public List<User> getUserInfo() {
		List<User> userList = userService.getUserInfo();

		if (userList != null && userList.size() > 0) {
			for (User user : userList) {
				System.out.println("user.getName():" + user.getName());
				logger.info("user.getAge():" + user.getAge());
			}
		}
		return userList;
	}
}