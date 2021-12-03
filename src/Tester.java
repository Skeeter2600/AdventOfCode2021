import DayOne.SonarThreeCheck;
import DayOne.SonarUpDown;
import DayThree.BinaryDiagnostic;
import DayThree.BinaryElimination;
import DayTwo.PositionPlusAim;
import DayTwo.PositionUpdater;

import java.io.File;

public class Tester {

    public static void main(String[] args) {
//        SonarUpDown upOrDown = new SonarUpDown(new File("src/DayOne/depths.txt"));
//        SonarThreeCheck upDown2 = new SonarThreeCheck(new File("src/DayOne/depths.txt"));
//        System.out.println(upOrDown.numOfChanges(true));
//        System.out.println(upDown2.numOfChanges(true));

//        PositionUpdater positionUpdater1 = new PositionUpdater(new File("src/DayTwo/inputs.txt"));
//        System.out.println(positionUpdater1.distanceAway());
//        PositionPlusAim positionUpdater2 = new PositionPlusAim(new File("src/DayTwo/inputs.txt"));
//        System.out.println(positionUpdater2.distanceAway());

        BinaryDiagnostic binaryDiagnostic = new BinaryDiagnostic(new File("src/DayThree/inputs.txt"));
        System.out.println(binaryDiagnostic.processInfo());
        BinaryElimination binaryElimination = new BinaryElimination(new File("src/DayThree/inputs.txt"));
        System.out.println(binaryElimination.processInfo());
    }
}
