package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//WELCOME!

@Autonomous(name ="Autonomous")
public class AutonomousTemplate extends LinearOpMode {
    //variable declarations or methods
    DcMotor frontLeft, frontRight, backLeft, backRight, spool;
    Servo grabber;

    boolean isBusy;
    double rotations;
    int targetPosition;
    int i = 0; //loops
    BannanafFruit gyro = new BannanafFruit();
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

        robot = new DriveTrain(frontLeft,frontRight,backLeft,backRight);

        //Challenge #1
        //Challenge #2
       /* robot.Drive(16,0.8,telemetry);
        robot.Turn(-90,telemetry,gyro);
        robot.Drive(2,0.8,telemetry);
        grabber.setPosition(30);
        robot.Turn(90,telemetry,gyro);
        robot.Drive(2,0.8,telemetry);
        robot.Turn(180,telemetry,gyro);
        robot.Drive(16,0.8,telemetry);

        //Challenge #3?!?!?!?!
        robot.Drive(12,0.8,telemetry);
        spool.setPower(1);
        sleep(2000);
        spool.setPower(0);
        robot.Turn(-90,telemetry,gyro);
        robot.Drive(12,0.8, telemetry);
        spool.setPower(-1);
        sleep(2000);
        spool.setPower(0);
        robot.Turn(135,telemetry,gyro);
        robot.Drive(17,0.8,telemetry); */

        //create objects howdy


        //PLAY PHASE BUTTON PRESSED
        //Wait for the button and subsequently wait 1/4 secs to start the program:
        waitForStart();
        sleep(250);

        robot.Turn(90,telemetry,gyro);
        robot.Drive(12, 0.8, telemetry);
        robot.Turn(180,telemetry,gyro);
        robot.Drive(12, 0.8, telemetry);
        robot.Turn(270,telemetry,gyro);
        robot.Drive(12, 0.8, telemetry);
        robot.Turn(0,telemetry,gyro);
        robot.Drive(12, 0.8, telemetry);



    }
}

