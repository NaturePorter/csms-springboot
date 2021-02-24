package cn.csms.controller;

import cn.csms.aspect.WebLog;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/menus")
    @WebLog("获取菜单")
    public String findMenus(){
        return "{\"data\":[{\"id\":100,\"authName\":\"考试成绩分析\",\"path\":\"users\",\"children\":[{\"id\":101,\"authName\":\"考试列表\",\"path\":\"users\",\"children\":[],\"order\":null}],\"order\":1},{\"id\":200,\"authName\":\"学生信息管理\",\"path\":\"rights\",\"children\":[{\"id\":201,\"authName\":\"学生列表\",\"path\":\"roles\",\"children\":[],\"order\":null}],\"order\":2},{\"id\":300,\"authName\":\"教师信息管理\",\"path\":\"goods\",\"children\":[{\"id\":301,\"authName\":\"教师列表\",\"path\":\"goods\",\"children\":[],\"order\":1}],\"order\":3},{\"id\":400,\"authName\":\"基础信息管理\",\"path\":\"orders\",\"children\":[{\"id\":401,\"authName\":\"订单列表\",\"path\":\"orders \",\"children\":[],\"order\":null}],\"order\":4},{\"id\":500,\"authName\":\"系统管理\",\"path\":\"reports\",\"children\":[{\"id\":501,\"authName\":\"系统设置\",\"path\":\"reports\",\"children\":[],\"order\":null}],\"order\":5}],\"meta\":{\"msg\":\"获取菜单列表成功\",\"status\":200}}";
    }
}
