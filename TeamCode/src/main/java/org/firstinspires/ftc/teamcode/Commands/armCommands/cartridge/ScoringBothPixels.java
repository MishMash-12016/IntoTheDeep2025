package org.firstinspires.ftc.teamcode.Commands.armCommands.cartridge;

import com.arcrobotics.ftclib.command.ConditionalCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitUntilCommand;

import org.firstinspires.ftc.teamcode.ArmPosition;
import org.firstinspires.ftc.teamcode.ArmPositionSelector;
import org.firstinspires.ftc.teamcode.Commands.armCommands.multiSystem.ArmGetToPosition;
import org.firstinspires.ftc.teamcode.RobotControl;
import org.firstinspires.ftc.teamcode.SubSystems.AntiTurret;
import org.firstinspires.ftc.teamcode.SubSystems.Cartridge;
import org.firstinspires.ftc.teamcode.SubSystems.Elbow;
import org.firstinspires.ftc.teamcode.SubSystems.Elevator;
import org.firstinspires.ftc.teamcode.SubSystems.Extender;
import org.firstinspires.ftc.teamcode.SubSystems.Turret;

import java.util.function.BooleanSupplier;

public class ScoringBothPixels extends SequentialCommandGroup {
    public ScoringBothPixels(RobotControl robot, BooleanSupplier triggerCondition) {
        super(
                new CartridgeSetState(robot.cartridge, Cartridge.State.OPEN),
                new WaitUntilCommand(() -> !triggerCondition.getAsBoolean()),
                new CartridgeSetState(robot.cartridge, Cartridge.State.CLOSED),
                new ConditionalCommand(
                        new ArmGetToPosition(robot, ArmPosition.SCORING, true),
                        new ArmGetToPosition(robot, ArmPosition.SCORING, false),
                        ArmPositionSelector::getIsLeftOfBoard
                )
        );
    }
}
