package model;

import dao.UserDAO;

public class LogonLogic {
	public boolean execute(User user) {
		UserDAO dao = new UserDAO();
		boolean result = dao.createUser(user);
		return result;
	}

}
