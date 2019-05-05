package lab10;

/**
 * This program is for testing the equals methods that you have defined inside
 * the Employee and Instructor classes.
 *
 * @author Richard McKenna
 */
public class PersonTester {

    public static void main(String[] args) {
        // Persons to use
        Person mike = new Person("Michael Palin");
        mike.setAge(75);
        Person terry = new Person("Terry Jones");
        terry.setAge(76);
        Person michael = new Person("Michael Palin");
        michael.setAge(75);

        // LET'S COMPARE THESE Person OBJECTS
        System.out.println("*** LET'S FIRST COMPARE Persons TO Persons ***");
        comparePersonObjects(mike, terry);
        comparePersonObjects(mike, michael);
        comparePersonObjects(terry, michael);

        // Employees to use
        Employee john = new Employee("John Cleese");
        john.setAge(78);
        john.setSalary(65000);
        Employee graham = new Employee("Graham Chapman");
        graham.setAge(48);
        graham.setSalary(75000);
        Employee cleese = new Employee("John Cleese");
        cleese.setAge(78);
        cleese.setSalary(55000);

        // LET'S COMPARE THESE Employee OBJECTS
        System.out.println("\n*** LET'S COMPARE Employees TO Employees ***");
        comparePersonObjects(john, graham);
        comparePersonObjects(john, cleese);
        comparePersonObjects(graham, cleese);

        // Instructors to use
        Instructor eric = new Instructor("Eric Idle");
        eric.setAge(75);
        eric.setSalary(85000);
        eric.setDept("MPFC");
        Instructor terryG = new Instructor("Terry Gilliam");
        terryG.setAge(77);
        terryG.setSalary(85000);
        terryG.setDept("MPFC");
        Instructor idle = new Instructor("Eric Idle");
        idle.setAge(75);
        idle.setSalary(85000);
        idle.setDept("MPFC");

        // LET'S COMPARE THESE Employee OBJECTS
        System.out.println("\n*** LET'S COMPARE Instructor TO Instructor ***");
        comparePersonObjects(eric, terryG);
        comparePersonObjects(eric, idle);
        comparePersonObjects(idle, terryG);

        // NOW LET'S SEE SOME WEIRD THINGS HAPPEN
        Person terryJones = new Person("Terry Jones");
        terryJones.setAge(76);
        Employee jonesTerry = new Employee("Terry Jones");
        jonesTerry.setAge(76);
        jonesTerry.setSalary(99999);
        System.out.println("\nDO YOU KNOW WHY:");
        comparePersonObjects(terryJones, jonesTerry);
        System.out.println("ISN'T THAT A STRANGE RESULT?");
        System.out.println(" - Not if you understand how polymorphism works");

        System.out.println("\nWHAT IF WE WERE TO SWITCH THE ARGUMENTS ORDER?");
        comparePersonObjects(terryJones, jonesTerry);
    }

    public static void comparePersonObjects(Person p1, Person p2) {
        boolean equivalent = p1.equals(p2);
        if (equivalent) {
            System.out.println(p1 + " AND " + p2 + " ARE EQUIVALENT");
        } else {
            System.out.println(p1 + " AND " + p2 + " ARE NOT EQUIVALENT");
        }
    }
}