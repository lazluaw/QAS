package com.qas.web.controllers;

import com.qas.web.domains.User;
import com.qas.web.servies.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    static Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    User user;
    @Autowired
    UserService userService;

    @PostMapping("/joinProcess")
    public void join(@RequestBody User joinObj) throws Exception {
        log.info(String.valueOf(joinObj));
        userService.joinProcess(joinObj);
    }

    @PostMapping("/loginProcess")
    public void login(@RequestBody User loginObj) throws Exception {
        log.info(String.valueOf(loginObj));
        userService.loginProcess(loginObj);
    }

    @PutMapping("/{updatePassword}")
    public void update(@PathVariable("updatePassword") String updatePassword, User updateObj) throws Exception {
        userService.updateProcess(updateObj);
    }

    @DeleteMapping("/{email}/{deletePassword}")
    public void delete(@PathVariable("email") String deleteEmail, @PathVariable("deletePassword") String deletePassword) throws Exception {
        userService.deleteProcess(deletePassword);
    }
}
