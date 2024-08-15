package org.firstinspires.ftc.teamcode.MMLib.Examples.TeleOps;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.CuttlefishFTCBridge.src.devices.MMServo;
import org.firstinspires.ftc.teamcode.MMLib.MMTeleOp;
import org.firstinspires.ftc.teamcode.MMLib.Utils.MMUtils;
import org.firstinspires.ftc.teamcode.MMRobot;

@TeleOp
public class Mapping extends MMTeleOp {

    public Mapping() {
        super(false);
    }

    MMRobot mmRobot = MMRobot.getInstance();

    MMServo servo;

    @Override
    public void main() {

        servo = mmRobot.mmSystems.controlHub.getServo(0);

        mmRobot.mmSystems.gamepadEx1.getGamepadButton(GamepadKeys.Button.A).whileActiveOnce(
                new CommandBase() {
                    @Override
                    public void execute() {
                        servo.setPosition(
                                MMUtils.joystickToServo(
                                        mmRobot.mmSystems.gamepadEx1.getLeftX()
                                )
                        );
                    }
                }
        );

    }
}