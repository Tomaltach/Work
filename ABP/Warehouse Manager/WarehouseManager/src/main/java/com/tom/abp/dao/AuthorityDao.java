package com.tom.abp.dao;

import java.util.List;

import com.tom.abp.entity.Authority;

public interface AuthorityDao {
	void addAuthority(Authority authority);
	void deleteAuthority(Authority authority);
	void updateAuthority(Authority authority);
	Authority findByName(String name);
	List<Authority> findByAuthority(String authority);
	List<Authority> findAll();
}
