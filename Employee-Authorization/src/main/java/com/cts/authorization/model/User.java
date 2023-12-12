package com.cts.authorization.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
public class User{
	@Id
	private String userName;
	private String password;
	private String role;
	
}
