package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
//WELCOME!

@Autonomous(name ="Autonomous 1")
public class AutonomousTemplate extends LinearOpMode {
    //variable declarations or methods
DcMotor frontLeft, frontRight, backLeft, backRight;
Servo grabber;
int targetPosition;
int i = 0;
boolean isBusy;
double modifier, basePower, rotations;

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
        BananaFruit gyro = new BananaFruit();
        gyro.runBananaFruit(hardwareMap, telemetry);
        DriveTrain movement = new DriveTrain(frontLeft, frontRight, backLeft, backRight);


        //PLAY PHASE BUTTON PRESSED
        //Wait for the button and subsequently wait 1/4 secs to start the program:
        waitForStart();
        sleep(250);
        movement.driveForward(0.8, 68, telemetry);
        movement.rotate(90, telemetry, gyro);
        grabber.setPosition((30) *(Math.PI/180));
        movement.driveForward(0.8, -24, telemetry);
        movement.rotate(270, telemetry, gyro);
        movement.driveForward(0.8, 23, telemetry);



    }
        }


