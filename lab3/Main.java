import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Winnah Gwen Acal on 4/21/2017.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Double> frame = new ArrayList<>();
        int inSize;
        int CI;
        List<Double> lowerCL = new ArrayList<>();
        List<Double> upperCL = new ArrayList<>();
        ArrayList<Double> frequency = new ArrayList<>();
        ArrayList<Double> classMark = new ArrayList<>();
        ArrayList<Double> fx = new ArrayList<>();
        ArrayList<Double> fx2 = new ArrayList<>();
        Mean mean = new Mean();
        Median median = new Median();
        Mode mode = new Mode();

        System.out.println("\t\tMENU\n\t[1] Ungrouped Data \n\t[2] Grouped Data \n\t[3] Quit");
        Scanner scan = new Scanner(System.in);
        Integer choice = scan.nextInt();


        if (choice == 1){
            do {
                try {
                    System.out.println("Input Size:");
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

            System.out.println("[1] Continue\n[2] Edit");
            int choice2 = scan.nextInt();
            while (choice2 == 2){
                System.out.println("Input the index: ");
                int inde = scan.nextInt();
                System.out.println("Input the replacement value: ");
                double val = scan.nextInt();
                frame.set(inde, val);
                System.out.println(frame.toString());
                System.out.println("[1] Continue\n[2] Edit");
                choice2 = scan.nextInt();
            }

            System.out.println("What measures of central tendency to calculate. User’s choices are:\n" +
                    "[1] Mean\n[2] Median\n[3] Mode\n[4] all measures");
            int choice3 = scan.nextInt();

            if (choice3 == 1){
                System.out.println("mean: " + mean.meanUngrouped(frame)+ "\nstandard dev: "+mean.ugStandardDev(frame));
            }else if (choice3 == 2){
                System.out.println(median.medUn(frame));
            }else if (choice3 == 3){

            }else if (choice3 == 4){
                System.out.println("mean: " + mean.meanUngrouped(frame)+ "\nstandard dev: "+mean.ugStandardDev(frame));
                System.out.println(median.medUn(frame));
            }
        }else if(choice == 2){
            do {
                try {
                    System.out.println("Input number of class intervals:");
                    CI = scan.nextInt();

                    break;
                }
                catch (Exception e) {
                    System.out.println("Wrong Input");
                    scan.next();
                }
            } while (true);

            System.out.println("Are there open-ended class?\n [1] Yes\n [2] No");
            int choice4 = scan.nextInt();

            if (choice4 == 2){
                System.out.println("Input Lower Class Limit (number per Enter):");
                for (int i = 0; i < CI;) {
                    try{
                        lowerCL.add(scan.nextDouble());
                        i++;
                    }catch(Exception e){
                        System.out.println("Numbers Only");
                        scan.next();
                    }
                }

                System.out.println("Input Upper Class Limit (number per Enter):");
                for (int i = 0; i < CI;) {
                    try{
                        upperCL.add(scan.nextDouble());
                        i++;
                    }catch(Exception e){
                        System.out.println("Numbers Only");
                        scan.next();
                    }
                }

                System.out.println("Input Frequency column  (number per Enter):");
                for (int i = 0; i < CI;) {
                    try{
                        frequency.add(scan.nextDouble());
                        i++;
                    }catch(Exception e){
                        System.out.println("Numbers Only");
                        scan.next();
                    }
                }

                System.out.println("[1] Continue\n[2] Edit");
                int choice5 = scan.nextInt();
                while(choice5 == 2){

                }
                double dummy;
                for (int i = 0; i < CI; i++){
                    dummy = (upperCL.get(i) + lowerCL.get(i))/2;
                    classMark.add(dummy);
                }

                double dummy2;
                for (int i = 0; i < CI; i++){
                    dummy2 = classMark.get(i) * frequency.get(i);
                    fx.add(dummy2);
                }

                double dummy3;
                for (int i = 0; i < CI; i++){
                    dummy3 = (classMark.get(i) * classMark.get(i)) * frequency.get(i);
                    fx2.add(dummy3);
                }

                for (int i = 0; i < CI; i++){
                    System.out.println(lowerCL.get(i) + "-" + upperCL.get(i) +  "\t"+ frequency.get(i) + "\t"+
                    classMark.get(i) +"\t" + fx.get(i) + "\t" + fx2.get(i));
                }

                System.out.println("What measures of central tendency to calculate. User’s choices are:\n" +
                        "[1] Mean\n[2] Median\n[3] Mode\n[4] all measures");
                int choice6 = scan.nextInt();
                if (choice6 == 1){
                    System.out.println("Mean: " + mean.meanGrouped(fx, frequency) + "\nStandard Dev: "
                            + mean.gStandardDev(frequency, fx, fx2));
                }else if (choice6 == 2){
                    System.out.println("Median not computed");
                }else if (choice6 == 3){
                    ArrayList<Integer> modes = mode.modeGroup(frequency);
                    if (modes.size() == 1){
                        System.out.println("unimodal: ");
                        System.out.println("Modal class(es): ");
                    }else if (modes.size() == 2){
                        System.out.println("bimodal: ");
                        System.out.println("Modal class(es): ");
                    }else if (modes.size() >= 3){
                        System.out.println("multimodal: ");
                        System.out.println("Modal class(es): ");
                    }else {
                        System.out.println("No mode: ");
                    }

                    for (int i = 0; i <modes.size(); i++){
                        System.out.print( upperCL.get(modes.get(i)) + "-" + upperCL.get(modes.get(i)) + "\t");
                    }
                }else if (choice6 == 4){
                    System.out.println("Mean: " + mean.meanGrouped(fx, frequency) + "\nStandard Dev: "
                            + mean.gStandardDev(frequency, fx, fx2));
                    System.out.println("Median not computed");
                    ArrayList<Integer> modes = mode.modeGroup(frequency);
                    if (modes.size() == 1){
                        System.out.println("unimodal: ");
                        System.out.println("Modal class(es): ");
                    }else if (modes.size() == 2){
                        System.out.println("bimodal: ");
                        System.out.println("Modal class(es): ");
                    }else if (modes.size() >= 3){
                        System.out.println("multimodal: ");
                        System.out.println("Modal class(es): ");
                    }else {
                        System.out.println("No mode: ");
                    }
                    for (int i = 0; i <modes.size(); i++){
                        System.out.print( upperCL.get(modes.get(i)) + "-" + upperCL.get(modes.get(i)) + "\t");
                    }
                }
            }else {
                System.out.println("Which class is open-ended?\n [1] First\n [2] Last\n [3] both");
                int choice7 = scan.nextInt();

                if (choice7 == 1){

                }else if (choice7 == 2){

                }else if (choice7 == 3){

                }


            }
        }else if(choice ==3){
            System.exit(0);
        }
    }
}
