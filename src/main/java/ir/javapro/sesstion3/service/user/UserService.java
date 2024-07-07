package ir.javapro.sesstion3.service.user;

import ir.javapro.sesstion3.dto.request.UserLoginRequest;
import ir.javapro.sesstion3.dto.request.UserRequest;
import ir.javapro.sesstion3.dto.response.UserResponse;
import ir.javapro.sesstion3.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {


    UserResponse save (UserRequest userRequest);



    void login(UserLoginRequest userLoginRequest);
    void changeEnable(Boolean enable, Long id);

    Page<User> findAll(Pageable pageable);
}
