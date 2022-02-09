package uni.fmi.headTeacher.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import uni.fmi.models.ClassRoom;
import uni.fmi.models.Role;
import uni.fmi.models.User;

public class HeadTeacherService {

	private static final List<ClassRoom> ClassesDB = new ArrayList<>();
	private static final List<User> UsersDB = new ArrayList<>();
	
	public static String addTeacher(final String classRoom, final String teacher) {
		initDb();
		
		final boolean isTeacher = UsersDB.stream().anyMatch(u -> u.getEmail().equals(teacher) && u.getRoles().stream().anyMatch(r -> r.equals(new Role("tea"))));
		if(!isTeacher) {
			return "Невалиден класен ръководител!";
		}
		
		final boolean isClassRoomFree = ClassesDB.stream().anyMatch(u -> u.getCode().equals(classRoom) && u.getTeacher() != null);
		if(isClassRoomFree) {
			return "Зает клас!";
		}
		
		final boolean isTeacherFree = UsersDB.stream().anyMatch(u -> u.getEmail().equals(teacher) && u.getClassRoom() != null);
		if(isTeacherFree) {
			return "Зает класен ръководител!";
		}
		
		ClassesDB.get(ClassesDB.indexOf(new ClassRoom(classRoom))).setTeacher(new User(teacher));
		UsersDB.get(UsersDB.indexOf(new User(teacher))).setClassRoom(new ClassRoom(classRoom));
		return "Успешно добавяне!";
	}
	
	private static void initDb(){
		ClassesDB.clear();
		
		final ClassRoom takenClass = new ClassRoom("taken");
		takenClass.setTeacher(new User("head@abv.bg"));
		ClassesDB.add(takenClass);
		ClassesDB.add(new ClassRoom("free"));	
		
		final Set<Role> roles = new HashSet<>();
		roles.add(new Role("tea"));
		
		final User takenUser = new User("taken@abv.bg");
		takenUser.setClassRoom(new ClassRoom("5b"));
		takenUser.setRoles(roles);
		UsersDB.add(takenUser);
		
		final User freeUser = new User("free@abv.bg");
		freeUser.setRoles(roles);
		UsersDB.add(freeUser);
		
		final User wrongUser = new User("wrong@abv.bg");
		UsersDB.add(wrongUser);
	}

}
