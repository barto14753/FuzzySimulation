package com.company;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import java.util.Arrays;

public class FuzzyLogic {
    private static final String fileName = "com/company/fuzzy_move.fcl";
    private static final FIS fis = FIS.load(fileName, false);

    public static int getMove(int car_position, int first_car_position, int second_car_position)
    {
        FIS fis = FIS.load(fileName, false);
        fis.setVariable("car_position", car_position);
        fis.setVariable("first_car_position", first_car_position);
        fis.setVariable("second_car_position", second_car_position);

        fis.evaluate();

        Variable v = fis.getVariable("move");
        System.out.println(car_position + " | " + first_car_position);
        System.out.println(v.toString());

        double turn_very_left = v.getMembershipFunction("turn_very_left").membership(v.getValue());
        double turn_left = v.getMembershipFunction("turn_left").membership(v.getValue());
        double keep = v.getMembershipFunction("keep").membership(v.getValue());
        double turn_right = v.getMembershipFunction("turn_right").membership(v.getValue());
        double turn_very_right = v.getMembershipFunction("turn_very_right").membership(v.getValue());
        if (turn_very_left > 0.0) return -10;
        else if (turn_left > 0.0) return -2;
        else if (turn_very_right > 0.0) return 10;
        else if (turn_right > 0.0) return 2;
        else return 0;

    }


    public static void main(String[] args) throws Exception {
        try {

            int car_position = Integer.parseInt(args[0]);
            int first_car_position = Integer.parseInt(args[1]);
            int second_car_position = Integer.parseInt(args[2]);


            FIS fis = FIS.load(fileName, false);

            // zadaj wartosci wejsciowe
            fis.setVariable("car_position", car_position);
            fis.setVariable("first_car_position", first_car_position);
            fis.setVariable("second_car_position", second_car_position);
            JFuzzyChart.get().chart(fis);
            // logika sterownika
            fis.evaluate();

            // graficzna prezentacja wyjscia
            Variable v = fis.getVariable("move");
            System.out.println(v.toString());
            System.out.println(v.getMembershipFunction("keep").membership(v.getValue()));
            JFuzzyChart.get().chart(v, v.getDefuzzifier(), true);




        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out
                    .println("Niepoprawna liczba parametrow. Przyklad: java FuzzyLogic int<car_position> int<first_car_position> int<second_car_position>");
        } catch (NumberFormatException ex) {
            System.out
                    .println("Niepoprawny parametr. Przyklad: java FuzzyLogic int<car_position> int<first_car_position> int<second_car_position>");
        } catch (Exception ex) {
            System.out.println(ex.toString());
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
    }

}
