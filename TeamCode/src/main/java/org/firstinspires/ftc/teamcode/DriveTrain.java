package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class DriveTrain{
    public DcMotor frontLeft, frontRight, backLeft, backRight;
    public DriveTrain(DcMotor fl, DcMotor fr, DcMotor bl, DcMotor br){
        fl = frontLeft;
        fr = frontRight;
        bl = backLeft;
        br = backRight;

    }

    public void driveForward(double power, double distance, Telemetry telemetry) throws InterruptedException {
    double rotations;
    int targetPosition;
    boolean isBusy;
    int i = 0;
     frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    rotations= (distance/(4*Math.PI));
    targetPosition = (int)(rotations*1120);

        frontRight.setTargetPosition(targetPosition);
        backRight.setTargetPosition(targetPosition);
        frontLeft.setTargetPosition(-targetPosition);
        frontLeft.setTargetPosition(-targetPosition);

        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);


        if (frontLeft.isBusy() && frontLeft.isBusy() && backLeft.isBusy() && backRight.isBusy()){
        isBusy = true;
    } else{
        isBusy = false;
    }

        while((frontLeft.isBusy() && frontLeft.isBusy() && backLeft.isBusy() && backRight.isBusy()) && i < 500) {
        telemetry.update();
        i++;
        Thread.sleep(1);
        }
    }
}
