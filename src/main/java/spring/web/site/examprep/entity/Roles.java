package spring.web.site.examprep.entity;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Roles {
    USER (Set.of(Permissions.CREATE,
            Permissions.READ,
            Permissions.UPDATE,
            Permissions.USER_DELETE)),
    ADMIN (Set.of(Permissions.CREATE,
            Permissions.READ,
            Permissions.UPDATE,
            Permissions.ADMIN_DELETE));

        private final Set<Permissions> permissions;

    Roles(Set<Permissions> permissions) {
        this.permissions = permissions;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthoritySet(){
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
