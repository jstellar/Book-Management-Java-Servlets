package com.user;

import java.util.Set;

public interface UI {
	
	User getUser();
	Set<User> getAllUsers();
	User getUserByUserNameAndPassword();
	boolean insertUser();
	boolean updateUser();
	boolean deleteUser();

}
