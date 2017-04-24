import java.util.ArrayList;
import java.util.List;

/**
 * Created by Winnah Gwen Acal on 4/21/2017.
 */
public class Mean {

    public double meanUngrouped(ArrayList<Double> list){
        double total = 0;
        for (int i = 0; i < list.size();i++){
            total += list.get(i);
        }
        return total/list.size();
    }

    public double ugStandasrdDev (ArrayList<Double> list){
        double mean = meanUngrouped(list);
        double total = 0;
        double s = 0;
        for (int i = 0; i < list.size();i++){
            total += Math.pow((list.get(i) - mean), 2);
        }
        s = Math.sqrt(total/list.size()-1);
        return s;
    }
}
