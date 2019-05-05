import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DesginYourTrip {
    static Scanner keyboard;
    static boolean keepgoing;
    static String userinput;
    static ArrayList<Cities> cities = new ArrayList<>();
    static ArrayList<Cities> stops = new ArrayList<>();
    static ArrayList<Cities> PUsers = new ArrayList<>();
    static ArrayList<String> Trips = new ArrayList<>();
    static ArrayList<Cities> tripplan = new ArrayList<>();
    static boolean stopmenukeepgoing;
    static boolean tripMenukeepgoing;
    static boolean keepProcessEdit;
    static int multiple;
    static String tempfilename;
    static double distance;


    public static void main(String[] args) {
        userinput = "";
        keepgoing = true;
        keyboard = new Scanner(System.in);
        loadArrayFromFile("PossiblePlaceToGo.text", cities);
        distance = 0;
        loadTripsFromFile("AllTrips.text");

        while (keepgoing) {
            runMainMenu();
            processMainMenu();
        }


    }

    public static void runMainMenu() {
        System.out.println("***** Welcome to Dachuan's Trip Design Program *****");
        System.out.println("1. Check your current Possible stops");
        System.out.println("2. Design Your Trip!");
        System.out.println("q. Quit.");
        userinput = keyboard.nextLine();
    }

    public static void processMainMenu() {
        if (userinput.equals("1")) {
            stopmenukeepgoing = true;
            runStopsMenu();
        } else if (userinput.toLowerCase().equals("q")) {
            keepgoing = false;
            System.out.println("Bye~");
        } else if (userinput.equals("2")) {
            if (stops.size() != 0) {
                runTripMenu();
            } else {
                System.out.println("***Add some stops to your plan first");
            }
        }
    }

    public static void runStopsMenu() {
        while (stopmenukeepgoing) {
            Collections.sort(stops, new Cities.CitySortByName());
            System.out.println("***Your current stops:" + stops);
            System.out.println("***Would you like to add a new stop or remove a stop?");
            System.out.println("1. Remove a stop.");
            System.out.println("2. Add a new stop.");
            System.out.println("3. Check my suggestions for you.");
            System.out.println("4. See current stops' full details");
            System.out.println("5. Check the Previously user's stops.");
            System.out.println("6. Save your current stops to file.");
            System.out.println("q. Return to last menu ");
            userinput = keyboard.nextLine();
            procesStopsMenu();
        }
    }

    public static void procesStopsMenu() {
        loadArrayFromFile("User stops.text", PUsers);
        if (userinput.equals("1")) {
            if (stops.size() < 1) {
                System.out.println("***You don't have any stops!");
            } else {
                System.out.println("***Which one you wanna remove?");
                userinput = keyboard.nextLine();
                for (int a = 0; a < stops.size(); a++) {
                    if (stops.get(a).getName().toLowerCase().equals(userinput.toLowerCase())) {
                        stops.remove(stops.get(a));
                        System.out.println("***Remove stops Successful.");
                        break;
                    } else if (a == stops.size() - 1 & !stops.get(a).getName().toLowerCase().equals(userinput.toLowerCase())) {
                        System.out.println("***City does not exist.");
                    }
                }
            }
        } else if (userinput.equals("2")) {
            System.out.println("***Type City's name");
            userinput = keyboard.nextLine();
            if (stops.size() != 0) {
                int c = 0;
                while (c < stops.size()) {
                    if (stops.get(c).getName().toLowerCase().equals(userinput.toLowerCase())) {
                        System.out.println("***You already have this stop!");
                        c = stops.size();
                    } else if (c == stops.size() - 1) {
                        AddNewCity();
                        break;
                    } else {
                        c++;
                    }
                }
            } else {
                AddNewCity();
            }
        } else if (userinput.equals("3")) {
            System.out.print("(");
            for (int i = 0; i < cities.size(); i++) {
                System.out.print(cities.get(i) + ", ");
            }
            System.out.print(")" + '\n');
        } else if (userinput.equals("4")) {
            for (int a = 0; a < stops.size(); a++) {
                System.out.println("***[ " + stops.get(a).wholedetail() + " ]");
            }
        } else if (userinput.toLowerCase().equals("q")) {
            stopmenukeepgoing = false;
        } else if (userinput.equals("5")) {
            System.out.println("***Previously User saved: " + PUsers);
        } else if (userinput.equals("6")) {
            writeArraytoFile("User stops.text",stops);
        } else {
            System.out.println("***WRONG CHOICE***");
        }
    }

    public static void AddNewCity() {
        for (int a = 0; a < cities.size(); a++) {
            if (cities.get(a).getName().toLowerCase().equals(userinput.toLowerCase())) {
                stops.add(cities.get(a));
                System.out.println("***Stop Add Successful.");
                break;
            } else if (a == cities.size() - 1 & !cities.get(a).getName().toLowerCase().equals(userinput.toLowerCase())) {
                if(PUsers.size()>0){
                    for(int b = 0; b <PUsers.size();b++){
                        if (PUsers.get(b).getName().toLowerCase().equals(userinput.toLowerCase())) {
                            stops.add(PUsers.get(b));
                            System.out.println("***Stop Add Successful.");
                            break;
                        }else if(b==PUsers.size()-1 & !PUsers.get(b).getName().toLowerCase().equals(userinput.toLowerCase())){
                            newCity();
                        }
                    }
                }else{
                    newCity();
                }
            }
        }
    }

    public static void loadArrayFromFile(String fileName, ArrayList<Cities> o) {
        try {
            File f = new File(fileName);
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            while (fis.available() > 0) {
                String name = dis.readUTF();
                int latDe = dis.readInt();
                int latM = dis.readInt();
                String latDi = dis.readUTF();
                int longde = dis.readInt();
                int longm = dis.readInt();
                String longDi = dis.readUTF();
                o.add(new Cities(name, latDe, latM, latDi, longde, longm, longDi));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public static void writeArraytoFile(String filename,ArrayList<Cities> o) {
        DataOutputStream dos;
        try {
            File f = new File(filename);
            FileOutputStream fos = new FileOutputStream(f,false);
            dos = new DataOutputStream(fos);
            for (int i = 0; i < o.size(); i++) {
                dos.writeUTF(o.get(i).getName());
                dos.writeInt(o.get(i).getLatDe());
                dos.writeInt(o.get(i).getLatM());
                dos.writeUTF(o.get(i).getLatDi());
                dos.writeInt(o.get(i).getLongde());
                dos.writeInt(o.get(i).getLongm());
                dos.writeUTF(o.get(i).getLongDi());
            }
            dos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void runTripMenu() {
        tripMenukeepgoing = true;
        while (tripMenukeepgoing) {
            System.out.println("1. Create a new trip");
            System.out.println("2. Edit you trip");
            System.out.println("3. Current trip plans.");
            System.out.println("q. return to last menu.");
            userinput = keyboard.nextLine();
            processTripmenu();
        }
    }

    public static void processTripmenu() {
        if (userinput.equals("1")) {
            System.out.println("Name your trip");
            userinput = keyboard.nextLine();
            tempfilename = userinput;
            Trips.add(userinput);
            System.out.println("***Trip created successful: " +tempfilename);
            EditTripMenu();
        } else if (userinput.equals("2")) {
            if (Trips.size() < 1) {
                System.out.println("***You don't have any trip plan yet.");
            } else {
                System.out.println("***Your trip Plans: " + Trips);
                System.out.println("***Which one you want to edit?");
                userinput = keyboard.nextLine();
                for (int i = 0; i < Trips.size(); i++)
                    if (Trips.get(i).toLowerCase().equals(userinput.toLowerCase())) {
                        loadArrayFromFile(userinput + ".text", tripplan);
                        tempfilename = userinput;
                        System.out.println("***Opening file: "+Trips.get(i)+".text");
                        EditTripMenu();
                        i = Trips.size()-1;
                    } else if (i == Trips.size() - 1&&Trips.size()!=1) {
                        System.out.println("This trips plan does not exist.");
                    }
            }
        }else if(userinput.equals("3")){
            if(Trips.size()<1){
                System.out.println("You don't have any plans yet!");
            }else {
                System.out.println("***This is your current trip plans: " + Trips);
            }
        }else if(userinput.toLowerCase().equals("q")){
            tripMenukeepgoing = false;
        }
    }

    public static void EditTripMenu() {
        keepProcessEdit = true;
        while (keepProcessEdit) {
            System.out.println("***This is your current plan: " + tripplan);
            System.out.println("1. Add stops to your trip.");
            System.out.println("2. remove stops in your trip.");
            System.out.println("3. Insert stops to your trip.");
            System.out.println("4. Save the trip and return to last menu.");
            System.out.println("5. Check your trips's mileage.");
            userinput = keyboard.nextLine();
            if (userinput.equals("1")){
                System.out.println("***This is your current possible stops:" + stops);
                System.out.println("***Which stop you wanna put in your plan?");
                userinput = keyboard.nextLine();
                for (int i = 0; i < stops.size(); i++) {
                    if (stops.get(i).getName().toLowerCase().equals(userinput.toLowerCase())) {
                        tripplan.add(stops.get(i));
                        System.out.println("***Stops added.");
                        i = stops.size();
                    } else if (i == stops.size() - 1 & !stops.get(i).getName().toLowerCase().equals(userinput.toLowerCase())) {
                        System.out.println("***This City is not in your possible stops.");
                    }
                }
            }else if(userinput.equals("2")){
                if (tripplan.size() < 1) {
                    System.out.println("***You don't have any stops!");
                } else {
                    System.out.println("***Which one you wanna remove?");
                    userinput = keyboard.nextLine();
                    for (int a = 0; a < tripplan.size(); a++) {
                        if (tripplan.get(a).getName().toLowerCase().equals(userinput.toLowerCase())) {
                            multiple = MultipleCondition(tripplan.get(a));
                            tripplan.remove(multiple);
                            System.out.println("***Remove stops Successful.");
                            break;
                        } else if (a == tripplan.size() - 1 & !tripplan.get(a).getName().toLowerCase().equals(userinput.toLowerCase())) {
                            System.out.println("***You don't have this stop");
                        }
                    }
                }
            }else if(userinput.equals("3")){
                System.out.println("***Where you wanna insert(after which city?)");
                System.out.println("***This is your current plan: " + tripplan);
                userinput = keyboard.nextLine();
                for (int i = 0; i < tripplan.size(); i++) {
                    if (tripplan.get(i).getName().toLowerCase().equals(userinput.toLowerCase())) {
                        int c = MultipleCondition(tripplan.get(i));
                        System.out.println("***Which stop you wanna add to your plan?");
                        userinput =keyboard.nextLine();
                        for(int k = 0;k<stops.size();k++){
                            if(stops.get(k).getName().toLowerCase().equals(userinput.toLowerCase())){
                                tripplan.add(c+1,stops.get(k));
                                System.out.println("***Stop add successful.");
                                k=stops.size()-1;
                            }else if(k == stops.size()-1 &!stops.get(k).getName().toLowerCase().equals(userinput.toLowerCase())){
                                System.out.println("***You don't have this stop in your possible stop");
                            }
                        }
                        break;
                    } else if (i == stops.size()-1 & !tripplan.get(i).getName().toLowerCase().equals(userinput.toLowerCase()) ) {
                        System.out.println("***This City is not in your possible stops.");
                    }
                }
            }else if(userinput.equals("4")) {
                writeArraytoFile(tempfilename+".text",tripplan);
                writeTripstoFile("AllTrips.text");
                tripplan.clear();
                keepProcessEdit = false;
            }else if(userinput.equals("5")){
                distance = 0;
                if(tripplan.size()<2){
                    System.out.println("***You plans was way too short.");
                }else{
                    double x;
                    double RF = 180/Math.PI;
                    for(int i =0; i <tripplan.size()-1;i++){
                        x = ((Math.sin(tripplan.get(i).getLatDe()/RF))*(Math.sin(tripplan.get(i+1).getLatDe()/RF)))+
                                ((Math.cos(tripplan.get(i).getLatDe()/RF))*(Math.cos(tripplan.get(i+1).getLatDe()/RF))*(Math.cos((tripplan.get(i).getLongde()/RF)-(tripplan.get(i+1).getLongde()/RF))));
                        distance += (6371*Math.atan((Math.sqrt(1-Math.pow(x,2))/x)));
                    }
                }System.out.println("This is current Mileage: " + distance);
            }
        }
    }
    public static int MultipleCondition(Cities o){
        int a = 0;
        int d = 0;
        for(int i = 0; i<tripplan.size();i++){
            if(tripplan.get(i).getName().toLowerCase().equals(o.getName().toLowerCase())){
                a+=1;
                d = i;
            }
        }if(a>1) {
            System.out.println("***You have several stops in your trip.Which one is your choice?(Type the number)");
            userinput = keyboard.nextLine();
            int b = Integer.parseInt(userinput);
            if(b>a){
                System.out.println("***You don't have many of this city...");
            }else{
                for(int c =0; c<tripplan.size();c++) {
                    if(tripplan.get(c).getName().toLowerCase().equals(o.getName().toLowerCase())){
                        b--;
                    }if(b==0){
                        d = c;
                        break;
                    }

                }
            }
        }
        return d;
    }

    public static void newCity(){
        System.out.println("***YOU NEED THE FULL name, latitudinal, and longitudinal coordinates for the stop");
        String addname = userinput;
        System.out.println("***City's name : " + userinput);
        System.out.println("***City's latitudinal(degree):");
        int addlatde = Integer.parseInt(keyboard.nextLine());
        System.out.println("***City's latitudinal(minutes):");
        int addlatmi = Integer.parseInt(keyboard.nextLine());
        System.out.println("***City's longitudinal:(degree)");
        int addlongdeg = Integer.parseInt(keyboard.nextLine());
        System.out.println("***City's longitudinal:(minutes)");
        int addlongmin = Integer.parseInt(keyboard.nextLine());
        stops.add(new Cities(addname, addlatde, addlatmi, "N", addlongdeg, addlongmin, "W"));
    }
    public static void writeTripstoFile(String filename){
        DataOutputStream dos;
        try {
            File f = new File(filename);
            FileOutputStream fos = new FileOutputStream(f);
            dos = new DataOutputStream(fos);
            for (int i = 0; i < Trips.size(); i++) {
                dos.writeUTF(Trips.get(i));
            }
            dos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void loadTripsFromFile(String fileName){
        try {
            File f = new File(fileName);
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            while (fis.available() > 0) {
                String name = dis.readUTF();
                Trips.add(name);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
