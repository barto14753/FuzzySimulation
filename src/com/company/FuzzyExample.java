package com.company;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import java.util.Arrays;

public class FuzzyExample {

    public static void main(String[] args) throws Exception {
        try {
            // String fileName = args[0];
            // int poziomNatezenia = Integer.parseInt(args[1]);
            // int poraDnia = Integer.parseInt(args[2]);

            String fileName = "/Users/bartoszwlodarski/FuzzySimulation/src/com/company/fuzzy_move.fcl";
            int car_position = 300;
            int first_car_position = 0;
            int second_car_position = 0;

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
                    .println("Niepoprawna liczba parametrow. Przyklad: java FuzzyExample string<plik_fcl> int<poziom natezenia> int<pora dnia>");
        } catch (NumberFormatException ex) {
            System.out
                    .println("Niepoprawny parametr. Przyklad: java FuzzyExample string<plik_fcl> int<poziom natezenia> int<pora dnia>");
        } catch (Exception ex) {
            System.out.println(ex.toString());
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
    }

}
