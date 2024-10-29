package Assigment5Task1;

import java.util.List;

public class ConsoleUserView implements UserView {
    @Override
    public void displayUsers(List<User> users) {
        System.out.println("User List:");
        for (User user : users) {
            System.out.println("Name: " + user.getName() + ", Age: " + user.getAge());
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
