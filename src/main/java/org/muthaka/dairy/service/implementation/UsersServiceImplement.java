package org.muthaka.dairy.service.implementation;

import org.muthaka.dairy.Models.Users;
import org.muthaka.dairy.dao.usersDao;
import org.muthaka.dairy.service.UsersService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MUTHAKA on 3/6/2015.
 */
public class UsersServiceImplement implements UsersService {
	private usersDao usDAO;

	public void setUsersDao(usersDao usDAO) {
		this.usDAO = usDAO;
	}

	@Override @Transactional public void addUser(Users user) {

		this.usDAO.addUser(user);
	}

	@Override @Transactional public void updateUser(Users user) {

		this.usDAO.updateUser(user);
	}

	@Override @Transactional public List<Users> listUser() {

		return this.usDAO.listUser();
	}

	@Override @Transactional public Users getUserById(Integer userId) {
		return this.usDAO.getUserById(userId);
	}

	@Override @Transactional public Users getUserByUuid(String userUuid) {
		return this.usDAO.getUserByUuid(userUuid);
	}

	@Override @Transactional public void removeUser(Users user) {

		this.usDAO.removeUser(user);
	}

}
