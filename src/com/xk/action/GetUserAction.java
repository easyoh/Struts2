package com.xk.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.xk.model.User;

public class GetUserAction implements Action {
    private User user = new User();

    @Override
    public String execute() {
        user.setUsername("cqq");
        user.setEmail("cqq@qq.cn");
        User user2 = new User();
        user2.setUsername("cqqin");
        user2.setEmail("cqq@qq.cn");
        ActionContext ac = ActionContext.getContext();
        ac.put("user", user);
        ac.put("user2", user2);
        return "success";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
