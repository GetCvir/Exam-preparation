package spring.web.site.examprep.entity;

public enum Permissions {
    CREATE("create"),
    READ("read"),
    UPDATE("update"),
    DELETE_CARD("delete_card"),
    DELETE_USER("delete_user");

    private final String permission;

    Permissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
