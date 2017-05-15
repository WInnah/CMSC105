import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Winnah Gwen Acal on 3/17/2017.
 */
public class Main {
    public static void main(String[] args) {
        List<Double> frame = new ArrayList<>();
        List<Double> limitLeft = new ArrayList<>();
        List<Double> limitRight = new ArrayList<>();
        List<Double> trueLimitLeft = new ArrayList<>();
        List<Double> trueLimitRight = new ArrayList<>();
        List<Double> midpoint = new ArrayList<>();
        List<Integer> frequency = new ArrayList<>();
        List<Double> percent = new ArrayList<>();
        List<Integer> cf = new ArrayList<>();
        List<Double> cp = new ArrayList<>();


        double subtrahend = 0.5;
        int des = 2;
        DecimalFormat numberFormat = new DecimalFormat("#.0");
        DecimalFormat numberFormat2 = new DecimalFormat("#.00");
        int inSize;
        System.out.println("\t\tMENU\n\t[1] Categorical \n\t[2] Numerical\n\t[3] Quit");
        Scanner scan = new Scanner(System.in);
        Integer choice = scan.nextInt();

        if (choice == 2){
            System.out.println("[1] Integer\t[2] Float");
            int choice2 = scan.nextInt();

            do {
                try {
                    System.out.println("Input Population Size:");
                    inSize = scan.nextInt();

                    break;
                }
                catch (Exception e) {
                    System.out.println("Wrong Input");
                    scan.next();
                }
            } while (true);

            System.out.println("Input Sampling Frame (number per Enter):");
            for (int i = 0; i < inSize;) {
                try{
                    frame.add(scan.nextDouble());
                    i++;
                }catch(Exception e){
                    System.out.println("Numbers Only");
                    scan.next();
                }
            }
            for (int z = 0; z < frame.size(); z++) {
                System.out.println("[" + z + "]\t" + frame.get(z));
            }

            double max = 0;
            double min = frame.get(0);
            for(int j = 0; j < frame.size(); j++){
                if (max < frame.get(j)){
                    max = frame.get(j);
                }
                if (min > frame.get(j)){
                    min = frame.get(j);
                }
            }

            int width;
            double width2;
            double range = max - min;
            double k = Math.ceil(1 + 3.322*Math.log10(inSize));
            if (choice2 == 1){
                width = (int)Math.ceil(range/k);
                double limit = min;
                while (limit < max){
                    limitLeft.add(limit);
                    limit += width;
                }
                System.out.println(width);
                double limit2 = min + width - 1;
                while (limit2 <= max){
                    limitRight.add(limit2);
                    limit2 += width;
                }
            }else {
                width2 = Math.round((range/k)*10.0)/10.0;
                double limit = min;
                while (limit < max){
                    limitLeft.add(limit);
                    limit += width2;
                }
                System.out.println(width2);
                double limit2 = min + width2 - 1;
                while (limit2 <= max){
                    limitRight.add(limit2);
                    limit2 += width2;
                }
            }
            System.out.println("k: "+ k);

            if (limitRight.get(limitRight.size()-1) != max){
                limitRight.add( max);
            }

            //true limit
            if (des == 1){
                subtrahend = 0.5;
            }else{
                int count1 = 0;
                float diff = 0;
                boolean flag = false;
                for (int j = 0; j < frame.size(); j++){
                    double value = Math.floor(frame.get(j));
                    diff = (float)(frame.get(j) - value);
                    String counts = String.valueOf(diff);
                    if (diff > 0.0){
                        if (counts.length() - 2 > count1){
                            count1 = counts.length() - 2;
                            System.out.println(count1);
                        }
                    }
                }

                System.out.println(count1);

                for (int j = 0; j < count1; j++){
                    subtrahend /= 10;
                    System.out.println(subtrahend);
                }
            }


            //TODO this
            System.out.println("sub: "+subtrahend);
            for (int j = 0; j < limitLeft.size(); j++){
                trueLimitLeft.add(limitLeft.get(j) - subtrahend);
            }

            for (int j = 0; j < limitRight.size(); j++){
                trueLimitRight.add(limitRight.get(j) + subtrahend);
            }



            //midpoint
            for (int j = 0; j < limitLeft.size(); j++){
                midpoint.add((limitLeft.get(j) + limitRight.get(j))/2);
            }


            //frequency
            for (int j = 0; j < limitLeft.size(); j++){
                int count = 0;
                for (int m = 0; m < frame.size(); m++){
                    if (frame.get(m) >= limitLeft.get(j) && frame.get(m) <= limitRight.get(j)){
                        count++;
                    }
                }
                frequency.add(count);
            }


            //percent
            for (int j = 0; j < frequency.size(); j++){
                double pp = ((double)frequency.get(j)/inSize)*100;
                percent.add(pp);
            }


            int cff = 0;
            for (int j = 0; j < frequency.size(); j++){
                cff += frequency.get(j);
                cf.add(cff);
            }


            double cpp = 0;
            for (int j = 0; j < percent.size(); j++){
                cpp += percent.get(j);
                cp.add(cpp);
            }


            for (int j = 0; j < limitLeft.size(); j++){
                if (j == 0){
                    System.out.println("\nClass Limit\tTrue Limit\tMidp\tFre\tPerce\tCFre\tCPer");
                }
                System.out.print(numberFormat.format(limitLeft.get(j))+"-"+numberFormat.format(limitRight.get(j))+"\t"
                        +numberFormat2.format(trueLimitLeft.get(j))+"-"+numberFormat2.format(trueLimitRight.get(j))
                        + "\t"+numberFormat.format(midpoint.get(j))+"\t"+frequency.get(j)+"\t"+ numberFormat.format(percent.get(j))
                        +"\t"+cf.get(j)+"\t"+ numberFormat.format(cp.get(j))+"\n");
            }

        }else if (choice ==1){

        }else{
            System.exit(0);
        }
    }
}
