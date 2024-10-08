package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.MMRobot;
import org.firstinspires.ftc.teamcode.SubSystems.RollerIntake;

public class IntakeByToggle extends CommandBase {
    RollerIntake intake = MMRobot.getInstance().mmSystems.rollerIntake;

    public IntakeByToggle() {
        this.addRequirements(intake);
    }

    @Override
    public void initialize() {
        if (intake.isRoll) {
            intake.setPower(0);
            intake.setIsRoll(false);
        } else {
            intake.setPower(1);
            intake.setIsRoll(true);
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
