package lab8;

/**
 * This program plays around with Ballplayer objects,
 * constructing a few, changing them, and then printing
 * info about them.
 *
 * @author Richard McKenna *
 */
public class SalaryCapCalculator {

    public static void main(String[] args) {
        Ballplayer player1 = new Ballplayer("Giancarlo", "Stanton", 25000000L);
        printInfo(player1);

        Ballplayer player2 = new Ballplayer("Aaron", "Judge", 622300L);
        printInfo(player2);

        Ballplayer player3 = new Ballplayer("Didi", "Gregorius", 2425000L);
        printInfo(player3);

        System.out.println("Now let's change some names and salaries");
        player3.setFirstName("Aroldis");
        player3.setLastName("Chapman");
        player3.setSalary(113200000);
        printInfo(player3);
    }

    /**
     * A helper method for displaying information about an individual Ballplayer
     */
    public static void printInfo(Ballplayer bp) {
        System.out.println(bp.toString());
        System.out.println("-First Name: " + bp.getFirstName());
        System.out.println("-Last Name: " + bp.getLastName());
        System.out.println("-Salary: " + bp.getSalary());
        System.out.println();
    }
}
