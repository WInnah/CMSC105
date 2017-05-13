import java.util.ArrayList;

/**
 * Created by the tutees on 4/30/2017.
 */
public class Display {

    void display1(ArrayList<Double> doubleframe, ArrayList<Integer> intergerframe, int type, String Desc){
        System.out.println("\n");
        System.out.println(Desc);
        if(type == 1){
            int ct = 0;
            for(int z = 0 ; z < intergerframe.size(); z++){
                if(ct == 5){
                    System.out.println("\n");
                    ct = 0;
                }
                System.out.print("["+(z+1)+"]"+intergerframe.get(z)+"  ");
                ct++;
            }
        }  else {
            int ct = 0;
            for(int z = 0 ; z < intergerframe.size(); z++){
                if(ct == 5){
                    System.out.println("\n");
                    ct = 0;
                }
                System.out.print(doubleframe.get(z) + "  ");
                ct++;

            }

        }

    }

    void display2(ArrayList<Double> lower, ArrayList<Double> upper, ArrayList<Double> freq, int choice, String Desc){
        System.out.println("\n");
        System.out.println(Desc);
        if(choice == 1 ){
            System.out.println("LCL - UCL \t Frequency ");
            for(int i = 0; i < lower.size(); i++){
                if(i == 0){
                    System.out.println("<= "+lower.get(i+1)+" \t\t "+ freq.get(i));
                } else {
                    System.out.println(lower.get(i) + " - " + upper.get(i) + " \t " + freq.get(i));
                }
            }

        } else if (choice == 2){
            System.out.println("LCL - UCL \t Frequency ");
            for(int i = 0; i < lower.size(); i++){
                if(i == lower.size()-1){
                    System.out.println(">= "+upper.get((lower.size()-1)-1)+" \t\t "+ freq.get(i));
                } else {
                    System.out.println(lower.get(i) + " - " + upper.get(i) + " \t " + freq.get(i));
                }
            }

        }else if(choice == 3){
            System.out.println("LCL - UCL \t Frequency ");
            for(int i = 0; i < lower.size(); i++){

                if(i == 0){
                    System.out.println("<= "+lower.get(i+1)+" \t\t "+ freq.get(i));
                }else if(i == lower.size()-1){
                    System.out.println(">= "+upper.get((lower.size()-1)-1)+" \t\t "+ freq.get(i));
                } else {
                    System.out.println(lower.get(i) + " - " + upper.get(i) + " \t " + freq.get(i));
                }
            }

        } else if (choice == 4){
            System.out.println("LCL - UCL \t Frequency ");
            for(int i = 0; i < lower.size(); i++){
                System.out.println(lower.get(i)+" - "+upper.get(i)+" \t "+ freq.get(i));
            }
        }

    }

    void display3 (ArrayList<Double> lower, ArrayList<Double> upper, ArrayList<Double> freq, int choice, String Desc,ArrayList<Double> MD, ArrayList<Double> FX, ArrayList<Double> FX2 ){
        System.out.println("\n");
        System.out.println(Desc);
        if(choice == 1 ){
            System.out.println("LCL - UCL \t Frequency \t MD \t FX \t FX2");
            for(int i = 0; i < lower.size(); i++){
                if(i == 0){
                    System.out.println("<= "+lower.get(i+1)+" \t\t "+ freq.get(i)+" \t "+" - "+" \t "+" - \t - ");
                } else {
                    System.out.println(lower.get(i) + " - " + upper.get(i) + " \t " +freq.get(i)+" \t "+" - "+" \t "+" - \t - ");
                }
            }

        } else if (choice == 2){
            System.out.println("LCL - UCL \t Frequency \t MD \t FX \t FX2 ");
            for(int i = 0; i < lower.size(); i++){
                if(i == lower.size()-1){
                    System.out.println(">= "+upper.get((lower.size()-1)-1)+" \t\t "+ freq.get(i)+" \t "+" - "+" \t "+" - \t - ");
                } else {
                    System.out.println(lower.get(i) + " - " + upper.get(i) + " \t " + freq.get(i)+" \t "+" - "+" \t "+" - \t - ");
                }
            }

        }else if(choice == 3){
            System.out.println("LCL - UCL \t Frequency \t MD \t FX \t FX2");
            for(int i = 0; i < lower.size(); i++){

                if(i == 0){
                    System.out.println("<= "+lower.get(i+1)+" \t\t "+ freq.get(i)+" \t "+" - "+" \t "+" - \t - ");
                }else if(i == lower.size()-1){
                    System.out.println(">= "+upper.get((lower.size()-1)-1)+" \t\t "+ freq.get(i)+" \t "+" - "+" \t "+" - \t - ");
                } else {
                    System.out.println(lower.get(i) + " - " + upper.get(i) + " \t " + freq.get(i)+" \t "+" - "+" \t "+" - \t - ");
                }
            }

        } else if (choice == 4){
            System.out.println("LCL - UCL \t Frequency \t MD \t FX \t FX2");
            for(int i = 0; i < lower.size(); i++){
                System.out.println(lower.get(i)+" - "+upper.get(i)+" \t "+ freq.get(i)+" \t "+MD.get(i)+" \t "+FX.get(i)+" \t "+ FX2.get(i));
            }
        }
    }
}

//+" \t "+MD.get(i)+" \t "+FX.get(i)+" \t "+ FX2.get(i)