package yjcho.ezgraph.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import yjcho.ezgraph.app.user.AppUser;
import yjcho.ezgraph.app.user.AppUserDto;
import yjcho.ezgraph.app.user.AppUserPrincipal;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class AuthService {

    private final JWTProvider jwtProvider;

    public Map<String, Object> createLoginInfo(Authentication auth) {
        AppUserPrincipal principal = (AppUserPrincipal)auth.getPrincipal();
        AppUserDto userDto = AppUserDto.fromAppUser(principal.getAppUser());

        String token = this.jwtProvider.createToken(auth);

        Map<String, Object> loginResultMap = new HashMap<>();
        loginResultMap.put("userInfo", userDto);
        loginResultMap.put("token", token);

        return loginResultMap;
    }
}
