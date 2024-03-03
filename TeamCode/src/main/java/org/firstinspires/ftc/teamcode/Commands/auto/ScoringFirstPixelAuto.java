package org.firstinspires.ftc.teamcode.Commands.auto;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.ArmPosition;
import org.firstinspires.ftc.teamcode.Commands.armCommands.cartridge.CartridgeSetState;
import org.firstinspires.ftc.teamcode.Commands.armCommands.multiSystem.ArmGetToPosition;
import org.firstinspires.ftc.teamcode.Commands.intakeRoller.IntakeRotate;
import org.firstinspires.ftc.teamcode.Commands.intakeRoller.ResetPixelCount;
import org.firstinspires.ftc.teamcode.Commands.utilCommands.DetectionSideCommandSwitch;
import org.firstinspires.ftc.teamcode.RobotControl;
import org.firstinspires.ftc.teamcode.SubSystems.Cartridge;
import org.firstinspires.ftc.teamcode.Utils.AllianceColor;

public class ScoringFirstPixelAuto extends SequentialCommandGroup {
    public ScoringFirstPixelAuto(RobotControl robot) {
        addCommands(
                new ScoringCommand(robot, getScoringCommand(robot), getSecondScoringCommand(robot))
        );
    }
    private Command getSecondScoringCommand(RobotControl robot) {
        return new DetectionSideCommandSwitch(
                new ArmGetToPosition(robot, ArmPosition.SCORE_BOTTOM_CLOSE_2, robot.allianceColor == AllianceColor.RED),
                new ArmGetToPosition(robot, ArmPosition.SCORE_AUTO_BOTTOM_MID_2, robot.allianceColor == AllianceColor.RED),
                new ArmGetToPosition(robot, ArmPosition.SCORE_AUTO_BOTTOM_FAR_2, robot.allianceColor == AllianceColor.RED),
                () -> robot.teamPropDetector.getTeamPropSide()
        );
    }
    private Command getScoringCommand(RobotControl robot) {
        return new DetectionSideCommandSwitch(
                new ArmGetToPosition(robot, ArmPosition.SCORE_BOTTOM_CLOSE, robot.allianceColor == AllianceColor.RED),
                new ArmGetToPosition(robot, ArmPosition.SCORE_AUTO_BOTTOM_MID, robot.allianceColor == AllianceColor.RED),
                new ArmGetToPosition(robot, ArmPosition.SCORE_AUTO_BOTTOM_FAR, robot.allianceColor == AllianceColor.RED),
                () -> robot.teamPropDetector.getTeamPropSide()
        );
    }

}
