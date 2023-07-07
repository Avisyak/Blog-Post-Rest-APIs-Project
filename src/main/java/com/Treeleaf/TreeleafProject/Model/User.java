package com.Treeleaf.TreeleafProject.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user_table")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	private String fname;
	private String lname;
	private String username;
	private String password;

}
