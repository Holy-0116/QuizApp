package model;

import dao.UserDAO;

public class LoginLogic {

	public User execute(Login login) {
		UserDAO dao = new UserDAO();
		User user = dao.findByLogin(login);
		return user;
	}

}
