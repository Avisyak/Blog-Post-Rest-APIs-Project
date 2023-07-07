package com.Treeleaf.TreeleafProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Treeleaf.TreeleafProject.Model.User;

public interface UserRepositoy extends JpaRepository<User, Integer> {
	User findByUsernameAndPassword(String un,String psw);
}
