package com.iist.vse900.service;

public interface UserService {
    public boolean changePassword(String username, String oldPassword, String newPassword);
    public boolean resetPassword(String username);
}
