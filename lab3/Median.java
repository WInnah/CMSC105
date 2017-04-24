import java.util.ArrayList;

/**
 * Created by Winnah Gwen Acal on 4/21/2017.
 */
public class Median {

    public double medUn (ArrayList<Double> list){
        double med ;
        double temp;
        int sz = (int)Math.ceil(list.size()/2);
        for (int j = 0; j < list.size(); j++){
            for (int i = 0; i<list.size()-1; i++){
                if (list.get(i) > list.get(i+1)){
                    temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);
                }
            }
        }

        if(list.size()%2 == 0){
            med = (list.get((list.size()/2)-1) + list.get(((list.size()+2)/2)-1))/2;
        }else{
            med = list.get(sz);
        }
        return med;
    }

}
