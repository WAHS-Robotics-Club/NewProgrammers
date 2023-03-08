package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//WELCOME!
//hello there
@Autonomous(name ="Autonomous")
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
    BananaFruit gyro = new BananaFruit();




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



        //MAKE SURE THE OBJECTS YOU ARE ASSIGNING ACTUALLY EXIST IN REAL LIFE
        //ALSO, THE GREEN STRING PARAMETER MUST EXACTLY EQUAL WHAT THE PORT IS CALLED IN THE ROBOT CONTROLLER APP ON THE ANDROID PHONES

        //create objects





        //PLAY PHASE BUTTON PRESSED
        //Wait for the button and subsequently wait 1/4 secs to start the program:
        waitForStart();
        sleep(250);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rotations = (12/(4.0*Math.PI));
        targetPosition = (int)(rotations*1120);
        frontLeft.setTargetPosition(-targetPosition);
        backLeft.setTargetPosition(-targetPosition);
        frontRight.setTargetPosition(targetPosition);
        backRight.setTargetPosition(targetPosition);

        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontLeft.setPower(0.8);
        backLeft.setPower(0.8);
        frontRight.setPower(0.8);
        backRight.setPower(0.8);
        Thread.sleep(1);



        if (frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) {
            isBusy = true;
        } else {
            isBusy = false;
        }


        while((frontLeft.isBusy() && frontRight.isBusy() && backLeft.isBusy() && backRight.isBusy()) && i < 500) {

            telemetry.update();
            i++;
            Thread.sleep(1);
        }
        //code after this
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
        }
    }

