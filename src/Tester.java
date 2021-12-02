import DayOne.SonarThreeCheck;
import DayOne.SonarUpDown;
import DayTwo.PositionPlusAim;
import DayTwo.PositionUpdater;

import java.io.File;

public class Tester {

    public static void main(String[] args) {
//        SonarUpDown upOrDown = new SonarUpDown(new File("src/DayOne/depths.txt"));
//        SonarThreeCheck upDown2 = new SonarThreeCheck(new File("src/DayOne/depths.txt"));
//        System.out.println(upOrDown.numOfChanges(true));
//        System.out.println(upDown2.numOfChanges(true));

        PositionUpdater positionUpdater1 = new PositionUpdater(new File("src/DayTwo/inputs.txt"));
        System.out.println(positionUpdater1.distanceAway());
        PositionPlusAim positionUpdater2 = new PositionPlusAim(new File("src/DayTwo/inputs.txt"));
        System.out.println(positionUpdater2.distanceAway());
    }
}
