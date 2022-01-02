package com.company;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class FuzzyLogic {
    private static final String fileName = "/Users/bartoszwlodarski/FuzzySimulation/src/com/company/fuzzy_move.fcl";
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
}
