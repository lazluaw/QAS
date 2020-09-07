package com.qas.web.servies;

import com.qas.web.dao.UserDAOImpl;
import com.qas.web.domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    User user;
    @Autowired
    UserDAOImpl userDAO;

    @Override
    public void joinProcess(User joinObj) {

    }

    @Override
    public void loginProcess(User loginObj) {

    }

    @Override
    public void updateProcess(User updateObj) {

    }

    @Override
    public void deleteProcess(String deletePassword) {

    }
}

