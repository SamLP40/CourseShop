package fr.fms.entities;

public class Users {

	public int idUser;
	public String login;
	public String password;
	
	public Users(int idUser, String login, String password) {
		this.idUser = idUser;
		this.login = login;
		this.password = password;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [idUser=" + idUser + ", login=" + login + ", password=" + password + "]";
	}
	
	
}
