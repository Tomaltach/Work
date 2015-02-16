package com.tom.abp.dao;

import java.util.List;

import com.tom.abp.entity.User;

public interface UserDao {
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(int id);
	User findById(int id);
	List<User> findByName(String name);
	List<User> findAll();
}
