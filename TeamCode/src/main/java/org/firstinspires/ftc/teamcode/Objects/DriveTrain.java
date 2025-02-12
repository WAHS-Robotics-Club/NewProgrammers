package org.firstinspires.ftc.teamcode.Objects;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Tool.Toggle;

public class DriveTrain {
    //Initializing the dc motor objects:
    //Gradle Evil Yes

    public DcMotor flMotor;
    public DcMotor frMotor;
    public DcMotor blMotor;
    public DcMotor brMotor;
    Toggle toggleSpeed;
    double targetHeading;
    //Sets the acceptable margin of error for the heading (in degrees)
    final double HEADING_ACCURACY = 2;

    public static DriveTrain initDriveTrain(HardwareMap hardwareMap, DcMotor.ZeroPowerBehavior brakeAction) {
        //Hardware mapping the motors:
        DriveTrain driveTrain = new DriveTrain();

        driveTrain.flMotor = hardwareMap.dcMotor.get("Fl");
        driveTrain.frMotor = hardwareMap.dcMotor.get("Fr");
        driveTrain.blMotor = hardwareMap.dcMotor.get("Bl");
        driveTrain.brMotor = hardwareMap.dcMotor.get("Br");

        driveTrain.flMotor.setPower(0);
        driveTrain.frMotor.setPower(0);
        driveTrain.blMotor.setPower(0);
        driveTrain.brMotor.setPower(0);

        driveTrain.toggleSpeed = new Toggle();

        return driveTrain;
    }

    public void manualDrive(Gamepad gamepad1){
        if(!toggleSpeed.isToggled()) {
            flMotor.setPower(gamepad1.left_stick_x + -gamepad1.left_stick_y + gamepad1.right_stick_x);
            frMotor.setPower(gamepad1.left_stick_x + gamepad1.left_stick_y + gamepad1.right_stick_x);
            blMotor.setPower(-gamepad1.left_stick_x + -gamepad1.left_stick_y + gamepad1.right_stick_x);
            brMotor.setPower(-gamepad1.left_stick_x + gamepad1.left_stick_y + gamepad1.right_stick_x);
        }else{
            flMotor.setPower((gamepad1.left_stick_x + -gamepad1.left_stick_y + gamepad1.right_stick_x)/4);
            frMotor.setPower((gamepad1.left_stick_x + gamepad1.left_stick_y + gamepad1.right_stick_x)/4);
            blMotor.setPower((-gamepad1.left_stick_x + -gamepad1.left_stick_y + gamepad1.right_stick_x)/4);
            brMotor.setPower((-gamepad1.left_stick_x + gamepad1.left_stick_y + gamepad1.right_stick_x)/4);
        }
    }

    public void Strafin (Gamepad gamepad1) {
        if (!toggleSpeed.isToggled()) {
            if (gamepad1.dpad_left) {
                flMotor.setPower(-1);
                frMotor.setPower(1);
                blMotor.setPower(1);
                brMotor.setPower(-1);
            } else if (gamepad1.dpad_right) {
                flMotor.setPower(1);
                frMotor.setPower(-1);
                blMotor.setPower(-1);
                brMotor.setPower(1);
            }
        } else {
            if (gamepad1.dpad_left) {
                flMotor.setPower(-0.25);
                frMotor.setPower(0.25);
                blMotor.setPower(0.25);
                brMotor.setPower(-0.25);
            } else if (gamepad1.dpad_right) {
                flMotor.setPower(0.25);
                frMotor.setPower(-0.25);
                blMotor.setPower(-0.25);
                brMotor.setPower(0.25);
            }
        }
    }

    public void checkToggleSpeed(Gamepad gamepad1){
        if(gamepad1.left_bumper){
            toggleSpeed.toggle();
        }
    }

    public static void logTelemetry(Telemetry telemetry, DriveTrain driveTrain) {
        //telemetry.addData("Heading", driveTrain.getHeading() + " degrees");
        //1120 ticks in a rotation
        telemetry.addData("Fl Power", driveTrain.flMotor.getPower());
        telemetry.addData("Fr Power", driveTrain.frMotor.getPower());
        telemetry.addData("Bl Power", driveTrain.blMotor.getPower());
        telemetry.addData("Br Power", driveTrain.brMotor.getPower());
    }

    private void goForwardsTo(double inches) throws InterruptedException{
        Thread.sleep(1);
        resetEncoders();
        Thread.sleep(1);
        if (inches < 5) {
            setBasePower(0.5);
        } else {
            setBasePower(0.8);
        }
        int targetPosition;
        double rotations;

        rotations = inches / (4*Math.PI);
        targetPosition = (int)(rotations * 1120);

        flMotor.setTargetPosition(targetPosition);
        frMotor.setTargetPosition(-targetPosition);
        blMotor.setTargetPosition(targetPosition);
        brMotor.setTargetPosition(-targetPosition);

        Thread.sleep(1);
        setRunMode(DcMotor.RunMode.RUN_TO_POSITION);
        Thread.sleep(1);
    }

    private void StrafeRightTo (double inches) throws InterruptedException{
        Thread.sleep(1);
        resetEncoders();
        Thread.sleep(1);
        setBasePower(0.5);
        int targetPosition;
        double rotations;

        rotations = inches / (4*Math.PI);
        targetPosition = (int)(rotations * 1120);

        flMotor.setTargetPosition(targetPosition);
        frMotor.setTargetPosition(targetPosition);
        blMotor.setTargetPosition(-targetPosition);
        brMotor.setTargetPosition(-targetPosition);

        Thread.sleep(1);
        setRunMode(DcMotor.RunMode.RUN_TO_POSITION);
        Thread.sleep(1);
    }

    private void StrafeLeftTo (double inches) throws InterruptedException{
        Thread.sleep(1);
        resetEncoders();
        Thread.sleep(1);
        setBasePower(0.5);
        int targetPosition;
        double rotations;

        rotations = inches / (4*Math.PI);
        targetPosition = (int)(rotations * 1120);

        flMotor.setTargetPosition(-targetPosition);
        frMotor.setTargetPosition(-targetPosition);
        blMotor.setTargetPosition(targetPosition);
        brMotor.setTargetPosition(targetPosition);

        Thread.sleep(1);
        setRunMode(DcMotor.RunMode.RUN_TO_POSITION);
        Thread.sleep(1);
    }

    public void setRunMode(DcMotor.RunMode runMode){
        flMotor.setMode(runMode);
        frMotor.setMode(runMode);
        blMotor.setMode(runMode);
        brMotor.setMode(runMode);
    }

    public void setBasePower(double power){
        flMotor.setPower(power);
        frMotor.setPower(power);
        blMotor.setPower(power);
        brMotor.setPower(power);
    }

    public void resetEncoders(){
        setBasePower(0);
        setRunMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setBasePower(0);
    }

    public void moveForwardsBy(Telemetry telemetry, double inches) throws InterruptedException{
        //Going Forwards
        goForwardsTo(inches);
        Thread.sleep(10);
        while(isBusy()){
            telemetry.update();
            Thread.sleep(1);
        }
        Thread.sleep(10);
    }
    public void StrafeRightBy(Telemetry telemetry, double inches) throws InterruptedException{
        //Swerving?!!/!!/111!?!1//1
        StrafeRightTo(inches);
        Thread.sleep(10);
        while(isBusy()){
            telemetry.update();
            Thread.sleep(1);
        }
        Thread.sleep(10);
    }
    public void StrafeLeftBy(Telemetry telemetry, double inches) throws InterruptedException{
        //Swerving?!!/!!/111!?!1//1
        StrafeLeftTo(inches);
        Thread.sleep(10);
        while(isBusy()){
            telemetry.update();
            Thread.sleep(1);
        }
        Thread.sleep(10);
    }

    public boolean isBusy(){
        return (flMotor.isBusy() && blMotor.isBusy() && frMotor.isBusy() && brMotor.isBusy());
    }

    public boolean isCorrectHeading(int currentHeading){
        return (targetHeading < currentHeading + HEADING_ACCURACY && targetHeading > currentHeading - HEADING_ACCURACY);
    }

    private boolean isWithinDangerZone(double heading){
        return (heading > 145 || heading < -145);
    }

    private void turnRobotToHeading(int currentHeading, double targetHeading){
        if(isWithinDangerZone(targetHeading) && targetHeading < 0){
            if(isWithinDangerZone(currentHeading) && currentHeading > 0){
                    currentHeading -= 360;
            }
        }else if(isWithinDangerZone(targetHeading) && targetHeading > 0){
            if(isWithinDangerZone(currentHeading) && currentHeading < 0){
                currentHeading += 360;
            }
        }

        double modifier, startingPower, difference;
        difference = Math.abs(targetHeading - currentHeading);
        modifier = ((Math.sqrt((difference)))/2);
        startingPower = 0.1;

        if(targetHeading < currentHeading - HEADING_ACCURACY){
            flMotor.setPower(startingPower * modifier);
            frMotor.setPower(startingPower * modifier);
            blMotor.setPower(startingPower * modifier);
            brMotor.setPower(startingPower * modifier);
        }else if(targetHeading > currentHeading + HEADING_ACCURACY){
            flMotor.setPower(-startingPower * modifier);
            frMotor.setPower(-startingPower * modifier);
            blMotor.setPower(-startingPower * modifier);
            brMotor.setPower(-startingPower * modifier);
        }else{
            flMotor.setPower(0);
            frMotor.setPower(0);
            blMotor.setPower(0);
            brMotor.setPower(0);
        }
    }



    public void turnToHeading(BananaFruit gyro, Telemetry telemetry, double inputTargetHeading) throws InterruptedException{
        //Turning
        targetHeading = -inputTargetHeading;
        setRunMode(DcMotor.RunMode.RUN_USING_ENCODER);
        while(!isCorrectHeading(gyro.getHeading())){
            telemetry.update();
            turnRobotToHeading(gyro.getHeading(), targetHeading);
            Thread.sleep(1);
        }

        Thread.sleep(10);
        flMotor.setPower(0);
        frMotor.setPower(0);
        blMotor.setPower(0);
        brMotor.setPower(0);
        Thread.sleep(10);

    }
}


