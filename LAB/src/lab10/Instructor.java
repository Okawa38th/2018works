package lab10;

/**
 * This simple class represents an instructor. Note that this object inherits
 * all properties from Person and Employee.
 *
 * @author Richard McKenna
 * @author Dachuan He
 */
public class Instructor extends Employee {
    // INSTANCE VARIABLE
    private String dept;

    // CONSTRUCTOR
    public Instructor(String initName) {
        // INIT INSTANCE VARIABLES INHERITED FROM Person AND Employee
        super(initName);
        dept = "None Assigned";
    }

    // ACCESSOR METHOD
    public String getDept() {
        return dept;
    }

    // MUTATOR METHOD
    public void setDept(String newDept) {
        dept = newDept;
    }

    // ADD 3 METHODS
    // - equals

    @Override
    public boolean equals(Object otherperson)
    {
        Instructor otherpersonsalary = (Instructor) otherperson;
        if(otherpersonsalary.dept.equals(this.dept) && super.equals(otherperson))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // - toString
    @Override
    public String toString() {
        return super.toString()+", Dept: " + dept;
    }
    // - compareTo
    @Override
    public int compareTo(Object otherPerson) {
        Instructor other = (Instructor) otherPerson;
        if (!this.dept.equals(other.dept)) {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}