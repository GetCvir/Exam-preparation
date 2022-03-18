package spring.web.site.examprep.entity;

public enum Permissions {
    CREATE("create"),
    READ("read"),
    UPDATE("update"),
    USER_DELETE("user_delete"),
    ADMIN_DELETE("admin_delete");

    private final String permission;

    Permissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
