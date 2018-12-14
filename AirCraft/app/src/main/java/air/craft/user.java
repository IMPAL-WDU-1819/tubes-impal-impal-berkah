package air.craft;

public class user {
    private static user instance;
    String email;

    public user() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static synchronized user getInstance(){
        if (instance==null){
            instance=new user();
        }
        return instance;
    }
}
