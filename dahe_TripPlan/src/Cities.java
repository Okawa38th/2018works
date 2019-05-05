import java.util.Comparator;

public class Cities{
    private String name;
    private  int latDe;
    private  int latM;
    private  String latDi;
    private  int longde;
    private  int longm;
    private  String longDi;



    public Cities(String initname, int initlatDe, int initlatM, String initlatDi, int initlongde, int initlongm, String initlongDi ){
        name = initname;
        latDe = initlatDe;
        latM = initlatM;
        latDi = initlatDi;
        longde = initlongde;
        longm = initlongm;
        longDi = initlongDi;
    }

    public String getName() {
        return name;
    }

    public int getLatDe() {
        return latDe;
    }

    public int getLatM() {
        return latM;
    }

    public String getLatDi() {
        return latDi;
    }

    public int getLongde() {
        return longde;
    }

    public int getLongm() {
        return longm;
    }

    public String getLongDi() {
        return longDi;
    }

    public static class CitySortByName implements Comparator<Cities>{
        @Override
        public int compare(Cities o1, Cities o2){
            return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public String wholedetail(){
        return name +" "+ latDe + "\u00b0 " + latM + "\' " + latDi + " " + longde + "\u00b0 " + longm + "\' "+ longDi;
    }
}
