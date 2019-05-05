package lab10;

/**
 * This simple class represents a Person.
 *
 * @author Richard McKenna
 * @author _______________
 */
public class Person implements Comparable {
    // INSTANCE VARIABLES
    protected String name;
    protected int age;

    // CONSTRUCTOR
    public Person(String initName) {
        age = 0;
        name = initName;
    }

    // ACCESSOR METHODS
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // MUTATOR METHOD
    public void setAge(int newAge) {
        if (newAge < 0) {
            age = 0;
        } else {
            age = newAge;
        }
    }

    /**
     * This method returns a textual representation of the object.
     */
    @Override
    public String toString() {
        return name + ", age " + age;
    }

    /**
     * This method must determine if the otherPerson argument is equivalent to
     * this Person object. They are equivalent if they have equivalent instance
     * variables. If they are equivalent, true is returned, else false.
     */
    @Override
    public boolean equals(Object otherPerson) {
        Person otherPersonAsPerson = (Person) otherPerson;
        if ((otherPersonAsPerson.age == this.age)
                && (otherPersonAsPerson.name.equals(this.name))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Object otherPerson) {
        Person other = (Person)otherPerson;
        if (this.age < other.age) {
            return -1;
        }
        else if (this.age == other.age) {
            return 0;
        }
        else
            return 1;
    }
}