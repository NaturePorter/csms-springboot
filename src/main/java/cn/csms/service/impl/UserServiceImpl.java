package cn.csms.service.impl;

import cn.csms.base.ResultConst;
import cn.csms.common.utils.JwtUtil;
import cn.csms.entity.User;
import cn.csms.exception.BussinessException;
import cn.csms.mapper.UserMapper;
import cn.csms.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author Promote
 * @since 2021-02-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserService userService;

    @Override
    public String login(String account, String password, int type) {
        User user = null;
        String jwt = null;
        // type == 1 时为管理员登录
        if (type == 1) {
            try {
                LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery().eq(User::getAccount, account).eq(User::getPassword, password);
                user = userService.getOne(queryWrapper);
                if (user == null) {
                    throw new BussinessException(401, ResultConst.INVALID_PASSWORD);
                }
            } catch (Exception e) {
                throw new BussinessException(401, ResultConst.INVALID_PASSWORD);
            }
            try {
                // 生成jwt令牌
                jwt = JwtUtil.createJWT(UUID.randomUUID().toString(), account, null);
                // 更新登录时间和token
                user.setLogintime(new Date());
                user.setToken(jwt);
                userService.updateById(user);
            } catch (Exception e) {
                throw new BussinessException(401, ResultConst.USER_ISDELETE);
            }
        }
        // 返回jwt字符串
        return jwt;
    }
}
