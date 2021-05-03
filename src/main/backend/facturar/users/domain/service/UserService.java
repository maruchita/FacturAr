package facturar.users.domain.service;

import facturar.users.domain.UserCreatedEvent;
import facturar.users.domain.model.GetUserQuery;
import facturar.users.domain.model.UserBean;

import java.security.NoSuchAlgorithmException;

public interface UserService {

    void on(UserCreatedEvent event) throws NoSuchAlgorithmException;

    UserBean getUser(GetUserQuery query);

}
