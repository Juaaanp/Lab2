package lab2.Models;

import java.io.Serializable;

public class LocalUser implements Serializable{
    private String id;
    private String name;
    private String email;
    private String role;
    
    public String className;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getClassName() {
        return className;
    }

    public LocalUser(String id, String name, String email, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

}
