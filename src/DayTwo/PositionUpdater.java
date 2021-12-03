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

    /**
     * This class is used to determine the distance traveled
     * using a file of movements
     *
     * @param file the file that contains the movements and distance
     */
    public PositionUpdater(File file) {
        this.distance = new ArrayList<>();
        this.direction = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");  // break the direction and distance
                direction.add(values[0]);
                distance.add(Integer.valueOf(values[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This function will go through the list of directions and distances
     * and generate the horizontal and vertical distance to get the total
     *
     * @return the total distanced moved from start
     */
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
