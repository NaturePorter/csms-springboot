package cn.csms.controller;

import cn.csms.aspect.WebLog;
import cn.csms.entity.User;
import cn.csms.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @packageName:cn.csms.controller
 * @ClassName:AuthController
 * @Description:
 * @author:Promote
 * @date:2021/2/24 19:26
 */
@RestController
@RequestMapping("/csms_api")
public class AuthController {

    @Autowired
    UserService userService;

    @GetMapping("/menus")
    @WebLog("获取菜单")
    public String findMenus(@RequestHeader("token") String token){
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery().eq(User::getToken, token);
        User user = userService.getOne(queryWrapper);
        // 根据账号类型返回菜单
        if (user.getType() == 1) {
            return "{\"data\":[{\"id\":100,\"authName\":\"考试成绩分析\",\"path\":\"exam\",\"children\":[{\"id\":101,\"authName\":\"考试列表\",\"path\":\"exams\",\"children\":[],\"order\":null}],\"order\":1},{\"id\":200,\"authName\":\"学生信息管理\",\"path\":\"rights\",\"children\":[{\"id\":201,\"authName\":\"学生列表\",\"path\":\"roles\",\"children\":[],\"order\":null}],\"order\":2},{\"id\":300,\"authName\":\"教师信息管理\",\"path\":\"goods\",\"children\":[{\"id\":301,\"authName\":\"教师列表\",\"path\":\"goods\",\"children\":[],\"order\":1}],\"order\":3},{\"id\":400,\"authName\":\"基础信息管理\",\"path\":\"orders\",\"children\":[{\"id\":401,\"authName\":\"个人信息\",\"path\":\"orders \",\"children\":[],\"order\":null}],\"order\":4},{\"id\":500,\"authName\":\"系统管理\",\"path\":\"reports\",\"children\":[{\"id\":501,\"authName\":\"系统设置\",\"path\":\"reports\",\"children\":[],\"order\":null}],\"order\":5}],\"meta\":{\"msg\":\"获取菜单列表成功\",\"status\":200}}";
        } else if (user.getType() == 2) {
            return null;
        } else if (user.getType() == 3) {
            return null;
        }
        return "{\"data\":[{\"id\":100,\"authName\":\"考试成绩分析\",\"path\":\"exam\",\"children\":[{\"id\":101,\"authName\":\"考试列表\",\"path\":\"exams\",\"children\":[],\"order\":null}],\"order\":1},{\"id\":200,\"authName\":\"学生信息管理\",\"path\":\"rights\",\"children\":[{\"id\":201,\"authName\":\"学生列表\",\"path\":\"roles\",\"children\":[],\"order\":null}],\"order\":2},{\"id\":300,\"authName\":\"教师信息管理\",\"path\":\"goods\",\"children\":[{\"id\":301,\"authName\":\"教师列表\",\"path\":\"goods\",\"children\":[],\"order\":1}],\"order\":3},{\"id\":400,\"authName\":\"基础信息管理\",\"path\":\"orders\",\"children\":[{\"id\":401,\"authName\":\"订单列表\",\"path\":\"orders \",\"children\":[],\"order\":null}],\"order\":4},{\"id\":500,\"authName\":\"系统管理\",\"path\":\"reports\",\"children\":[{\"id\":501,\"authName\":\"系统设置\",\"path\":\"reports\",\"children\":[],\"order\":null}],\"order\":5}],\"meta\":{\"msg\":\"获取菜单列表成功\",\"status\":200}}";
    }
}
