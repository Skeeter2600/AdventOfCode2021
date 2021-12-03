package DayThree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BinaryElimination {

    private final List<String> values;

    /**
     * This class is used to find the most and least common value
     * for all binary values and use that to multiply for the result
     *
     * @param file the file with all binary values
     */
    public BinaryElimination(File file){
        this.values = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                values.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This function will get all values with the most pr least used binary
     * values in all of its locations compared to all other inputs
     *
     * @return the product of the least and most common results
     */
    public int processInfo(){
        List<String> currentPosValues = values;
        int index = 0;

        while (currentPosValues.size() > 1) {
            List<String> zeros = new ArrayList<>();
            List<String> ones = new ArrayList<>();
            float checkValue = 0;
            for (String checker : currentPosValues) {
                if (checker.charAt(index) == '1'){
                    ones.add(checker);
                    checkValue++;
                }
                else zeros.add(checker);
            }
            if ((checkValue/currentPosValues.size()) >= .5) currentPosValues = ones;
            else currentPosValues = zeros;

            index++;
        }

        List<String> currentNegValues = values;
        int NegIndex = 0;

        while (currentNegValues.size() > 1) {
            List<String> zeros = new ArrayList<>();
            List<String> ones = new ArrayList<>();
            float checkValue = 0;
            for (String checker : currentNegValues) {
                if (checker.charAt(NegIndex) == '1'){
                    ones.add(checker);
                    checkValue++;
                }
                else zeros.add(checker);
            }
            if ((checkValue/currentNegValues.size()) < .5) currentNegValues = ones;
            else currentNegValues = zeros;

            NegIndex++;
        }

        int currentPosValueInt = Integer.parseInt(currentPosValues.get(0),2);
        int currentNegValueInt = Integer.parseInt(currentNegValues.get(0),2);
        return currentNegValueInt * currentPosValueInt;
    }
}
