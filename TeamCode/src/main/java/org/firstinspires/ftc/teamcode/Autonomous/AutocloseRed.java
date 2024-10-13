package org.firstinspires.ftc.teamcode.Autonomous;

//RR imports
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;

// non RR imports
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.Libraries.RoadRunner.MecanumDrive;


@Config
@Autonomous(name = "AutocloseRed", group = "Autonomous")
public class AutocloseRed extends CommandOpMode {

    Action traj;



    @Override
    public void initialize() {


        Pose2d initialPose = new Pose2d(-18.8, -63.75, Math.toRadians(90.00))   ;
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);

         traj = drive.actionBuilder(initialPose)

                .turn(Math.toRadians(90))
                .lineToX(-50.93)
                .setTangent(Math.toRadians(180))
                .splineToConstantHeading(new Vector2d(-59.39 , -38.12) , Math.toRadians(90.00))
                 .splineToConstantHeading(new Vector2d(-58.25 , -56.09), Math.toRadians(225.00))
                .build();

    }

    @Override
    public void run() {

        super.run();

        Actions.runBlocking(
                traj
        );

    }
}

