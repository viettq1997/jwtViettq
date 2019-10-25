package com.iist.vse900.controller;

import com.iist.vse900.controller.base.BaseController;
import com.iist.vse900.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(name = "/changePassword", method = RequestMethod.POST)
    public ResponseEntity changePassword(@RequestParam("username") String username, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword) {
        boolean rs = userService.changePassword(username, oldPassword, newPassword);
        if (!rs) {
            return buildResultJson(400, "Change password fail", null);
        }
        return buildResultJson(200, "success", null);
    }

    @RequestMapping(name = "/resetPassword", method = RequestMethod.PUT)
    public ResponseEntity resetPassword(@RequestParam("username") String username) {
        boolean rs = userService.resetPassword(username);
        if (!rs) {
            return buildResultJson(400, "Reset password fail!", null);
        }
        return buildResultJson(200, "reset password success", null);
    }
}
