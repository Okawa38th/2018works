package lab10;

/**
 * This program is for testing the compareTo methods that you have defined
 * inside the Employee and Instructor classes.
 *
 * @author Richard McKenna
 */
public class PersonComparer {

    public static void main(String[] args) {
        // Persons to use
        Person mike = new Person("Michael Palin");
        mike.setAge(75);
        Person terry = new Person("Terry Jones");
        terry.setAge(76);

        // Employees to use
        Employee john = new Employee("John Cleese");
        john.setAge(78);
        john.setSalary(65000);
        Employee graham = new Employee("Graham Chapman");
        graham.setAge(48);
        graham.setSalary(75000);

        // Instructors to use
        Instructor eric = new Instructor("Eric Idle");
        eric.setAge(75);
        eric.setSalary(85000);
        eric.setDept(new String("MPFC"));
        Instructor terryG = new Instructor("Terry Gilliam");
        terryG.setAge(77);
        terryG.setSalary(85000);
        terryG.setDept(new String("MPFC"));

        // LET'S COMPARE THE Person OBJECTS FIRST
        System.out.println("Compare Person to Person");
        comparePersonObjects(mike, terry);
        comparePersonObjects(terry, mike);

        // NOW WE'LL COMPARE THE Employee OBJECTS
        System.out.println("\nCompare Employee to Employee");
        comparePersonObjects(john, graham);
        comparePersonObjects(graham, john);

        // NOW WE'LL COMPARE THE Instructor OBJECTS
        System.out.println("\nCompare Instructor to Instructor");
        comparePersonObjects(eric, terryG);
        comparePersonObjects(terryG, eric);

        // NOW WE'll COMPARE VARIOUS TYPES
        System.out.println("\nCompare Person to Employee using Person Criteria");
        comparePersonObjects(mike, john);
        comparePersonObjects(mike, graham);
        comparePersonObjects(terry, john);
        comparePersonObjects(terry, graham);

        System.out.println("\nCompare Person to Instructor using Person Criteria");
        comparePersonObjects(mike, eric);
        comparePersonObjects(mike, terryG);
        comparePersonObjects(terry, eric);
        comparePersonObjects(terry, terryG);

        System.out.println("\nCompare Employee to Instructor using Employee Criteria");
        comparePersonObjects(john, eric);
        comparePersonObjects(john, terryG);
        comparePersonObjects(graham, eric);
        comparePersonObjects(graham, terryG);

        System.out.println("\nNow Let's do a comparison that will crash the program");
        System.out.println("\t-Do you know why this causes a Runtime Error?");
        System.out.println("\t-Change this call to a different comparison using different"
                + " types that also causes a Runtime Error");
        comparePersonObjects(eric, terryG);
    }

    /*
     * This method compares the two Comparable arguments and prints
     * the results.
     */
    public static void comparePersonObjects(Comparable c1, Comparable c2) {
        System.out.print("\t");
        int results = c1.compareTo(c2);
        if (results == 0) {
            System.out.println(c1 + " == " + c2);
        } else if (results < 0) {
            System.out.println(c1 + " < " + c2);
        } else {
            System.out.println(c1 + " > " + c2);
        }
    }
}