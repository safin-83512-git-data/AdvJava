package com.sunbeam.dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.sunbeam.entities.Role;
import com.sunbeam.entities.User;

public interface UserDao {
	String signUp(User user);

	User getUserDetailsById(Long userId);

	// get all users
	List<User> getAllUsers();

	// get users by dob n role
	List<User> getUsersByDobAndRole(LocalDate begin, LocalDate end, Role userRole);

	// get users lastnames by role
	List<String> getLastNamesByRole(Role userRole);

	// get first name , last name , dob by role
	List<User> testJPACtorExpression(Role userRole);

	// change password
	String changePassword(String email, String oldPwd, String newPwd);

	// apply discount to selected users by dob
	String applyDiscount(LocalDate date, double discount);

	// delete user details - hard delete
	String deleteUserDetails(Long userId);

	// store image in DB
	String storeImageInDB(String fileName, Long userId) throws IOException;

	// restore image from DB in new file
	String restoreImageFromDB(String newFileName, Long userId) throws IOException;
	List<User> getUserNamesByCity(String city);
	User signIn(String email, String password);
}
