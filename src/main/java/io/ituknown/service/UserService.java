package io.ituknown.service;

import io.ituknown.domain.User;

import java.util.List;

public interface UserService {

    List<User> defaultList();
    
    List<User> masterList();

    List<User> slaveList();
}
