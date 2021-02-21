package cn.csms.controller;

import cn.csms.aspect.WebLog;
import cn.csms.base.ResultBean;
import cn.csms.base.ResultConst;
import cn.csms.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author Promote
 * @since 2021-02-21
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    @WebLog("登录接口")
    public ResponseEntity login(String account, String password) {
        String jwt = userService.login(account, password);
        return new ResponseEntity<>(ResultBean.ok(ResultConst.LOGIN_SUCC, new JSONObject().fluentPut("token", jwt)),
                HttpStatus.OK);
    }

}
