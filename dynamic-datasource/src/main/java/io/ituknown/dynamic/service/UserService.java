package io.ituknown.dynamic.service;

import io.ituknown.dynamic.domain.User;

import java.util.List;

public interface UserService {

    List<User> defaultList();
    
    List<User> masterList();

    List<User> slaveList();
}
