package uni.fmi.models;
import java.util.*;

/**
 * 
 */
public class User {

    private String name;
    private String password;
    private String email;
    private ClassRoom classRoom;
    private Set<User> children;
    private Set<User> parents;
    private Set<Role> roles;
    private Set<Grade> grades;

    /**
     * Default constructor
     */
    public User() {
    	this(null, null, null, null, null, null, null, null);
    }
    
    public User(final String email) {
    	this(email, null, null, null, null, null, null, null);
	}
    
    public User(final String email, final String password) {
		this(email, password, null, null, null, null, null, null);
	}

	public User(final String email, final String password, final String name) {
		this(email, password, name, null, null, null, null, null);
	}
	
	public User(final String email, final String password, final ClassRoom classRoom, final Set<Role> roles) {
		this(email, null, password, classRoom, roles, null, null, null);
	}
	
	public User(final String email, final String password, final String name,final ClassRoom classRoom, final Set<Role> roles, final Set<User> parents, final Set<User> children, final Set<Grade> grades) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.classRoom = classRoom;
		this.roles = roles;
		this.parents = parents;
		this.children = children;
		this.grades = grades;
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
    public String getPassword() {
        return password;
    }

    /**
     * @param password 
     * @return
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email 
     * @return
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return
     */
    public Set<Role> getRoles() {
    	if(roles == null) {
    		roles = new HashSet<>();
    	}
        return roles;
    }

    /**
     * @param roles 
     * @return
     */
    public void setRoles(Set<Role> roles) {
    	if(roles != null) {
    		this.roles = roles;
    	}else {
    		this.roles.clear();
    	}
    }

    /**
     * @return
     */
    public Set<User> getParents() {
        if(parents == null) {
        	parents = new HashSet<>();
        }
        return parents;
    }

    /**
     * @param parents 
     * @return
     */
    public void setParents(Set<User> parents) {
    	if(parents != null) {
        	this.parents = parents;
        }else {
        	this.parents.clear();
        }
    }

    /**
     * @return
     */
    public Set<User> getChildern() {
    	if(children == null) {
    		children = new HashSet<>();
        }
        return children;
    }

    /**
     * @param children
     */
    public void setChildren(Set<User> children) {
    	if(children != null) {
        	this.children = children;
        }else {
        	this.children.clear();
        }
    }

    /**
     * @return
     */
    public ClassRoom getClassRoom() {
        return classRoom;
    }

    /**
     * @param clas 
     * @return
     */
    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		return true;
	}

	

}