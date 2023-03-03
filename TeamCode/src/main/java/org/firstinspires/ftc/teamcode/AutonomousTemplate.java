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
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //12 is how far you movin yo
        rotations = (12/(4.0*Math.PI)); //transfers inches into rotations (4 = rad * 2)
        targetPosition = (int)(rotations*1120); // 1120 = roller wheel number
        frontLeft.setTargetPosition(-targetPosition);
        frontRight.setTargetPosition(targetPosition);
        backLeft.setTargetPosition(-targetPosition);
        backRight.setTargetPosition(targetPosition);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(0.8);
        frontRight.setPower(0.8);
        backLeft.setPower(0.8);
        backRight.setPower(0.8);
        Thread.sleep(1);

        // && means that both things gotta be in action for IF to do it's command
        // || means that either or can do yes in IF

        if (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()){
            isBusy = true;
        } else {
            isBusy = false;
        }

        while((frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) && i < 500) {

            telemetry.update();
            i++;
            Thread.sleep(1);
        }


        }
    }

