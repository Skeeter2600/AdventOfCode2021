package DayOne;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SonarUpDown {

    private final List<Integer> depths;

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

    public int numOfChanges(boolean upOrDown){
        int changes = 0;
        int previous = -1;

        for (int value : depths){
            if (previous != -1){
                if (((value - previous) > 0) == upOrDown ) changes++;
            }
            previous = value;
        }

        return changes;
    }

}
