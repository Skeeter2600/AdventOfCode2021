package DayOne;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SonarUpDown {

    private final List<Integer> depths;

    /**
     * This class is used to how often a depth changes
     * @param file the file of depths to be made into a list
     */
    public SonarUpDown(File file) {
        this.depths = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                depths.add(Integer.valueOf(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This function will go through all depths and calculate the
     * number of increases or decreases based on input
     *
     * @param upOrDown true for increases and false for decreases
     *
     * @return the number of times the depth either increased
     *         or decreased
     */
    public int numOfChanges(boolean upOrDown){
        int changes = 0;
        int previous = -1;  // no depth will ever be negative after set

        for (int value : depths){
            if (previous != -1){
                if (((value - previous) > 0) == upOrDown ) changes++;
            }
            previous = value;
        }

        return changes;
    }

}
