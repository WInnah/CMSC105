import java.util.ArrayList;
import java.util.List;

/**
 * Created by Winnah Gwen Acal on 4/21/2017.
 */
public class Mean {

    public double meanUngrouped(ArrayList<Double> list, ArrayList<Integer> list2, Integer type){
        double total = 0;
        if(type == 2){
            for (int i = 0; i < list.size(); i++) {
                total += list.get(i);
            }
            return total / list.size();
        } else if (type == 1) {
            for (int i = 0; i < list2.size(); i++) {
                total += list2.get(i);
            }
            return total / list2.size();
        }

        return total;
    }

    public double ugStandasrdDev (ArrayList<Double> list, ArrayList<Integer> list2, Integer type){
        double mean = meanUngrouped(list,list2,type);
        double total = 0;
        double s = 0;

        if(type == 2) {
            for (int i = 0; i < list.size(); i++) {
                total = total + ((list.get(i) - mean) * (list.get(i) - mean));
            }
            s = Math.sqrt(total / list.size() - 1);
            return s;
        } else if(type == 1){
            for (int i = 0; i < list2.size(); i++) {
                total = total + ((list2.get(i) - mean) * (list2.get(i) - mean));
            }
            s = Math.sqrt(total / list2.size() - 1);
            return s;

        }

        return s;
    }

    public double ugVar (ArrayList<Double> list, ArrayList<Integer> list2, Integer type){
        double mean = meanUngrouped(list,list2,type);
        double total = 0;
        double s = 0;

        if(type == 2) {
            for (int i = 0; i < list.size(); i++) {
                total = total + ((list.get(i) - mean) * (list.get(i) - mean));
            }
            s = total / list.size() - 1;
            return s;
        } else if(type == 1){
            for (int i = 0; i < list2.size(); i++) {
                total = total + ((list2.get(i) - mean) * (list2.get(i) - mean));
            }
            s = total / list2.size() - 1;
            return s;

        }

        return s;
    }

    public double meanGrouped (ArrayList<Double> fx, ArrayList<Double> frequency){
        double total1 = 0;
        double total2 = 0;

        for (int i = 0; i < fx.size();i++){
            total1 += fx.get(i);
        }

        for (int i = 0; i < frequency.size();i++){
            total2 += frequency.get(i);
        }
        return total1/total2;
    }

    public double gStandardDev(ArrayList<Double> frequency, ArrayList<Double> fx, ArrayList<Double> fx2){
        double total1 = 0;
        double total2 = 0;
        double total3 = 0;
        double s;

        for (int i = 0; i < fx.size();i++){
            total1 += fx.get(i);
        }

        for (int i = 0; i < frequency.size();i++){
            total2 += frequency.get(i);
        }

        for (int i = 0; i < fx2.size();i++){
            total3 += fx2.get(i);
        }

        s = Math.sqrt(((total2*total3) - (total1*total1))/(total2*(total2-1)));

        return  s;
    }

    public double gVar(ArrayList<Double> frequency, ArrayList<Double> fx, ArrayList<Double> fx2){
        double total1 = 0;
        double total2 = 0;
        double total3 = 0;
        double s;

        for (int i = 0; i < fx.size();i++){
            total1 += fx.get(i);
        }

        for (int i = 0; i < frequency.size();i++){
            total2 += frequency.get(i);
        }

        for (int i = 0; i < fx2.size();i++){
            total3 += fx2.get(i);
        }

        s = (((total2*total3) - (total1*total1))/(total2*(total2-1)));

        return  s;
    }
}