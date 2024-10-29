package Assigment5Task1;

public class Main {
    public static void main(String[] args) {
        UserView userView = new ConsoleUserView();
        UserPresenter userPresenter = new UserPresenter(userView);

        userPresenter.addUser("Alice", 30);
        userPresenter.addUser("Bob", 25);
        userPresenter.notifyUser("Users added successfully!");
    }
}
