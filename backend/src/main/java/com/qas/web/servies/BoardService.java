package com.qas.web.servies;

import com.qas.web.domains.Board;
import org.springframework.stereotype.Component;

@Component
public interface BoardService {
    public void addProcess(Board addObj);

    public Board select(Board board);

    public void updateProcess(Board updateObj);

    public void deleteProcess(String deleteObj);
}
