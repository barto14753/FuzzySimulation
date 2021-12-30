package com.company;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import java.util.Arrays;

public class FuzzyExample {

    public static void main(String[] args) throws Exception {
        try {
            // String fileName = args[0];
            // int poziomNatezenia = Integer.parseInt(args[1]);
            // int poraDnia = Integer.parseInt(args[2]);

            String fileName = "/Users/bartoszwlodarski/FuzzySimulation/src/com/company/fuzzy_volume.fcl";
            int poziomNatezenia = 10;
            int poraDnia = 13;

            FIS fis = FIS.load(fileName, false);

            // zadaj wartosci wejsciowe
            fis.setVariable("poziom_natezenia", poziomNatezenia);
            fis.setVariable("pora_dnia", poraDnia);
            //JFuzzyChart.get().chart(fis);
            // logika sterownika
            fis.evaluate();

            // graficzna prezentacja wyjscia
            Variable v = fis.getVariable("zmiana_natezenia");
            System.out.println(v.toString());
            System.out.println(v.getMembershipFunction("zostaw").membership(v.getValue()));
            //JFuzzyChart.get().chart(v, v.getDefuzzifier(), true);




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
