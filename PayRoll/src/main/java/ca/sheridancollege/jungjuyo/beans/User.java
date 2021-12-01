package ca.sheridancollege.jungjuyo.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = -265204101199024553L;
	
	private long userId;
	private String userName;
	private String encryptedPassword;
	

}