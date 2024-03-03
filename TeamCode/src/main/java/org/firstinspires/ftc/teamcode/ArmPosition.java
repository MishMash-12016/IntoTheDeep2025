package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.SubSystems.Extender;

public enum ArmPosition {

    /*
    clusters- each cluster is a group containing multiple positions that


    Assuming the robot is in the right selectedRobotSide of the board:

          far  close
           |      |
           v      v
     isSelectedScoreSideLeft     isSelectedScoreSideLeft      isSelectedScoreSideLeft  <- top
     isSelectedScoreSideLeft     isSelectedScoreSideLeft      isSelectedScoreSideLeft  <- mid
     isSelectedScoreSideLeft     isSelectedScoreSideLeft      isSelectedScoreSideLeft  <- bottom

     Robot's on the left selectedRobotSide:

   close  far
     |     |
     v     v
     isSelectedScoreSideLeft     isSelectedScoreSideLeft      isSelectedScoreSideLeft  <- top
     isSelectedScoreSideLeft     isSelectedScoreSideLeft      isSelectedScoreSideLeft  <- mid
     isSelectedScoreSideLeft     isSelectedScoreSideLeft      isSelectedScoreSideLeft  <- bottom

    Robot's on the front of the board:

         front
           |
           v
     isSelectedScoreSideLeft     isSelectedScoreSideLeft      isSelectedScoreSideLeft  <- top
     isSelectedScoreSideLeft     isSelectedScoreSideLeft      isSelectedScoreSideLeft  <- mid
     isSelectedScoreSideLeft     isSelectedScoreSideLeft      isSelectedScoreSideLeft  <- bottom

     */

    SCORE_TOP_FAR(34.1, Extender.Position.MID_WAY, 41.443, 0.42, 0.9, Cluster.scoring), //Can't physically reach this
    SCORE_TOP_FRONT(29.361, Extender.Position.OPEN, 0, 0.47, 0.7, Cluster.scoring),
    SCORE_TOP_CLOSE(34.1, Extender.Position.MID_WAY, 41.443, 0.42, 0.9, Cluster.scoring),
    SCORE_MID_FAR(22.346, Extender.Position.MID_WAY, 45, 0.336, 1, Cluster.scoring),
    SCORE_MID_FRONT(27.464, Extender.Position.OPEN, 0, 0.405, 0.7, Cluster.scoring),
    SCORE_MID_CLOSE(22.35, Extender.Position.CLOSED, 40, 0.336, 0.8, Cluster.scoring),
    SCORE_BOTTOM_FAR(12.59, Extender.Position.MID_WAY, 55, 0.336, 0.9, Cluster.scoring),
    SCORE_BOTTOM_FRONT(15.48, Extender.Position.MID_WAY, 0, 0.34, 0.7, Cluster.scoring),
    SCORE_AUTO_BOTTOM_FAR_2(18.714 + 10, Extender.Position.OPEN, 60, 0.336, 1, Cluster.scoring),
    SCORE_AUTO_BOTTOM_FAR(18.714, Extender.Position.OPEN, 60, 0.336, 1, Cluster.scoring),
    SCORE_AUTO_BOTTOM_MID_2(17.59 + 10, Extender.Position.MID_WAY, 60, 0.336, 1, Cluster.scoring),
    SCORE_AUTO_BOTTOM_MID(17.59, Extender.Position.MID_WAY, 60, 0.336, 1, Cluster.scoring),
    SCORE_BOTTOM_CLOSE_2(12.34 + 10, Extender.Position.CLOSED, 55, 0.34, 0.9, Cluster.scoring),
    SCORE_BOTTOM_CLOSE(12.34, Extender.Position.CLOSED, 55, 0.34, 0.9, Cluster.scoring),
    INTAKE(0, Extender.Position.CLOSED, 0,0.02, 0.03, Cluster.intake),
    AUTO_INTAKE(0, Extender.Position.CLOSED, 0,0.02, 0.03, Cluster.intake),
    AUTONOMOUS_PURPLE_PIXEL(0, Extender.Position.CLOSED_INTAKE, 0, 0.25, 0, Cluster.intake),
    SAFE_PLACE(13, Extender.Position.CLOSED,0,0.45, 0.03, Cluster.intake),
    SCORING(13.5, Extender.Position.CLOSED, 90, 0.45, 0, Cluster.scoring),
    SCORING_AUTO(13.5, Extender.Position.CLOSED, 110, 0.45, 0, Cluster.scoring);/*,
    //Autonomous
    SCORE_AUTONOMOUS_CLOSE(),
    SCORE_AUTONOMOUS_FAR(),
    SCORE_AUTONOMOUS_FRONT()*/

    private final double elevatorHeight;
    private final Extender.Position extenderPosition;
    private final double turretAngle;
    private final double elbowPosition;
    private final double antiTurretPosition;
    private final Cluster cluster;

    private enum Cluster{
        intake,
        scoring
    }
    ArmPosition(double elevatorHeight, Extender.Position extenderPosition, double turretAngle, double elbowPosition, double antiTurretPosition, Cluster cluster) {
        this.elevatorHeight = elevatorHeight;
        this.elbowPosition = elbowPosition;
        this.turretAngle = turretAngle;
        this.extenderPosition = extenderPosition;
        this.antiTurretPosition = antiTurretPosition;
        this.cluster = cluster;
    }

    public double getElevatorHeight() {
        return elevatorHeight;
    }

    public Extender.Position getExtenderPosition() {
        return extenderPosition;
    }

    public double getTurretAngle(boolean isLeftOfBoard) {
        return turretAngle * (isLeftOfBoard ? -1 : 1);
    }

    public double getElbowPosition() {
        return elbowPosition;
    }
    public double getAntiTurretPosition() {
        return antiTurretPosition;
    }

    public Cluster getCluster(){
        return cluster;
    }
}

