package com.Treeleaf.TreeleafProject.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="post_table")
public class Post {
	
	@Id
	@GeneratedValue
	private int pid;
	private String title;
	private String content;
	private String photo;

}
