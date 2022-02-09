package uni.fmi.grade.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import uni.fmi.models.Grade;
import uni.fmi.models.Role;
import uni.fmi.models.User;
import uni.fmi.models.Subject;
import uni.fmi.models.ClassRoom;

public class GradingService {

	private static final List<User> userDB = new ArrayList<>();
	private static final List<Subject> subjectDB = new ArrayList<>();
	private static final List<Grade> gradeDB = new ArrayList<>();
	
	public static String grade(final Double value, final String email, final String subject) {
		initDb();
		
		if(Math.floor(value) !=  value || value < 2 || value > 6) {
			return "Оценката трябва да е цяло число от 2 до 6!";
		}
		
		final boolean studentExists = userDB.stream().anyMatch(u -> u.getEmail().equals(email) && u.getRoles().stream().anyMatch(r -> r.equals(new Role("stu"))));
		if(!studentExists) {
			return "Невалиден имейл!";
		}
		
		
		final ClassRoom newClassRoom = userDB.get(userDB.indexOf(new User(email))).getClassRoom();
		final boolean subjectExists = subjectDB.stream().anyMatch(u -> u.getName().equals(subject) && u.getClasses().stream().anyMatch(s -> s.equals(newClassRoom)));
		if(!subjectExists) {
			return "Невалиден предмет!";
		}
		
		final Grade newGrade = new Grade((int)Math.floor(value), userDB.get(userDB.indexOf(new User(email))), subjectDB.get(subjectDB.indexOf(new Subject(subject))));
		gradeDB.add(newGrade);
		return "Успешно добавяне!";
	}
	
	private static void initDb(){
		userDB.clear();
		subjectDB.clear();
		
		final ClassRoom newClassRoom = new ClassRoom("5b");
		final Set<ClassRoom> newClasses = new HashSet<>();
		newClasses.add(newClassRoom);
		final Set<Role> newRoles = new HashSet<>();
		newRoles.add(new Role("stu"));
		
		userDB.add(new User("stu15@abv.bg", "pass123", newClassRoom, newRoles));
		subjectDB.add(new Subject("History", newClasses));
	}

}
