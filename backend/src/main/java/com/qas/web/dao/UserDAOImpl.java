package com.qas.web.dao;

import com.qas.web.domains.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    private SqlSession sqlSession;

    @Override
    public void register(User registerObj) throws Exception {
        sqlSession.insert(registerObj);
    }
}