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
        List<Double> frequency = new ArrayList<>();
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
                System.out.println("mean: " + mean.meanUngrouped(frame)+ "\nstandard dev: "+mean.ugStandasrdDev(frame));
            }else if (choice3 == 2){
                System.out.println(median.medUn(frame));
            }else if (choice3 == 3){

            }else if (choice3 == 4){
                System.out.println("mean: " + mean.meanUngrouped(frame)+ "\nstandard dev: "+mean.ugStandasrdDev(frame));
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
                if (choice5 == 2){

                }


            }
        }else if(choice ==3){
            System.exit(0);
        }
    }
}
