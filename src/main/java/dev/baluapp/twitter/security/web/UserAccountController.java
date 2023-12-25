package dev.baluapp.twitter.security.web;
/*
@date 25.12.2023
@author Sergey Bugaienko
*/

import dev.baluapp.twitter.security.mapper.RegisterRequestToAccountMapper;
import dev.baluapp.twitter.security.model.UserAccount;
import dev.baluapp.twitter.security.service.UserAccountService;
import dev.baluapp.twitter.security.usecase.RegisterUseAccountUseCase;
import dev.baluapp.twitter.security.web.model.RegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/accounts")
public class UserAccountController {


    private final RegisterUseAccountUseCase registerUseAccountUseCase;

    public UserAccountController(RegisterUseAccountUseCase registerUseAccountUseCase) {
        this.registerUseAccountUseCase = registerUseAccountUseCase;
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterRequest registerRequest) {
        log.info("Register request: {}", registerRequest);

        registerUseAccountUseCase.register(registerRequest);

        //TODO clean old
//        Assert.hasLength(registerRequest.username(), "Username should not be empty oder null");
//        Assert.hasLength(registerRequest.password(), "Password should not be empty oder null");

//        UserRole userRole = this.userRoleService
//                .findUserRole()
//                .orElseThrow(() -> new RuntimeException("User Role not found "));
//
//        UserAccount userAccount = new UserAccount();
//        userAccount.setUsername(registerRequest.username().toLowerCase(Locale.ROOT));
//        userAccount.setPassword(this.passwordEncoder.encode(registerRequest.password()));
//        userAccount.setAuthorities(Set.of(userRole));

        //TODO 2 clean
//        UserAccount userAccount = mapper.map(registerRequest);
//
//        this.userAccountService.createUserAccount(userAccount);

    }
}
