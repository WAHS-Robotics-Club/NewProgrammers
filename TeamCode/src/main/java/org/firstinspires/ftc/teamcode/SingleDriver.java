package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
//WELCOME!


@TeleOp(name ="Single Driver TeleOp")
public class SingleDriver extends OpMode {
    //Variable declarations
DcMotor frontLeft, frontRight, backLeft, backRight, spool;
Servo grabber;
    //Initiation process:
    @Override
    public void init () {
        //HardwareMap ALL motors:
       frontLeft = hardwareMap.dcMotor.get("frontLeft");
       frontRight = hardwareMap.dcMotor.get("frontRight");
       backLeft = hardwareMap.dcMotor.get("backLeft");
       backRight = hardwareMap.dcMotor.get("backRight");
       spool = hardwareMap.dcMotor.get("spool");
       grabber = hardwareMap.servo.get("grabber");
    }

    //Loop process: runs when play is pressed
    @Override
    public void loop () {

        /*frontL.setPower((-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x));
            backL.setPower((-gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.right_stick_x));
            frontR.setPower((gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x));
            backR.setPower((gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.right_stick_x));
            
         */

        if (gamepad1.y){
            frontLeft.setPower(1);
            backLeft.setPower(1);
            backRight.setPower(-1);
            backLeft.setPower(-1);
        }if (gamepad1.a){
            frontLeft.setPower(-1);
            backLeft.setPower(-1);
            backRight.setPower(1);
            backLeft.setPower(1);
        }if (gamepad1.b){
            frontLeft.setPower(-1);
            backLeft.setPower(-1);
            backRight.setPower(-1);
            backLeft.setPower(-1);
        }if (gamepad1.a){
            frontLeft.setPower(1);
            backLeft.setPower(1);
            backRight.setPower(1);
            backLeft.setPower(1);
        }
        if (gamepad1.right_trigger > 0){
            spool.setPower(gamepad1.right_trigger);
        }
        if(gamepad1.left_trigger > 0){
            spool.setPower(-gamepad1.left_trigger);

        }
        else{
            spool.setPower(0);
        }
        if(gamepad1.dpad_up){
            grabber.setPosition(30 * (180/Math.PI));
        }
        if(gamepad1.dpad_down){
            grabber.setPosition(0);

        }
    }
}