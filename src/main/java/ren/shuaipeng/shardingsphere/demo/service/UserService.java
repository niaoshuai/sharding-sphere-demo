package ren.shuaipeng.shardingsphere.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ren.shuaipeng.shardingsphere.demo.mapper.UserMapper;
import ren.shuaipeng.shardingsphere.demo.model.UserEntity;
import ren.shuaipeng.shardingsphere.demo.model.UserLoginReq;
import ren.shuaipeng.shardingsphere.demo.model.UserRegisterReq;

import java.util.UUID;

/**
 * 业务代码
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    /**
     * 注册业务
     */
    public void register(UserRegisterReq req) {
        UserEntity user = new UserEntity();
        user.setId(UUID.randomUUID().toString());
        user.setUserName(req.getUserName());
        user.setPassword(req.getPassword());
        userMapper.insertUser(user);
    }

    public UserEntity login(UserLoginReq req) {
        UserEntity tttt = userMapper.findByUserName(req.getUserName());
        if (tttt == null) {
            throw new RuntimeException("用户不存在");
        }
        if (!tttt.getPassword().equals(req.getPassword())) {
            throw new RuntimeException("密码不存在");
        }
        return tttt;
    }
}
