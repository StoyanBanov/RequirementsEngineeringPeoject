package uni.fmi.register.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import uni.fmi.models.Role;
import uni.fmi.models.User;

public class RegisterService {
	
	private static final List<User> UserDB = new ArrayList<>();
	private static final List<Role> RolesDB = new ArrayList<>();
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		
	public static String register(final String email, final String password,  final String secondPassword, final String name, final String role) {
		
		initDb();
		if(null == email || email.trim().equals("")) {
			return "Въведете имейл!";
		}
		
		if(!validate(email)) {
			return "Невалиден имейл!";
		}
		
		if(password == null || 7 != password.length()) {
			return "Паролата трябва да е десет символа!";
		}
		
		if(!password.equals(secondPassword)) {
			return "Въведете еднакви пароли!";
		}
			
		if(null == name || name.trim().equals("")) {
			return "Въведете име!";
		}
		
		if(null == role || role.trim().equals("")) {
			return "Въведете роли!";
		}else if(role.contains(",")) {
			for(String r : role.split(", ")) {
				if(!RolesDB.stream().anyMatch(u -> u.getCode().equals(r))) {
					return "Невалидни роли!";
				}
			}
		}else {
			if(!RolesDB.stream().anyMatch(u -> u.getCode().equals(role))) {
				return "Невалидни роли!";
			}
		}
		
		final User newUser = new User(email, password, name);
		if(UserDB.stream().anyMatch(u -> u.equals(newUser))) {
			return "Зает имейл!";
		}
		
		UserDB.add(newUser);
		return "Регистриран успешно!";
	}
	
	private static void initDb(){
		UserDB.clear();
		RolesDB.clear();
		UserDB.add(new User("te@abv.bg", "Pass123", "Jana"));
		RolesDB.add(new Role("par"));
		RolesDB.add(new Role("tea"));
		RolesDB.add(new Role("stu"));
	}
	
	private static boolean validate(String emailStr) {
	        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
	        return matcher.find();
	}

}
