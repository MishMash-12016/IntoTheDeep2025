package org.firstinspires.ftc.teamcode.MMLib;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;

public class MMBattery {

    private final VoltageSensor battery;

    public MMBattery(HardwareMap hardwareMap) {
        this.battery = hardwareMap.voltageSensor.iterator().next();
    }

    public double getVoltage() {
        return battery.getVoltage();
    }

}
