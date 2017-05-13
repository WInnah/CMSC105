import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Winnah Gwen Acal on 4/21/2017.
 */
public class Median {

    public double medUn (ArrayList<Double> list, ArrayList<Integer> list2, Integer type) {
        double med = 0.0;
        double temp;

        if (type == 2) {
            int sz = ((list2.size()+1)/ 2)-1;
            for (int j = 0; j < list.size(); j++) {
                for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i) > list.get(i + 1)) {
                        temp = list.get(i);
                        list.set(i, list.get(i + 1));
                        list.set(i + 1, temp);
                    }
                }
            }

            if (list.size() % 2 == 0) {
                med = (list.get((list.size() / 2) - 1) + list.get(((list.size() + 2) / 2) - 1)) / 2;
            } else {
                med = list.get(sz-1);
            }
            return med;
        } else if (type == 1){
            int sz = ((list2.size()+1)/ 2);
            for (int j = 0; j < list2.size(); j++) {
                for (int i = 0; i < list2.size() - 1; i++) {
                    if (list2.get(i) > list2.get(i + 1)) {
                        temp = list2.get(i);
                        list2.set(i, list2.get(i + 1));
                        list2.set(i + 1, (int) temp);
                    }
                }
            }

            if (list2.size() % 2 == 0) {
                med = (list2.get((list2.size() / 2) - 1) + list2.get(((list2.size() + 2) / 2) - 1)) / 2; //edit ni
            } else {
                med = list2.get(sz-1);
            }
            return med;

        }

        return med;
    }

    public ArrayList range(ArrayList<Double> list, ArrayList<Integer> list2, Integer type){
        double temp;

        if (type == 2) {
            for (int j = 0; j < list.size(); j++) {
                for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i) > list.get(i + 1)) {
                        temp = list.get(i);
                        list.set(i, list.get(i + 1));
                        list.set(i + 1, temp);
                    }
                }
            }
            return list;
        } else if (type == 1){
            for (int j = 0; j < list2.size(); j++) {
                for (int i = 0; i < list2.size() - 1; i++) {
                    if (list2.get(i) > list2.get(i + 1)) {
                        temp = list2.get(i);
                        list2.set(i, list2.get(i + 1));
                        list2.set(i + 1, (int) temp);
                    }
                }
            }
        }
        return list2;
    }
}