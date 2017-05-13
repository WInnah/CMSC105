import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Winnah Gwen Acal on 4/21/2017.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Double> Doubleframe = new ArrayList<>();
        ArrayList<Integer> Integerframe = new ArrayList<>();
        ArrayList<Integer> modes = new ArrayList<>();
        ArrayList<Double> MD = new ArrayList<>();
        ArrayList<Double> FX = new ArrayList<>();
        ArrayList<Double> FX2 = new ArrayList<>();

        int inSize;
        int CI;
        ArrayList<Double> lowerCL = new ArrayList<>();
        ArrayList<Double> upperCL = new ArrayList<>();
        ArrayList<Double> frequency = new ArrayList<>();
        Mean mean = new Mean();
        Median median = new Median();
        Mode mode = new Mode();
        Midpoint md =new Midpoint();
        Display display = new Display();

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

            System.out.println("Table Description: ");
            scan.nextLine();
            String desc = scan.nextLine()+"";

            System.out.println("Data Type: [1] Integer [2] Decimal");
            int type = scan.nextInt();

            System.out.println("\nInput Sampling Frame: ");
            for (int i = 0; i < inSize;) {
                try{

                    if(type == 1) {
                        System.out.print("[" + (i + 1) + "] ");
                        Integer z = scan.nextInt();
                        if(z instanceof Integer) {
                            Integerframe.add(z);
                            i++;
                        } else {
                            System.out.println("Not Integer");
                        }
                    } else if(type == 2){
                        System.out.print("[" + (i + 1) + "] ");
                        Double z = scan.nextDouble();
                        if(z instanceof Double) {
                            Doubleframe.add(z);
                            i++;
                        } else {
                            System.out.println("Not Decimal");
                        }
                    }

                }catch(Exception e){
                    System.out.println("Invalid");
                    scan.next();
                }
            }

            display.display1(Doubleframe, Integerframe, type, desc);
            Boolean continues = true;
            do {

                System.out.println("\n\n[1] Proceed [2] Edit");
                int choice2 = scan.nextInt();
                while (choice2 == 2) {
                    System.out.println("Input the index: ");
                    int inde = scan.nextInt();
                    System.out.println("Input the replacement value: ");
                    double val = scan.nextDouble();
                    if (type == 1) {
                        Integerframe.set(inde - 1, (int) val);
                        display.display1(Doubleframe, Integerframe, type, desc);
                    }
                    if (type == 2) {
                        Doubleframe.set(inde + 1, val);
                        display.display1(Doubleframe, Integerframe, type, desc);
                    }
                    System.out.println("\n[1] Proceed [2] Edit");
                    choice2 = scan.nextInt();
                }

                ProcessOne dothis = new ProcessOne();
                dothis.DoThis(choice2, Doubleframe, Integerframe, type);

                System.out.println("\n\nEdit data and compute again [1] Yes [2] No");
                int cc = scan.nextInt();
                if(cc == 2){continues = false;}
            }while (continues);

            main(args);
        }else if(choice == 2){

            System.out.println("Table Description: ");
            scan.nextLine();
            String desc = scan.nextLine()+"";

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

            System.out.println("Are there open-ended class?\n [1] Lower Range [2] Upper Range [3] Both [4] None");
            int choice4 = scan.nextInt();


            if (choice4 == 4){
                System.out.println("Input Lower Class Limit:");
                for (int i = 0; i < CI;) {
                    try{
                        System.out.print("[" + (i + 1) + "] ");
                        lowerCL.add(scan.nextDouble());
                        i++;
                    }catch(Exception e){
                        System.out.println("Invalid");
                        scan.next();
                    }
                }

                System.out.println("Input Upper Class Limit: ");
                for (int i = 0; i < CI;) {
                    try{
                        System.out.print("[" + (i + 1) + "] ");
                        upperCL.add(scan.nextDouble());
                        i++;
                    }catch(Exception e){
                        System.out.println("Invalid");
                        scan.next();
                    }
                }

                System.out.println("Input Frequency column: ");
                for (int i = 0; i < CI;) {
                    try{
                        System.out.print("[" + (i + 1) + "] ");
                        frequency.add(scan.nextDouble());
                        i++;
                    }catch(Exception e){
                        System.out.println("Invalid");
                        scan.next();
                    }
                }

                display.display2(lowerCL,upperCL,frequency,choice4, desc);

                Boolean continues = true;
                do {
                    System.out.println("[1] Proceed [2] Edit");
                    int choice5 = scan.nextInt();
                    while (choice5 == 2) {
                        if (choice5 == 2) {
                            System.out.println("Which Data Column? [1] Lower Cl [2] Upper CL [3] Frequency");
                            int data = scan.nextInt();
                            System.out.println("Input the index: ");
                            int inde = scan.nextInt();
                            System.out.println("Input the replacement value: ");
                            double val = scan.nextDouble();

                            if (data == 1) {
                                lowerCL.set(inde - 1, val);
                            } else if (data == 2) {
                                upperCL.set(inde - 1, val);
                            } else if (data == 3) {
                                frequency.set(inde - 1, val);
                            }

                            display.display2(lowerCL,upperCL,frequency,choice4, desc);
                            System.out.println("\n[1] Proceed [2] Edit");
                            choice5 = scan.nextInt();
                        }
                    }

                    MD = md.getM(lowerCL, upperCL);
                    //System.out.println(MD);
                    FX = md.getFX(frequency, MD);
                    //System.out.println(FX);
                    FX2 = md.getFX2(frequency, MD);
                    //System.out.println(FX2);

                    ProcessTwo dothis2 = new ProcessTwo();
                    dothis2.DoThis(frequency, MD, FX, FX2, upperCL, lowerCL);
                    display.display3(lowerCL,upperCL,frequency,choice4, desc, MD,FX,FX2);

                    System.out.println("\n\nEdit data and compute again [1] Yes [2] No");
                    int cc = scan.nextInt();
                    if(cc == 2){continues = false;}

                }while (continues);

            } else if (choice4 == 1){

                System.out.println("Input Lower Class Limit:");
                for (int i = 0; i < CI;) {
                    try{

                        if(i != 0) {
                            System.out.print("[" + (i + 1) + "] ");
                            lowerCL.add(scan.nextDouble());
                            i++;
                        } else {
                            lowerCL.add(0.00);
                            i++;
                        }
                    }catch(Exception e){
                        System.out.println("Invalid");
                        scan.next();
                    }
                }

                System.out.println("Input Upper Class Limit: ");
                for (int i = 0; i < CI;) {
                    try{
                        if(i != 0) {
                            System.out.print("[" + (i + 1) + "] ");
                            upperCL.add(scan.nextDouble());
                            i++;
                        } else {
                            upperCL.add(0.00);
                            i++;
                        }
                    }catch(Exception e){
                        System.out.println("Invalid");
                        scan.next();
                    }
                }

                System.out.println("Input Frequency column: ");
                for (int i = 0; i < CI;) {
                    try{
                        System.out.print("[" + (i + 1) + "] ");
                        frequency.add(scan.nextDouble());
                        i++;
                    }catch(Exception e){
                        System.out.println("Invalid");
                        scan.next();
                    }
                }

                display.display2(lowerCL,upperCL,frequency,choice4, desc);

                Boolean continues = true;
                do {
                    System.out.println("[1] Proceed [2] Edit");
                    int choice5 = scan.nextInt();
                    int inde = 0;
                    while (choice5 == 2) {
                        if (choice5 == 2) {
                            System.out.println("Which Data Column? [1] Lower Cl [2] Upper CL [3] Frequency");
                            int data = scan.nextInt();
                            System.out.println("Input the index: ");
                            inde = scan.nextInt();
                            boolean stop = false;
                            while (!stop) {
                                if (inde != 1) {
                                    stop = true;
                                } else {
                                    System.out.println("Input the index: ");
                                    inde = scan.nextInt();
                                }
                            }

                            System.out.println("Input the replacement value: ");
                            double val = scan.nextDouble();

                            if (data == 1) {
                                lowerCL.set(inde - 1, val);
                            } else if (data == 2) {
                                upperCL.set(inde - 1, val);
                            } else if (data == 3) {
                                frequency.set(inde - 1, val);
                            }

                            display.display2(lowerCL,upperCL,frequency,choice4, desc);
                            System.out.println("\n[1] Proceed [2] Edit");
                            choice5 = scan.nextInt();
                        }
                    }

                    ProcessTwo dothis2 = new ProcessTwo();
                    dothis2.DoThis2(frequency, MD, FX, FX2, upperCL, lowerCL);
                    display.display3(lowerCL,upperCL,frequency,choice4, desc, MD,FX,FX2);

                    System.out.println("\n\nEdit data and compute again [1] Yes [2] No");
                    int cc = scan.nextInt();
                    if(cc == 2){continues = false;}

                }while (continues);

            } else if (choice4 == 2){
                System.out.println("Input Lower Class Limit:");
                for (int i = 0; i < CI;) {
                    try{

                        if(i != CI-1) {
                            System.out.print("[" + (i + 1) + "] ");
                            lowerCL.add(scan.nextDouble());
                            i++;
                        } else {
                            lowerCL.add(0.00);
                            i++;
                        }
                    }catch(Exception e){
                        System.out.println("Invalid");
                        scan.next();
                    }
                }

                System.out.println("Input Upper Class Limit: ");
                for (int i = 0; i < CI;) {
                    try{
                        if(i !=  CI-1) {
                            System.out.print("[" + (i + 1) + "] ");
                            upperCL.add(scan.nextDouble());
                            i++;
                        } else {
                            upperCL.add(0.00);
                            i++;
                        }
                    }catch(Exception e){
                        System.out.println("Invalid");
                        scan.next();
                    }
                }

                System.out.println("Input Frequency column: ");
                for (int i = 0; i < CI;) {
                    try{
                        System.out.print("[" + (i + 1) + "] ");
                        frequency.add(scan.nextDouble());
                        i++;
                    }catch(Exception e){
                        System.out.println("Invalid");
                        scan.next();
                    }
                }

                display.display2(lowerCL,upperCL,frequency,choice4, desc);

                Boolean continues = true;
                do {
                    System.out.println("[1] Proceed [2] Edit");
                    int choice5 = scan.nextInt();
                    int inde = 0;
                    while (choice5 == 2) {
                        if (choice5 == 2) {
                            System.out.println("Which Data Column? [1] Lower Cl [2] Upper CL [3] Frequency");
                            int data = scan.nextInt();
                            System.out.println("Input the index: ");
                            inde = scan.nextInt();
                            boolean stop = false;
                            while (!stop) {
                                if (inde != CI) {
                                    stop = true;
                                } else {
                                    System.out.println("Input the index: ");
                                    inde = scan.nextInt();
                                }
                            }
                            System.out.println("Input the replacement value: ");
                            double val = scan.nextDouble();

                            if (data == 1) {
                                lowerCL.set(inde - 1, val);
                            } else if (data == 2) {
                                upperCL.set(inde - 1, val);
                            } else if (data == 3) {
                                frequency.set(inde - 1, val);
                            }

                            display.display2(lowerCL,upperCL,frequency,choice4, desc);
                            System.out.println("\n[1] Proceed [2] Edit");
                            choice5 = scan.nextInt();
                        }
                    }

                    ProcessTwo dothis3 = new ProcessTwo();
                    dothis3.DoThis2(frequency, MD, FX, FX2, upperCL, lowerCL);
                    display.display3(lowerCL,upperCL,frequency,choice4, desc, MD,FX,FX2);

                    System.out.println("\n\nEdit data and compute again [1] Yes [2] No");
                    int cc = scan.nextInt();
                    if(cc == 2){continues = false;}

                }while (continues);

            } else if(choice4 == 3){
                System.out.println("Input Lower Class Limit:");
                for (int i = 0; i < CI;) {
                    try{

                        if(i != 0 && i != CI-1) {
                            System.out.print("[" + (i + 1) + "] ");
                            lowerCL.add(scan.nextDouble());
                            i++;
                        } else {
                            lowerCL.add(0.00);
                            i++;
                        }
                    }catch(Exception e){
                        System.out.println("Invalid");
                        scan.next();
                    }
                }

                System.out.println("Input Upper Class Limit: ");
                for (int i = 0; i < CI;) {
                    try{
                        if(i != 0 && i != CI-1) {
                            System.out.print("[" + (i + 1) + "] ");
                            upperCL.add(scan.nextDouble());
                            i++;
                        } else {
                            upperCL.add(0.00);
                            i++;
                        }
                    }catch(Exception e){
                        System.out.println("Invalid");
                        scan.next();
                    }
                }

                System.out.println("Input Frequency column: ");
                for (int i = 0; i < CI;) {
                    try{
                        System.out.print("[" + (i + 1) + "] ");
                        frequency.add(scan.nextDouble());
                        i++;
                    }catch(Exception e){
                        System.out.println("Invalid");
                        scan.next();
                    }
                }

                display.display2(lowerCL,upperCL,frequency,choice4, desc);
                Boolean continues = true;
                do {
                    System.out.println("[1] Proceed [2] Edit");
                    int choice5 = scan.nextInt();
                    int inde = 0;
                    while (choice5 == 2) {
                        if (choice5 == 2) {
                            System.out.println("Which Data Column? [1] Lower Cl [2] Upper CL [3] Frequency");
                            int data = scan.nextInt();
                            System.out.println("Input the index: ");
                            inde = scan.nextInt();
                            boolean stop = false;
                            while (!stop) {
                                if (inde != 1 && inde != CI) {
                                    stop = true;
                                } else {
                                    System.out.println("Input the index: ");
                                    inde = scan.nextInt();
                                }
                            }

                            System.out.println("Input the replacement value: ");
                            double val = scan.nextDouble();

                            if (data == 1) {
                                lowerCL.set(inde - 1, val);
                            } else if (data == 2) {
                                upperCL.set(inde - 1, val);
                            } else if (data == 3) {
                                frequency.set(inde - 1, val);
                            }

                            display.display2(lowerCL,upperCL,frequency,choice4, desc);
                            System.out.println("\n[1] Proceed [2] Edit");
                            choice5 = scan.nextInt();
                        }
                    }


                    ProcessTwo dothis2 = new ProcessTwo();
                    dothis2.DoThis2(frequency, MD, FX, FX2, upperCL, lowerCL);
                    display.display3(lowerCL,upperCL,frequency,choice4, desc, MD,FX,FX2);

                    System.out.println("\n\nEdit data and compute again [1] Yes [2] No");
                    int cc = scan.nextInt();
                    if(cc == 2){continues = false;}

                }while (continues);

            }
            main(args);
        }else if(choice ==3){
            System.exit(0);
        }
    }
}