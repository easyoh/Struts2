package com.xk.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.xk.model.User;
import com.xk.service.UserService;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.Map;

public class GetLoginUserAction implements Action {
    private User user = new User();
    private String username;
    private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
    public String execute() {
        ActionContext ac = ActionContext.getContext();

        if( username != null &&  password != null){
            user.setUsername(username);
            user.setPassword(password);

            //创建userService类，业务逻辑类
            UserService userService = new UserService();
            if(userService.checkUser(user)){
                user = userService.getLoginUser(user);
                ac.put("user", user);
                ArrayList<User> allUsers = userService.getAllUsers();
                ac.put("allUsers", allUsers);
                return "success";
            }else{
                return "error";
            }
        }
        else{
            return "error";
        }
    }
}
