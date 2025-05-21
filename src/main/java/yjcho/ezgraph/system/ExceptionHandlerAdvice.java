package yjcho.ezgraph.system;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.web.bind.annotation.ResponseStatus;
import yjcho.ezgraph.app.content.ContentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ContentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result handleGraphNotFoundException(ContentNotFoundException e) {
        return new Result(false, HttpStatus.NOT_FOUND.value(), e.getMessage(), null);
    }

    @ExceptionHandler({UsernameNotFoundException.class, BadCredentialsException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result handleAuthenticationException(Exception e) {
        return new Result(false, HttpStatus.UNAUTHORIZED.value(), "Authentication Failed", null);
    }

    @ExceptionHandler(AccountStatusException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result handleAccountStatusException(AccountStatusException e) {
        return new Result(false, HttpStatus.UNAUTHORIZED.value(), "Abnormal User Account", null);
    }

    @ExceptionHandler(InvalidBearerTokenException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result handleInvalidBearerTokenException(InvalidBearerTokenException e) {
        return new Result(false, HttpStatus.UNAUTHORIZED.value(), "Invalid Access Token", null);
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result handleInsufficientAuthenticationException(AuthenticationException e) {
        return new Result(false, HttpStatus.UNAUTHORIZED.value(), "Authentication Required - " + e.getMessage(), null);
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Result handleAccessDeniedException(AccessDeniedException e) {
        return new Result(false, HttpStatus.FORBIDDEN.value(), "No Permission", null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleAccessDeniedException(Exception e) {
        return new Result(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", e.getClass().getName() + " - " + e.getMessage());
    }
}
