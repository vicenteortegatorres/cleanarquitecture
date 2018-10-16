package com.coconutcode.user.adapter.presenter;

import com.coconutcode.user.entity.User;
import com.coconutcode.user.usecases.CreateUserUseCase;
import com.coconutcode.user.usecases.MandatoryValueNotIncludedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.coconutcode.user.adapter.presenter.model.UserView;

@RestController
public class UserPresenterAdapter {
    private static final String USER_PATH = "/user";

    private final CreateUserUseCase createUserUseCase;

    public UserPresenterAdapter(CreateUserUseCase createUserUseCase){
        this.createUserUseCase = createUserUseCase;
    }

    @RequestMapping(value = USER_PATH, method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody UserView user) {
        try {
            return new ResponseEntity<>(new UserView(createUserUseCase.createUser(new User(user.getUsername()))),
                    HttpStatus.OK);
        } catch (MandatoryValueNotIncludedException mandatoryValueNotIncluded){
            return new ResponseEntity<>(mandatoryValueNotIncluded.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
