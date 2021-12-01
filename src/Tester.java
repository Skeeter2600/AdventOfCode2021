import DayOne.SonarThreeCheck;
import DayOne.SonarUpDown;

import java.io.File;

public class Tester {

    public static void main(String[] args) {
        SonarUpDown upOrDown = new SonarUpDown(new File("src/DayOne/depths.txt"));
        SonarThreeCheck upDown2 = new SonarThreeCheck(new File("src/DayOne/depths.txt"));
        System.out.println(upOrDown.numOfChanges(true));
        System.out.println(upDown2.numOfChanges(true));
    }
}
