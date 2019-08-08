package bupt.sse.SmartCampus.service;

import bupt.sse.SmartCampus.model.User;

public interface UserService {
    //检验用户登录
    User checkLogin(String username);
}
