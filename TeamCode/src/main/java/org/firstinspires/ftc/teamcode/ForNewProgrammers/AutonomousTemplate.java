package org.firstinspires.ftc.teamcode.ForNewProgrammers;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//WELCOME!
//hello there
@Autonomous(name ="Autonomou2s")
@Disabled
public class AutonomousTemplate extends LinearOpMode {
    //variable declarations or methods
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor spool;
    Servo grabber;
    boolean isBusy;
    double rotations;
    int targetPosition;
    int i =0;





    @Override
    public void runOpMode() throws InterruptedException {
        //INIT PHASE BUTTON PRESSED
        //HardwareMap DcMotors and other objects connected to the revhubs
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        spool = hardwareMap.dcMotor.get("spool");
        grabber = hardwareMap.servo.get("grabber");
        BananaFruit gyro = new BananaFruit();
        gyro.runBananaFruit(hardwareMap, telemetry);



        //MAKE SURE THE OBJECTS YOU ARE ASSIGNING ACTUALLY EXIST IN REAL LIFE
        //ALSO, THE GREEN STRING PARAMETER MUST EXACTLY EQUAL WHAT THE PORT IS CALLED IN THE ROBOT CONTROLLER APP ON THE ANDROID PHONES

        //create objects





        //PLAY PHASE BUTTON PRESSED
        //Wait for the button and subsequently wait 1/4 secs to start the program:
        waitForStart();
        sleep(250);

        }
    }

