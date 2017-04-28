import java.util.ArrayList;

/**
 * Created by Winnah Gwen Acal on 4/21/2017.
 */

public class Mode {
    public ArrayList getmode(ArrayList<Double> list, ArrayList<Integer> list2, Integer type) {
        ArrayList modes = new ArrayList();
        double mode = 0.0;
        if(type == 2){
            mode = list.get(0);
            int maxCount = 0;
            int store = 0;

            for (int i = 0; i < list.size(); i++) {
                double value = list.get(i);
                int count = 1;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == value) count++;
                    if (count > maxCount) {
                        mode = value;
                        maxCount = count;
                    }
                }
                if(count == maxCount){
                    if(!(modes.contains(list2.get(i)))) {
                        modes.add(list2.get(i));
                    }
                }
            }
            return modes;
        } else if (type == 1){
            mode = list2.get(0)+0.0;
            int maxCount = 0;

            for (int i = 0; i < list2.size(); i++) {
                double value = list2.get(i);
                int count = 1;
                for (int j = 0; j < list2.size(); j++) {
                    if (list2.get(j) == value) count++;
                    if (count > maxCount) {
                        mode = value;
                        maxCount = count;
                    }

                }

                if(count == maxCount && count > 2){
                    if(!(modes.contains(list2.get(i)))) {
                        modes.add(list2.get(i));
                    }
                }

            }
            return modes;
        }
        return modes;
    }

    public ArrayList modeGroup (ArrayList<Double> frequency){
        double max = 0;
        ArrayList<Integer> modes = new ArrayList<>();
        for (int i = 0; i < frequency.size(); i++){
            if (frequency.get(i) > max){
                max = frequency.get(i);
            }
        }

        if (max > 1){
            for (int i = 0; i < frequency.size(); i++){
                if (frequency.get(i) == max){
                    modes.add(i);
                }
            }
        }

        return modes;
    }

}
