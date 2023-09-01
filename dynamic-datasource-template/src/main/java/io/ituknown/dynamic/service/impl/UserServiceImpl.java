package io.ituknown.dynamic.service.impl;

import io.ituknown.dynamic.config.MasterDataSource;
import io.ituknown.dynamic.config.SlaveDataSource;
import io.ituknown.dynamic.domain.User;
import io.ituknown.dynamic.mapper.UserMapper;
import io.ituknown.dynamic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> defaultList() {
        return userMapper.findList();
    }

    @Override
    @MasterDataSource
    public List<User> masterList() {
        return userMapper.findList();
    }

    @Override
    @SlaveDataSource
    public List<User> slaveList() {
        return userMapper.findList();
    }
}
