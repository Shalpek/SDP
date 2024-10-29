package Assigment5Task2;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel {
    private List<User> users;
    private UserView userView;

    public UserViewModel(UserView userView) {
        this.users = new ArrayList<>();
        this.userView = userView;
    }

    public void addUser(String name, int age) {
        User user = new User(name, age);
        users.add(user);
        notifyView();
    }

    private void notifyView() {
        userView.displayUsers(users); // Уведомление представления о обновлении
    }

    public void notifyUser(String message) {
        userView.showMessage(message);
    }
}
