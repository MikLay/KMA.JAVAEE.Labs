package com.fediuchenko;

// I am mega class dao faker
public class LoginFakeDao {

    final static String userName = "MikLay";
    final static String password = "MikLay";

    public static boolean validate(String userName, String password) {
        return LoginFakeDao.userName.equals(userName) && LoginFakeDao.password.equals(password);
    }
}
