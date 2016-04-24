package com.stack.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stack.rs.UserDao;
import com.stack.rs.Users;

@Path("/Users")
public class UserService {
	UserDao dao = new UserDao();

	public void setUsersDao(UserDao dao) {
		this.dao = dao;
	}

	@GET
	@Path("/{param}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Users getUsers(@PathParam("param") String name) {
		return dao.getUser(name);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Users> getUserss() {
		return dao.getUsers();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	// public void createUsers(@FormParam("name") String name,@FormParam("age")
	// Integer age,@FormParam("emailId") String emailId){
	public void createUsers(Users u) {
		System.out.println("Creating Users: " + u.getUserName() + " Age: "
				+ u.getPassword());
		dao.createUser(u);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	// @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	// public void updateUsers(@FormParam("id") Integer id, @FormParam("name")
	// String name,@FormParam("age") Integer age,@FormParam("emailId") String
	// emailId){
	public void updateUsers(Users u) {
		System.out.println("Updating Users: " + u.getUserName());
		dao.updateUser(u);

	}

	@DELETE
	@Path("/{param}")
	@Produces({ MediaType.APPLICATION_JSON })
	public boolean deleteUsers(@PathParam("param") String UserName) {
		System.out.println("Deleting Users: " + UserName);
		dao.deleteUser(UserName);
		return true;
	}

}
