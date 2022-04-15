package net.revature.DAO;

import net.revature.model.Users;

public interface UserDAO extends GenericDAO<Users> {

	public Users getByUserName(String userName);

}
