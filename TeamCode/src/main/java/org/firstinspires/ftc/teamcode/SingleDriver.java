package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
//WELCOME!


@TeleOp(name ="Single Driver TeleOp")
public class SingleDriver extends OpMode {
    //Variable declarations
DcMotor frontleft, frontright, backleft, backright, spool;
Servo grabber;
    //Initiation process:
    @Override
    public void init () {
        //HardwareMap ALL motors:
        frontleft = hardwareMap.dcMotor.get("frontleft");
        frontright = hardwareMap.dcMotor.get("frontright");
        backleft = hardwareMap.dcMotor.get("backleft");
        backright = hardwareMap.dcMotor.get("backright");
        spool = hardwareMap.dcMotor.get("spool");
        grabber = hardwareMap.servo.get("grabber");
    }

    //Loop process: runs when play is pressed
    @Override
    public void loop () {

        if(gamepad1.y){
            frontleft.setPower(1);
            backleft.setPower(1);
            backright.setPower(-1);
            backleft.setPower(-1);
        }
        if (gamepad1.a){
            frontleft.setPower(-1);
            backleft.setPower(-1);
            backright.setPower(1);
            backleft.setPower(1);
        }
        if (gamepad1.b){
            frontleft.setPower(-1);
            backleft.setPower(-1);
            backright.setPower(-1);
            backleft.setPower(-1);
        }
        if (gamepad1.a){
            frontleft.setPower(1);
            backleft.setPower(1);
            backright.setPower(1);
            backleft.setPower(1);

    }
        if(gamepad1.right_trigger > 0){
            spool.setPower(gamepad1.right_trigger);
        }
        if (gamepad1.left_trigger > 0) {
            spool.setPower(-gamepad1.left_trigger);
        }
        } else {
            spool.setPower(0);
        }
        if(gamepad1.dpad_up){
            grabber.setPosition(30 * (180/Math.PI));
    }
        if(gamepad1.dpad_down){
            grabber.setPosition(0);
    }
}