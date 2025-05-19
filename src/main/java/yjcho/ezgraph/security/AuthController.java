package yjcho.ezgraph.security;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import yjcho.ezgraph.app.user.AppUser;
import yjcho.ezgraph.app.user.AppUserDto;
import yjcho.ezgraph.system.Result;

import java.util.Map;

@RestController
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("users/login")
    public Result getLoginInfo(Authentication auth, HttpServletRequest request) {
        return new Result(true, HttpStatus.OK.value(), "jwt", authService.createLoginInfo(auth));
    }
}
