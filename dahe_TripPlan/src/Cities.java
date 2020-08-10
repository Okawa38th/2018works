import java.util.Comparator;

public class Cities{
    private String name;
    private String state;
    private  int latDe;
    private  int latM;
    private  int longde;
    private  int longm;



    public Cities(String initname, String initstate, int initlatDe, int initlatM,int initlongde, int initlongm){
        name = initname;
        state = initstate;
        latDe = initlatDe;
        latM = initlatM;
        longde = initlongde;
        longm = initlongm;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getLatDe() {
        return latDe;
    }


    public void setLatDe(int latDe) {
        this.latDe = latDe;
    }

    public int getLatM() {
        return latM;
    }

    public void setLatM(int latM) {
        this.latM = latM;
    }

    public int getLongde() {
        return longde;
    }

    public void setLongde(int longde) {
        this.longde = longde;
    }

    public int getLongm() {
        return longm;
    }

    public void setLongm(int longm) {
        this.longm = longm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class CitySortByName implements Comparator<Cities>{
        @Override
        public int compare(Cities o1, Cities o2){
            return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
        }
    }

    @Override
    public String toString() {
        return name+", "+ state;
    }

    public String wholedetail(){
        return name +" "+ state+" "+ latDe + "\u00b0 " + latM + "\' " + " " + longde + "\u00b0 " + longm + "\' ";
    }
}
