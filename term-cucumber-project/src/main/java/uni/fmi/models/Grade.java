package uni.fmi.models;

/**
 * 
 */
public class Grade {

    private Integer value;
    private Subject subject;
    private User student;
    
    /**
     * Default constructor
     */
    public Grade() {
    }

    public Grade(final Integer value, final User student, final Subject subject) {
		this.value = value;
		this.subject = subject;
		this.student = student;
	}

	/**
     * @return
     */
    public Integer getValue() {
        return value;
    }

    /**
     * @param value 
     * @return
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * @return
     */
    public User getStudent() {
        return student;
    }

    /**
     * @param student 
     * @return
     */
    public void setStudent(User student) {
        this.student = student;

    }

    /**
     * @return
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * @param subject 
     * @return
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

}