package myboard.domain;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 6. 12
 * Time: 오후 5:39
 * To change this template use File | Settings | File Templates.
 */
public class LoginRequest {

    private String id;
    private String pw;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
