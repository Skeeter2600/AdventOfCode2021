package DayOne;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SonarThreeCheck {

    private final List<Integer> depths;

    public SonarThreeCheck(File file) {
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
        int previous1 = -1;
        int previous2 = -2;
        int previous3 = -3;

        for (int value : depths){
            if (previous3 > 0){
                int previousTotal = previous1 + previous2 + previous3;
                int currentTotal = value + previous1 + previous2;
                if (((currentTotal - previousTotal) > 0) == upOrDown ) changes++;
            }
            previous3 = previous2;
            previous2 = previous1;
            previous1 = value;
        }

        return changes;
    }

}
