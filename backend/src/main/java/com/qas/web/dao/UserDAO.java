package com.qas.web.dao;

import com.qas.web.domains.User;

public interface UserDAO {
    public void register(User registerObj) throws Exception;
}
