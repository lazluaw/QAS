package com.qas.web.servies;

import com.qas.web.domains.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    public void joinProcess(User joinObj);

    public void loginProcess(User loginObj);

    public void updateProcess(User updateObj);

    public void deleteProcess(String deletePassword);
}