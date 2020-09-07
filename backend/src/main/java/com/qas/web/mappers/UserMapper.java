package com.qas.web.mappers;

import com.qas.web.domains.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public void insertUser(User user) throws Exception;

    public void updateUser(User user) throws Exception;

    public void deleteUser(User user) throws Exception;
}