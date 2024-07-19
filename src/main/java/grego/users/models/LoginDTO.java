package grego.users.models;

import java.io.Serializable;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.validation.constraints.NotEmpty;

public class LoginDTO implements Serializable{
	private static final long serialVersionUID = 1L; 
	
    @NotEmpty(message = "Login não pode ser vazio")
	private String login; 
	
    @NotEmpty(message = "Senha não pode ser vazia")
    private String password;

	public LoginDTO() {
	}

	
	
	public LoginDTO(@NotEmpty(message = "Login não pode ser vazio") String login,
			@NotEmpty(message = "Senha não pode ser vazia") String password) {
		this.login = login;
		this.password = password;
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
	
	
    
}
