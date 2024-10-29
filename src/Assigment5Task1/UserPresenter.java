package Assigment5Task1;

import java.util.ArrayList;
import java.util.List;

public class UserPresenter {
    private List<User> users;
    private UserView userView;

    public UserPresenter(UserView userView) {
        this.users = new ArrayList<>();
        this.userView = userView;
    }

    public void addUser(String name, int age) {
        User user = new User(name, age);
        users.add(user);
        userView.displayUsers(users); // Уведомление представления через интерфейс
    }

    public void notifyUser(String message) {
        userView.showMessage(message);
    }
}
