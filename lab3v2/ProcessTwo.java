import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by the tutees on 4/26/2017.
 */
public class ProcessTwo {

    public void DoThis(ArrayList<Double> frequency, ArrayList<Double> MD,ArrayList<Double> FX, ArrayList<Double> FX2, ArrayList<Double> upperCL, ArrayList<Double> lowerCL){
        Mean mean = new Mean();
        Median median = new Median();
        Mode mode = new Mode();

        Scanner scan = new Scanner(System.in);


        System.out.println("What measures of central tendency to calculate. User’s choices are:\n" +
                "[1] Mean\n[2] Median\n[3] Mode\n[4] all measures");
        int choice6 = scan.nextInt();
        DecimalFormat df = new DecimalFormat("####0.00");
        if (choice6 == 1){
            System.out.println("Mean: " + mean.meanGrouped(FX, frequency) + "\tVariance: " + df.format(mean.gVar(frequency, FX, FX2))
                    +"\nStandard Dev: " + df.format(mean.gStandardDev(frequency, FX, FX2)));
        }else if (choice6 == 2){
            System.out.println("Median not computed");
        }else if (choice6 == 3){
            ArrayList<Integer> modes = mode.modeGroup(frequency);
            if (modes.size() == 1){
                System.out.println("unimodal");
            }else if (modes.size() == 2){
                System.out.println("bimodal");
            }else if (modes.size() >= 3){
                System.out.println("multimodal");
            }else {
                System.out.println("No mode");
            }
            for (int i = 0; i < modes.size(); i++){
                System.out.print( lowerCL.get(modes.get(i)) + "-" + upperCL.get(modes.get(i)) + "\t");
            }

        }else if (choice6 == 4){
            System.out.println("Mean: " + mean.meanGrouped(FX, frequency) + "\tVariance: " + df.format(mean.gVar(frequency, FX, FX2))
                    +"\nStandard Dev: " + df.format(mean.gStandardDev(frequency, FX, FX2)));
            System.out.println("Median not computed");
            ArrayList<Integer> modes = mode.modeGroup(frequency);
            if (modes.size() == 1){
                System.out.println("unimodal");
            }else if (modes.size() == 2){
                System.out.println("bimodal");
            }else if (modes.size() >= 3){
                System.out.println("multimodal");
            }else {
                System.out.println("No mode");
            }
            for (int i = 0; i < modes.size(); i++){
                System.out.print( lowerCL.get(modes.get(i)) + "-" + upperCL.get(modes.get(i)) + "\t");
            }
        }
    }

    public void DoThis2(ArrayList<Double> frequency, ArrayList<Double> MD,ArrayList<Double> FX, ArrayList<Double> FX2, ArrayList<Double> upperCL, ArrayList<Double> lowerCL){
        Mean mean = new Mean();
        Median median = new Median();
        Mode mode = new Mode();

        Scanner scan = new Scanner(System.in);


        System.out.println("What measures of central tendency to calculate. User’s choices are:\n" +
                "[1] Mean\n[2] Median\n[3] Mode\n[4] all measures");
        int choice6 = scan.nextInt();

        if (choice6 == 1){
            System.out.println("Mean cannot be calculated for grouped data with open-ended class interval(s)");
        }else if (choice6 == 2){
            System.out.println("Median cannot be calculated for grouped data with open-ended class interval(s)");
        }else if (choice6 == 3){
            ArrayList<Integer> modes = mode.modeGroup(frequency);
            if (modes.size() == 1){
                System.out.println("unimodal");
            }else if (modes.size() == 2){
                System.out.println("bimodal");
            }else if (modes.size() >= 3){
                System.out.println("multimodal");
            }else {
                System.out.println("No mode");
            }
            for (int i = 0; i < modes.size(); i++){
                System.out.print( lowerCL.get(modes.get(i)) + "-" + upperCL.get(modes.get(i)) + "\t");
            }

        }else if (choice6 == 4){
            System.out.println("Mean cannot be calculated for grouped data with open-ended class interval(s)");
            System.out.println("Median cannot be calculated for grouped data with open-ended class interval(s)");
            ArrayList<Integer> modes = mode.modeGroup(frequency);
            if (modes.size() == 1){
                System.out.println("unimodal");
            }else if (modes.size() == 2){
                System.out.println("bimodal");
            }else if (modes.size() >= 3){
                System.out.println("multimodal");
            }else {
                System.out.println("No mode");
            }
            for (int i = 0; i < modes.size(); i++){
                System.out.print( lowerCL.get(modes.get(i)) + "-" + upperCL.get(modes.get(i)) + "\t");
            }
        }
    }


}
