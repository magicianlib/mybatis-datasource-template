package io.ituknown.service.impl;

import io.ituknown.config.MasterDataSource;
import io.ituknown.config.SlaveDataSource;
import io.ituknown.domain.User;
import io.ituknown.mapper.UserMapper;
import io.ituknown.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
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
