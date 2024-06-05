package org.firstinspires.ftc.teamcode.Commands.driveTrain;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.SubSystems.DriveTrain;

public class DriveCommand extends CommandBase {
    private DriveTrain driveTrain;

    private Gamepad gamepad;

    public DriveCommand(DriveTrain driveTrain, Gamepad gamepad) {
        this.driveTrain = driveTrain;
        this.gamepad = gamepad;
        this.addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
        driveTrain.fieldOrientedDrive(gamepad.left_stick_x, -gamepad.left_stick_y, gamepad.right_stick_x);
    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.drive(0, 0, 0);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}