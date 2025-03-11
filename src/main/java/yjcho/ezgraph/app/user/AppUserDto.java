package yjcho.ezgraph.app.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@Builder
public class AppUserDto implements Serializable {

    private Long id;
    private String username;

    public AppUser toAppUser() {
        return AppUser.builder()
                .id(this.id)
                .username(this.username).build();
    }

    public static AppUserDto fromAppUser(AppUser user) {
        return AppUserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }

}
