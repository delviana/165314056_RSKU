package Pojos;
// Generated Nov 18, 2018 2:33:58 PM by Hibernate Tools 4.3.1

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

    private String email;
    private String password;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String toJson() {
//        return "{\"email\":" + getEmail() + ",\"password\":" + getPassword() + "}";
//
//    }
}
