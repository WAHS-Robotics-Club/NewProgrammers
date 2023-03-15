package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.checkerframework.checker.propkey.qual.PropertyKeyBottom;

//WELCOME!

@Autonomous(name ="Autonomous")
public class AutonomousTemplate extends LinearOpMode {
    //variable declarations or methods

    DcMotor frontLeft, frontRight, backLeft, backRight, spool;
    Servo grabber;
    double rotations;
    int targetPosition;
    boolean isBusy;
    int i = 0;
    BananaFruit gyro = new BananaFruit();
    DriveTrain robot = new DriveTrain(frontLeft, frontRight, backLeft, backRight);


    @Override
    public void runOpMode() throws InterruptedException {
        //INIT PHASE BUTTON PRESSED
        //HardwareMap DcMotors:
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        spool = hardwareMap.dcMotor.get("spool");
        grabber = hardwareMap.servo.get("grabber");


        //create objects

        //PLAY PHASE BUTTON PRESSED
        //Wait for the button and subsequently wait 1/4 secs to start the program:
        waitForStart();
        sleep(250);

        robot.Drive(0.8, 12, telemetry);
        //turning

        int targetHeading = 90;
        boolean isCorrectHeading = false;
        int currentHeading;
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        while (!isCorrectHeading) {
            telemetry.update();
            currentHeading = gyro.getHeading();


        if (targetHeading < gyro.getHeading() + 1.25 && targetHeading > gyro.getHeading() - 1.25) {
            isCorrectHeading = true;
        } else {
            isCorrectHeading = false;
        }

        if (currentHeading > 145 || currentHeading < -145) {
            if (currentHeading < 0) {
                currentHeading += 360;
            }
        }

        double modifier, basePower;
        modifier = ((Math.sqrt(Math.abs(targetHeading - currentHeading)))/2);
        basePower = 0.1;

        if (targetHeading < currentHeading - 1.25) {
            frontLeft.setPower(basePower * modifier);
            frontRight.setPower(basePower * modifier);
            backLeft.setPower(basePower * modifier);
            backRight.setPower(basePower * modifier);
        } else if (targetHeading > currentHeading + 1.25) {
            frontLeft.setPower(-basePower * modifier);
            frontRight.setPower(-basePower * modifier);
            backLeft.setPower(-basePower * modifier);
            backRight.setPower(-basePower * modifier);
        }
        else {
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);
        }
        Thread.sleep(1);

    }

}}

