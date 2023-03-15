package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class DriveTrain {
    public DcMotor frontLeft, frontRight, backLeft, backRight;
    public DriveTrain(DcMotor fl,DcMotor fr, DcMotor bl, DcMotor br){
        frontLeft = fl;
        frontRight = fr;
        backLeft = bl;
        backRight = br;
        }

    public void Drive(double Length, double Strength, Telemetry telemetry) throws InterruptedException {

    double rotations;
    int targetPosition;
    boolean isBusy;
    int i = 0;


        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //12 is how far you movin yo
        rotations = ( Length / (4.0 * Math.PI)); //transfers inches into rotations (4 = rad * 2)
        targetPosition = (int) (rotations * 1120); // 1120 = roller wheel number
        frontLeft.setTargetPosition(-targetPosition);
        frontRight.setTargetPosition(targetPosition);
        backLeft.setTargetPosition(-targetPosition);
        backRight.setTargetPosition(targetPosition);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(Strength);
        frontRight.setPower(Strength);
        backLeft.setPower(Strength);
        backRight.setPower(Strength);
        Thread.sleep(1);

        // && means that both things gotta be in action for IF to do it's command
        // || means that either or can do yes in IF

        if (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) {
            isBusy = true;
        } else {
            isBusy = false;
        }

        while ((frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) && i < 500) {

            telemetry.update();
            i++;
            Thread.sleep(1);
    }}
}
