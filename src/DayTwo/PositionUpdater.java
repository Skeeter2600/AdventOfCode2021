package DayTwo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PositionUpdater {

    private final List<Integer> distance;
    private final List<String> direction;

    public PositionUpdater(File file) {
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
        int forward = 0;
        int depth = 0;
        int tracker = 0;

        for (String value : direction){
            if (value.equals("forward")) forward += distance.get(tracker);
            else if (value.equals("down")) depth += distance.get(tracker);
            else depth -= distance.get(tracker);
            tracker++;
        }

        return forward * depth;
    }
}
