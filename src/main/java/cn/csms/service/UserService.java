package cn.csms.service;

import cn.csms.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author Promote
 * @since 2021-02-21
 */
public interface UserService extends IService<User> {
    /**
     * 登录方法
     * @param account
     * @param password
     * @param type
     * @return 返回登录生成的token令牌
     */
    String login(String account, String password, int type);
}
