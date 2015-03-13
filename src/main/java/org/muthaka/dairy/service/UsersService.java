package org.muthaka.dairy.service;

import org.muthaka.dairy.Models.Users;

import java.util.List;

/**
 * Created by MUTHAKA on 3/6/2015.
 */
public interface UsersService {

    public void addUser(Users user);

    public void updateUser(Users user);

    public List<Users> listUser();

    public Users getUserById(Integer userId);
    public Users getUserByUuid(String userUuid);

    public void removeUser(Users user);
}
