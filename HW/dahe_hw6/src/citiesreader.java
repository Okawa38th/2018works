import java.io.*;
import java.util.ArrayList;

public class citiesreader { //it's a test to see that is my writer working.
    static ArrayList<Cities> cities = new ArrayList<>();

    public static void main(String[] args){
        loadArrayFromFile("PossiblePlaceToGo.text");
        for(int i = 0; i<cities.size();i++){
            System.out.println(cities.get(i).getName());
        }

    }
    public static void loadArrayFromFile(String fileName){
        try{
            File f = new File(fileName);
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            while(fis.available()>0){
                String name = dis.readUTF();
                int latDe = dis.readInt();
                int latM = dis.readInt();
                String latDi = dis.readUTF();
                int longde = dis.readInt();
                int longm = dis.readInt();
                String longDi = dis.readUTF();
                cities.add(new Cities(name,latDe,latM,latDi,longde,longm,longDi));
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
