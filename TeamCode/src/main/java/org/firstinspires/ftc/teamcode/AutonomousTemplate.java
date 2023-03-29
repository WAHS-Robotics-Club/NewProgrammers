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
        DriveTrain robot = new DriveTrain(frontLeft, frontRight, backLeft, backRight);


        //create objects howdy howdy

        //PLAY PHASE BUTTON PRESSED
        //Wait for the button and subsequently wait 1/4 secs to start the program:
        waitForStart();
        sleep(250);

        robot.Drive(0.8,10,telemetry);
        robot.turning(90, telemetry, gyro);
        grabber.setPosition(2);
        sleep(100);
        grabber.setPosition(0);
        robot.turning(-90,telemetry, gyro);
        robot.Drive(0.8,10, telemetry);










}}

