import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by the tutees on 4/26/2017.
 */
public class ProcessOne {

    public void DoThis(int choice, ArrayList<Double> Doubleframe, ArrayList<Integer> Integerframe, Integer type){
        ArrayList<Integer> modes = new ArrayList<>();
        Mean mean = new Mean();
        Median median = new Median();
        Mode mode = new Mode();

        Scanner scan = new Scanner(System.in);

        System.out.println("What measures of central tendency to calculate. User’s choices are:\n" +
                "[1] Mean\n[2] Median\n[3] Mode\n[4] all measures");
        int choice3 = scan.nextInt();

        if (choice3 == 1){
            System.out.println("mean: " + mean.meanUngrouped(Doubleframe,Integerframe,type) +
                    "\tvariance: " + mean.ugVar(Doubleframe,Integerframe,type) +
                    "\nstandard dev: " + mean.ugStandasrdDev(Doubleframe,Integerframe,type));
        }else if (choice3 == 2){
            if (type == 1){
                ArrayList<Integer> list = median.range(Doubleframe,Integerframe,type);
                System.out.println("median: " + median.medUn(Doubleframe,Integerframe,type) +
                        "\trange: " + list.get(0) +"-"+ list.get(list.size()-1));
            }else if (type ==2){
                ArrayList<Double> list2 = median.range(Doubleframe,Integerframe,type);
                System.out.println("median: " + median.medUn(Doubleframe,Integerframe,type) +
                        "\trange: " + list2.get(0) +"-"+ list2.get(list2.size()-1));
            }
        }else if (choice3 == 3){
            modes = mode.getmode(Doubleframe,Integerframe,type);
            System.out.println("mode: "+modes);
            if (modes.size() == 0){
                System.out.print(" No Mode");
            } else if (modes.size() == 1){
                System.out.print(" Unimodal");
            }else if (modes.size() == 2){
                System.out.print(" Bimodal");
            } else if(modes.size() > 2){
                System.out.print(" Multi-modal");
            }

        }else if (choice3 == 4){
            System.out.println("mean: " + mean.meanUngrouped(Doubleframe,Integerframe,type) +
                    "\tvariance: " + mean.ugVar(Doubleframe,Integerframe,type) +
                    "\nstandard dev: " + mean.ugStandasrdDev(Doubleframe,Integerframe,type));
            if (type == 1){
                ArrayList<Integer> list = median.range(Doubleframe,Integerframe,type);
                System.out.println("median: " + median.medUn(Doubleframe,Integerframe,type) +
                        "\trange: " + list.get(0) +"-"+ list.get(list.size()-1));
            }else if (type == 2){
                ArrayList<Double> list2 = median.range(Doubleframe,Integerframe,type);
                System.out.println("median: " + median.medUn(Doubleframe,Integerframe,type) +
                        "\trange: " + list2.get(0) +"-"+ list2.get(list2.size()-1));
            }
            modes = mode.getmode(Doubleframe,Integerframe,type);
            System.out.print("mode: "+modes);
            if (modes.size() == 0){
                System.out.print(" No Mode");
            } else if (modes.size() == 1){
                System.out.print(" Unimodal");
            }else if (modes.size() == 2){
                System.out.print(" Bimodal");
            } else if(modes.size() > 2){
                System.out.print(" Multi-modal");
            }
        }
    }

}

