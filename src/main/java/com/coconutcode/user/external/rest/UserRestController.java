package com.coconutcode.user.external.rest;

import com.coconutcode.user.adapter.presenter.UserPresenterAdapter;
import com.coconutcode.user.adapter.presenter.model.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    private static final String USER_PATH = "/user";

    @Autowired
    private UserPresenterAdapter userPresenterAdapter;

    @RequestMapping(value = USER_PATH, method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody UserView user) {
        try {
            return createOkResponse(userPresenterAdapter.createUser(user));
        } catch (Exception exception){
            return createBadRequestResponse(exception);
        }
    }

    private ResponseEntity<String> createBadRequestResponse(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<UserView> createOkResponse(@RequestBody UserView userView) {
        return new ResponseEntity<>(userView, HttpStatus.OK);
    }
}
