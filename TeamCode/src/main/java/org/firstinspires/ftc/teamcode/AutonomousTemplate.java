package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
//WELCOME!

@Autonomous(name ="Autonomous")
public class AutonomousTemplate extends LinearOpMode {
    //variable declarations or methods
DcMotor frontLeft, frontRight, backLeft, backRight, spool;
Servo grabber;
int targetPosition;
int i = 0;
boolean isBusy;
double modifier, basePower, rotations;
        DriveTrain movement = new DriveTrain(frontLeft, frontRight, backLeft, backRight);

BananaFruit gyro = new BananaFruit();
    @Override
    public void runOpMode() throws InterruptedException {
        //INIT PHASE BUTTON PRESSED
        //HardwareMap DcMotors:
        //create objects
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        grabber = hardwareMap.servo.get("grabber");



        //PLAY PHASE BUTTON PRESSED
        //Wait for the button and subsequently wait 1/4 secs to start the program:
        waitForStart();
        sleep(250);


        movement.driveForward(0.8,10, telemetry);
        spool.setPower(1);
        sleep(2000);
        spool.setPower(0);
        movement.rotate(270, telemetry, gyro);
        movement.driveForward(0.8,10, telemetry);
        spool.setPower(-1);
        sleep(2000);
        spool.setPower(0);
        movement.rotate(135, telemetry, gyro);
        movement.driveForward(0.8,14.14, telemetry);

    }
        }


