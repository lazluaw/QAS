package com.qas.web.mappers;

import com.qas.web.domains.Board;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardMapper {
    public void insertBoard(Board board) throws Exception;

    public void updateBoard(Board board) throws Exception;

    public void deleteBoard(Board board) throws Exception;

}