package user.bean;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserDTO {
	private String name;
	private String id;
	private String pwd;
	
	
/*	
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
*/
	
	@Override
	public String toString() {
		return name + "\t" + id + "\t" + pwd;
	}
	
}
