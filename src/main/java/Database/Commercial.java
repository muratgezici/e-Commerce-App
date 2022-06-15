package Database;

public class Commercial {
    private String id;
    private String cname;
    private String cshortname;
    private String username;
    private String email;
    private String address;
    private String password;

    public Commercial(String id, String cname, String cshortname, String username, String email, String address, String password) {
        this.id = id;
        this.cname = cname;
        this.cshortname = cshortname;
        this.username = username;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCshortname() {
        return cshortname;
    }

    public void setCshortname(String cshortname) {
        this.cshortname = cshortname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
