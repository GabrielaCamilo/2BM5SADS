package projeto.demo.Model;

public enum EnumRole {

    ADMIN("admin"),
    USER("user");

    private String role;

    EnumRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
