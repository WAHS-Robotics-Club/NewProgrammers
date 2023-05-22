package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name ="Ryan Autonomous Right")
public class ExampleAutonomous extends LinearOpMode {

    //create DcMotors, or other components of your robot

    //DriveTrain DcMotors:
    DcMotor fl;
    DcMotor bl;
    DcMotor fr;
    DcMotor br;
    //Appendage DcMotors:
    DcMotor spool;
    Servo grabber;






    @Override
    public void runOpMode() throws InterruptedException {
        //INIT PHASE BUTTON PRESSED
        //HardwareMap DcMotors:
        //assign each object to a hardware map port
        //****MAKE SURE ALL OBJECTS YOUR ARE ASSIGNING EXIST IN REAL LIFE****
        fl = hardwareMap.dcMotor.get("frontLeft");
        fr = hardwareMap.dcMotor.get("frontRight");
        bl = hardwareMap.dcMotor.get("backLeft");
        br = hardwareMap.dcMotor.get("backRight");
        spool = hardwareMap.dcMotor.get("spool");
        grabber = hardwareMap.servo.get("grabber");

        //create any objects you may need for your program
        DriveTrain robot = new DriveTrain(fl,fr,br,bl); //my own drivetrain class, yours might look different
        BananaFruit gyro = new BananaFruit(); //bananafruit class, which allows us to use gyroscopes built into the android phones
        gyro.runBananaFruit(hardwareMap, telemetry); //start bananafruit

        telemetry.addData("FL Power: ", fl.getPower());
        telemetry.addData("BL Power: ", bl.getPower());
        telemetry.addData("FR Power", fr.getPower());
        telemetry.addData("BR Power", br.getPower());
        telemetry.update();

        //^all code above will be run when init is pressed on the driver station app^



        //PLAY PHASE BUTTON PRESSED
        //Wait for the button and subsequently wait 1/4 secs to start the program:
        waitForStart();
        sleep(250);
       /* robot.driving(-40, 0.8, telemetry);
        robot.turning(90, telemetry, gyro);
        robot.driving(-1,0.5,telemetry);
        robot.driving(1,0.5,telemetry);
        robot.turning(0, telemetry, gyro);
        robot.driving(45,0.8, telemetry);
        robot.turning(-90, telemetry, gyro);
        robot.driving(-70, 0.8, telemetry); */
while(opModeIsActive()){
        fl.setPower(0.5);
        fr.setPower(0.5);
        bl.setPower(0.5);
        br.setPower(0.5);}
        //program will end when all tasks are completed
        //robot will only move onto next task when it completes the previously assigned task.
        //The robot will complete each method one at a time.
    }
}

