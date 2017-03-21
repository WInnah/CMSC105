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


        int inSize;
        System.out.println("\t\tMENU\n\t[1] Categorical \n\t[2] Numerical\n\t[3] Quit");
        Scanner scan = new Scanner(System.in);
        Integer choice = scan.nextInt();

        if (choice == 2){
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

            double range = max - min;
            double k = Math.ceil(1 + 3.322*Math.log(inSize));
            int width = (int)Math.ceil(range/k);

            System.out.println("char:   "+max+" "+ min+ " "+ range+ " " + k +" width: "+width);
            double limit = min;
            while (limit < max){
                limitLeft.add(limit);
                limit += width;
            }

            for (int j = 0; j < limitLeft.size(); j++){
                System.out.print(limitLeft.get(j)+ " ");
            }

            double limit2 = min + width - 1;
            while (limit2 <= max){
                limitRight.add(limit2);
                limit2 += width;
            }

            if (limitRight.get(limitRight.size()-1) != max){
                limitRight.add(max);
            }

            System.out.println();
            for (int j = 0; j < limitRight.size(); j++){
                System.out.print(limitRight.get(j)+ " ");
            }

            //true limit
            for (int j = 0; j < limitLeft.size(); j++){
                trueLimitLeft.add(limitLeft.get(j) - 0.5);
            }

            System.out.println();
            for (int j = 0; j < trueLimitLeft.size(); j++){
                System.out.print(trueLimitLeft.get(j)+ " ");
            }

            for (int j = 0; j < limitRight.size(); j++){
                trueLimitRight.add(limitRight.get(j) + 0.5);
            }

            System.out.println();
            for (int j = 0; j < trueLimitRight.size(); j++){
                System.out.print(trueLimitRight.get(j)+ " ");
            }

            //midpoint
            for (int j = 0; j < limitLeft.size(); j++){
                midpoint.add((limitLeft.get(j) + limitRight.get(j))/2);
            }

            System.out.println();
            for (int j = 0; j < midpoint.size(); j++){
                System.out.print(midpoint.get(j)+ " ");
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

            System.out.println();
            for (int j = 0; j < frequency.size(); j++){
                System.out.print(frequency.get(j)+ " ");
            }

            //percent
            for (int j = 0; j < frequency.size(); j++){
                double pp = (double)((frequency.get(j)*100)/inSize);
                percent.add(pp);
            }

            System.out.println();
            for (int j = 0; j < percent.size(); j++){
                System.out.print(percent.get(j)+ " ");
            }


            int cff = 0;
            for (int j = 0; j < frequency.size(); j++){
                cff += frequency.get(j);
                cf.add(cff);
            }

            System.out.println();
            for (int j = 0; j < cf.size(); j++){
                System.out.print(cf.get(j)+ " ");
            }

            double cpp = 0;
            for (int j = 0; j < percent.size(); j++){
                cpp += percent.get(j);
                cp.add(cpp);
            }

            System.out.println();

            for (int j = 0; j < cp.size(); j++){
                System.out.print(cp.get(j)+ " ");
            }


            for (int j = 0; j < limitLeft.size(); j++){
                if (j == 0){
                    System.out.println("\nClass Limit\tTrue Limit\tMidp\tFre\tPerce\tCFre\tCPer");
                }
                System.out.print(limitLeft.get(j)+"-"+limitRight.get(j)+"\t"+trueLimitLeft.get(j)+"-"+trueLimitRight.get(j)
                        + "\t"+midpoint.get(j)+"\t"+frequency.get(j)+"\t"+percent.get(j)+"\t"+cf.get(j)+"\t"+cp.get(j)+"\n");
            }

        }else if (choice ==1){

        }else{
            System.exit(0);
        }
    }
}
