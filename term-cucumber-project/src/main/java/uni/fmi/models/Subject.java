package uni.fmi.models;
import java.util.*;

/**
 * 
 */
public class Subject {

    private String name;
    private Set<Grade> grades;
    private Set<ClassRoom> classes;
    
    /**
     * Default constructor
     */
    public Subject() {
    	this(null, null);
    }
    
    public Subject(final String name) {
		this(name, null);
	}

    public Subject(final String name, Set<ClassRoom> classes) {
		this.name = name;
		this.classes = classes;
	}

	/**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 
     * @return
     */
    public void setName(String name) {
       this.name = name;
    }

    /**
     * @return
     */
    public Set<Grade> getGrades() {
    	if(grades == null) {
    		grades = new HashSet<>();
    	}
        return grades;
    }

    /**
     * @param grades 
     * @return
     */
    public void setGrades(Set<Grade> grades) {
    	if(grades != null) {
    		this.grades = grades;
    	}else {
    		this.grades.clear();
    	}
    }

    /**
     * @return
     */
    public Set<ClassRoom> getClasses() {
    	if(classes == null) {
    		classes = new HashSet<>();
    	}
        return classes;
    }

    /**
     * @param classes 
     * @return
     */
    public void setClasses(Set<ClassRoom> classes) {
    	if(classes != null) {
    		this.classes = classes;
    	}else {
    		this.classes.clear();
    	}
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Subject other = (Subject) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}