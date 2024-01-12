package model;

public class Account {
    private int id;
    private String user;
    private String pass;
    private int isSell;
    private int isAdmin;
    private String publicKey;
    private String privateKey;
    private int customerId;
    private boolean status;

    public Account(int id, String user, String pass, int isSell, int isAdmin, String publicKey, String privateKey, int customerId, boolean status) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.customerId = customerId;
        this.status = status;
    }

    public Account(int id, String user, String pass, int isSell, int isAdmin) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIsSell() {
        return isSell;
    }

    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", user='" + user + '\'' + ", pass='" + pass + '\'' + ", isSell=" + isSell + ", isAdmin=" + isAdmin + '}';
    }
}


