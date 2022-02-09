package uni.fmi.login.service;

import java.util.Collections;
import java.util.List;

import uni.fmi.models.User;

public class LoginService {
	
	private static List<User> usersDb = Collections.singletonList(new User("petrovaT@abv.bg", "passwordPetrovaT"));
	public static String login(final String email, final String password) {
		
		if(null == email || null == password) {
			return "Въведете имейл и парола!";
		}
		
		final boolean userExists = usersDb.stream()
				.anyMatch(u-> u.getEmail().equals(email) && u.getPassword().equals(password));
		
		return userExists ? "Успешно влизане!" : "Грешни данни!";
	}

}
