package DayThree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BinaryDiagnostic {

    private final float[] columns;

    /**
     * This class is used to find the most and least common value
     * for all binary values and use that to multiply for the result
     *
     * @param file the file with all binary values
     */
    public BinaryDiagnostic(File file){
        this.columns = new float[12];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                int column = 0;
                for (char value : line.toCharArray()) {
                    if (value == '1') columns[column]++;
                    column++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This will take the values for each position and see which
     * vale was most common and least common and multiply the resulting
     * binary values
     *
     * @return the least * the most common values
     */
    public int processInfo(){
        StringBuilder returnValue = new StringBuilder();

        for (float value : columns){
            if ((value / 1000) > .5){
                returnValue.append("1");
            }
            else {
                returnValue.append("0");
            }
        }

        StringBuilder invert = new StringBuilder();

        for (char character : returnValue.toString().toCharArray()){
            if (character == '1') invert.append("0");
            else invert.append("1");
        }

        String invertString = invert.toString();
        int returnValueInt = Integer.parseInt(returnValue.toString(), 2);
        int invertInt = Integer.parseInt(invertString, 2);
        return returnValueInt * invertInt;
    }
}
