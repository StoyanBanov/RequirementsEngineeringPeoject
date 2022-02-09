package uni.fmi.gradeCheck.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import uni.fmi.models.Role;
import uni.fmi.models.User;

public class GradeCheckService {

	private static final List<User> usersDB = new ArrayList<>();
	private static final User loggedUser = new User("loged@abv.bg");
	
	public static String checkGrades(final String email, final String message, final String role) {
		initDb(role);
		
		final boolean correctRole = loggedUser.getRoles().stream().anyMatch(u -> u.getCode().equals("par"));
		if(!correctRole) {
			return "Невалидни роли!";
		}
		
		final boolean isStudent = usersDB.stream().anyMatch(u -> u.getEmail().equals(email) && u.getRoles().stream().anyMatch(r -> r.equals(new Role("stu"))));
		if(!isStudent){
			return "Невалиден имейл!";
		}
		
		final boolean isChild = loggedUser.getChildern().stream().anyMatch(u -> u.getEmail().equals(email));
		if(!isChild) {
			return "Достъп отказан!";
		}
		
		return "Достъп разрешен!";
	}
	
	private static void initDb(final String role){
		usersDB.clear();
		
		final User newUser = new User("child@abv.bg");
		final Set<Role> stuRoles = new HashSet<>();
		stuRoles.add(new Role("stu"));
		newUser.setRoles(stuRoles);
		usersDB.add(newUser);
		
		final User newUser2 = new User("child2@abv.bg");
		newUser2.setRoles(stuRoles);
		usersDB.add(newUser2);
		
		final Set<User> children = new HashSet<>();
		children.add(newUser);
		loggedUser.setChildren(children);
		
		final Set<Role> newRoles = new HashSet<>();
		newRoles.add(new Role(role));
		loggedUser.setRoles(newRoles);
	}

}
