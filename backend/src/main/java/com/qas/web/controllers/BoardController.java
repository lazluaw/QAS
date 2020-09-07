package com.qas.web.controllers;

import com.qas.web.domains.Board;
import com.qas.web.servies.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main")
public class BoardController {
    @Autowired
    Board board;
    @Autowired
    BoardService boardService;

    @PostMapping("/register")
    public void registerPost(@RequestBody Board addObj) throws Exception {
        boardService.addProcess(addObj);
    }

    @PostMapping("/retrieve")
    public void retrieveOne(@RequestBody Board addObj) throws Exception {
        boardService.addProcess(addObj);
    }


    @PutMapping("/update")
    public void update(@RequestBody Board updateObj) throws Exception {
        boardService.updateProcess(updateObj);
    }

    @DeleteMapping("/{post}")
    public void delete(@PathVariable("post") String deletePost) throws Exception {
        boardService.deleteProcess(deletePost);
    }
}
