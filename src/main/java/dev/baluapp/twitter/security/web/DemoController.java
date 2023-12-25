package dev.baluapp.twitter.security.web;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping("/just-auth")
    public String hitJustAuthEndpoint() {
        return "This is protected resource. Only auth";
    }
    @GetMapping("/just-role-user")
    public String hitJustRoleUserEndpoint() {
        return "This is protected resource. Only user";
    }
    @GetMapping("/just-role-admin")
    public String hitJustRoleAdminEndpoint() {
        return "This is protected resource. Only admin";
    }
}
