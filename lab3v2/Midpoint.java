import java.util.ArrayList;
import java.util.List;

/**
 * Created by the tutees on 4/26/2017.
 */
public class Midpoint {
    ArrayList<Double> MD = new ArrayList<>();
    ArrayList<Double> FX = new ArrayList<>();
    ArrayList<Double> FX2 = new ArrayList<>();


    ArrayList getM(List<Double> lowerCl, List<Double> upperCL){

        for(int i = 0; i < upperCL.size(); i++){
            MD.add((lowerCl.get(i)+upperCL.get(i))/2);
        }

        return MD;
    }

    ArrayList getFX(List<Double> frequency, ArrayList<Double> Md) {
        for (int i = 0; i < frequency.size(); i++) {
            FX.add((frequency.get(i) * Md.get(i)));
        }

        return FX;
    }

    ArrayList getFX2(List<Double> frequency, ArrayList<Double> Md) {
        for (int i = 0; i < frequency.size(); i++) {
            FX2.add((frequency.get(i) * (Md.get(i)*Md.get(i))));
        }

        return FX2;
    }

}
