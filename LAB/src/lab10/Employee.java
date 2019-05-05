package lab10;

/**
 * This simple class represents an employee. Note that this
 * object inherits all properties from Person.
 *
 * @author Richard McKenna
 * @author _______________
 */
public class Employee extends Person {
    // INSTANCE VARIABLE
    private int salary;

    // CONSTRUCTOR
    public Employee(String initName) {
        // INIT INSTANCE VARIABLES INHERITED FROM Person
        super(initName);
        salary = 0;
    }

    // ACCESSOR METHOD
    public int getSalary() {
        return salary;
    }

    // MUTATOR METHOD
    public void setSalary(int newSalary) {
        if (newSalary < 0 || newSalary > 400000) {
            salary = 0;
        } else {
            salary = newSalary;
        }
    }

    // ADD 3 METHODS

    @Override
    public boolean equals(Object otherperson)
    {
        Employee otherpersonsalary = (Employee)otherperson;
        if(otherpersonsalary.salary == this.salary && super.equals(otherperson))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    // - equals

    @Override
    public String toString() {
        return super.toString()+", Salary: $" + salary;
    }

    // - toString
    @Override
    public int compareTo(Object otherPerson) {
        Employee other = (Employee) otherPerson;
        if (this.salary < other.salary) {
            return -1;
        }
        else if (this.salary == other.salary) {
            return 0;
        }
        else
            return 1;
    }
    // - compareTo
}