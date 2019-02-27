package lab8;

import java.text.NumberFormat;

/**
 * You'll define much of this class
 *
 * @author Dachuan He
 */
public class Ballplayer {
    public static final long MAX_SALARY = 20000000L;
    private String firstName;
    private String lastName;
    private long salary;

    public Ballplayer(String initFirst,
                      String initLast,
                      long initSalary) {
        firstName = initFirst;
        lastName = initLast;
        salary = initSalary;

        // ADD MORE INITIALIZATION HERE
    }

    // THIS ACCESSOR METHOD WORKS
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        // CORRECT THIS ACCESSOR METHOD
        return lastName;
    }

    public long getSalary() {
        // CORRECT THIS ACCESSOR METHOD
        return salary;
    }

    // THIS MUTATOR METHOD WORKS
    public void setFirstName(String initFirstName) {
        firstName = initFirstName;
    }

    public void setLastName(String initLastName) {
        lastName = initLastName;
        // YOU MUST DEFINE THIS MUTATOR METHOD
    }

    public void setSalary(long initSalary) {
        salary = initSalary;
        // YOU MUST DEFINE THIS MUTATOR METHOD
    }

    public String convertToFormattedMoney(long money) {
        java.text.NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(money);
    }

    public String toString() {
        // YOU MUST DEFINE THIS METHOD
        return super.toString();
    }
}
