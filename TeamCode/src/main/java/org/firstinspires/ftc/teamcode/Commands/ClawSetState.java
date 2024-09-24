package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.SubSystems.Claw;

public class ClawSetState extends InstantCommand {

    public ClawSetState(Claw claw, Claw.State state){
        super(()-> claw.setPosition(state.position));
    }

}