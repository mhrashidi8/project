package ir.javapro.sesstion3.service.user;

import ir.javapro.sesstion3.dto.request.UserLoginRequest;
import ir.javapro.sesstion3.dto.request.UserRequest;
import ir.javapro.sesstion3.dto.response.UserResponse;
import ir.javapro.sesstion3.exception.RuleException;
import ir.javapro.sesstion3.model.User;
import ir.javapro.sesstion3.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService  {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserResponse save(UserRequest userRequest) {
        Optional <User> byUsername =
        userRepository.findByUsername(userRequest.getUsername());


        if (byUsername.isPresent())
            throw new RuleException("user.is.exist");
        return createUserResponse(userRepository.save(createUser(userRequest)));
    }

    @Override
    public void login(UserLoginRequest userLoginRequest) {
       User user = userRepository.findByUsername(userLoginRequest.getUsername())
                .orElseThrow(()-> new RuleException("user.not.found"));
       if (!user.getPassword().equals(userLoginRequest.getPassword())) {
           throw new RuleException("user.not.found");


       }

    }

    @Override
    public void changeEnable(Boolean enable, Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new RuleException("user.not.found"));
        user.setEnabled(enable);
        userRepository.save(user);

    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }


    private UserResponse createUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();

    }


private User createUser(UserRequest userRequest) {
        return User.builder()
                .password(userRequest.getPassword())
                .username(userRequest.getUsername())
                .build();

}



}
