package Assigment5Task2;

public class Main {
    public static void main(String[] args) {
        UserView userView = new ConsoleUserView();
        UserViewModel userViewModel = new UserViewModel(userView);

        userViewModel.addUser("Alice", 30);
        userViewModel.addUser("Bob", 25);
        userViewModel.notifyUser("Users added successfully!");
    }
}
