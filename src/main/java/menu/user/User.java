package menu.user;

import menu.plane.fillList;

import java.util.List;

public class User extends fillList {
    private int id;
    private String login;
    private String password;


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkLogin(List<User> users, String login, String password){
        for (User user : users){
            if (user.getLogin().toString().equals(login) && user.getPassword().toString().equals(password)){
                return true;
            }
        }
        return false;
    }
}