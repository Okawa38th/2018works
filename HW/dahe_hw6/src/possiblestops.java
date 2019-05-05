import java.io.*;
import java.util.ArrayList;

public class possiblestops { //it's part of my test.
    static ArrayList<Cities> cities = new ArrayList<Cities>();
    public static void main(String[] args){
        initcities();
        writetofile("PossiblePlaceToGo.text");
    }
    public static void initcities(){
        cities.add(new Cities("Chicago",41,53,"N",87,38,"W"));
        cities.add(new Cities("Dallas",32,51,"N",96,51,"W"));
        cities.add(new Cities("Detroit",42,25,"N",83,1,"W"));
        cities.add(new Cities("Houston",29,59,"N",95,22,"W"));
        cities.add(new Cities("Los Angeles",33,56,"N",118,24,"W"));
        cities.add(new Cities("New York City",40,47,"N",73,58,"W"));
        cities.add(new Cities("Philadelphia",39,53,"N",75,15,"W"));
        cities.add(new Cities("Phoenix",33,26,"N",112,1,"W"));
        cities.add(new Cities("San Antonio",29,32,"N",98,28,"W"));
        cities.add(new Cities("San Diego",32,44,"N",117,10,"W"));
    }
    public static void writetofile(String filename){
        DataOutputStream dos;
        try{
            File f = new File(filename);
            FileOutputStream fos = new FileOutputStream(f);
            dos = new DataOutputStream(fos);

            for(int i =0; i<cities.size();i++){
                dos.writeUTF(cities.get(i).getName());
                dos.writeInt(cities.get(i).getLatDe());
                dos.writeInt(cities.get(i).getLatM());
                dos.writeUTF(cities.get(i).getLatDi());
                dos.writeInt(cities.get(i).getLongde());
                dos.writeInt(cities.get(i).getLongm());
                dos.writeUTF(cities.get(i).getLongDi());
            }
            dos.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }



}
