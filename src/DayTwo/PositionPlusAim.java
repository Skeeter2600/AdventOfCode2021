package DayTwo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PositionPlusAim {
    private final List<Integer> distance;
    private final List<String> direction;

    public PositionPlusAim(File file) {
        this.distance = new ArrayList<>();
        this.direction = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                direction.add(values[0]);
                distance.add(Integer.valueOf(values[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int distanceAway(){
        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        int tracker = 0;

        for (String value : direction){
            int x = distance.get(tracker);
            if (value.equals("forward")) {
                horizontal += x;
                depth += (x * aim);
            }
            else if (value.equals("down")) {
                aim += x;
            }
            else {
                aim -= x;
            }
            tracker++;
        }

        return horizontal * depth;
    }
}
