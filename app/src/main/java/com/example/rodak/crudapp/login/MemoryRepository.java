package com.example.rodak.crudapp.login;

public class MemoryRepository implements LoginRepository {

    private User user;

    @Override
    public User getUser() {

        if (user == null) {
            User user = new User("admin");
            user.setId(0);
            return user;
        } else {
            return user;
        }

    }

    @Override
    public void saveUser(User user) {

        if (user == null) {
            user = getUser();
        }

        this.user = user;

    }
}
