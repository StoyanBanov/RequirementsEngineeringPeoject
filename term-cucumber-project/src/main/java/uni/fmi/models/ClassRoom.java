package uni.fmi.models;
import java.util.*;

/**
 * 
 */
public class ClassRoom {

    private String code;
    private User teacher;
    private Set<User> students;
    private Set<Subject> subjects;
    
    /**
     * Default constructor
     */
    public ClassRoom() {
    }
    
    public ClassRoom(final String code) {
    	this.code = code;
    }
    
    /**
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code 
     * @return
     */
    public void setCode(String code) {
    	this.code = code;
    }

    /**
     * @return
     */
    public Set<User> getStudents() {
        if(students == null) {
        	students = new HashSet<>();
        }
        return students;
    }

    /**
     * @param students 
     * @return
     */
    public void setStudents(Set<User> students) {
    	if(students != null) {
    		this.students = students;
    	}else {
    		this.students.clear();
    	}
    }

    /**
     * @return
     */
    public User getTeacher() {
        return teacher;
    }

    /**
     * @param teacher 
     * @return
     */
    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    /**
     * @return
     */
    public Set<Subject> getSubjects() {
    	if(subjects == null) {
    		subjects = new HashSet<>();
        }
        return subjects;
    }

    /**
     * @param subjects 
     * @return
     */
    public void setSubjects(Set<Subject> subjects) {
        if(subjects != null) {
        	this.subjects = subjects;
        }else {
        	this.subjects.clear();
        }
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ClassRoom other = (ClassRoom) obj;
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		return true;
	}

    
}