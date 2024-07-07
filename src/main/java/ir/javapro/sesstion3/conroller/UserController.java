package ir.javapro.sesstion3.conroller;

import ir.javapro.sesstion3.dto.request.UserLoginRequest;
import ir.javapro.sesstion3.dto.request.UserRequest;
import ir.javapro.sesstion3.dto.response.UserResponse;
import ir.javapro.sesstion3.model.User;
import ir.javapro.sesstion3.service.user.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest userRequest ){
       return ResponseEntity.ok(userService.save(userRequest));

    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserLoginRequest userLoginRequest) {
        userService.login(userLoginRequest);
        return ResponseEntity.ok().build();
    }



    @GetMapping
    public ResponseEntity <Page<User>> getAllUser(Pageable pageable){
        return ResponseEntity.ok(userService.findAll(pageable));


    }

    @PutMapping("/enable/{id}/{enable}")
    public ResponseEntity<?> changeEnableUser (@PathVariable Boolean enable , @PathVariable Long id){
        userService.changeEnable(enable , id);
        return ResponseEntity.ok().build();

    }

}
