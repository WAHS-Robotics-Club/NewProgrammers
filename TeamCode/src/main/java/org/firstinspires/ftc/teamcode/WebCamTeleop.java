package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.Camera;

//WELCOME!


@TeleOp(name ="WebCamTeleop")
public class WebCamTeleop extends OpMode {
    //Variable declarations
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor spool;
    Servo grabber;
    Camera dank;

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
        dank = hardwareMap.get(Camera.class, "Webcam 1");
    }

    //Loop process: runs when play is pressed
    @Override
    public void loop () {


        if(gamepad1.left_bumper){
            frontLeft.setPower((-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x)/4);
            backLeft.setPower((-gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.right_stick_x) * 0.25);
            frontRight.setPower((gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x)/4);
            backRight.setPower((gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.right_stick_x)/4);

        } else{
            frontLeft.setPower((-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x));
            backLeft.setPower((-gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.right_stick_x));
            frontRight.setPower((gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x));
            backRight.setPower((gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.right_stick_x));
        }
        if(gamepad1.right_trigger > 0.01){ //notice that gamepad1 right trigger is listed as a float, not a boolean
            spool.setPower(gamepad1.right_trigger);
        }else{
            spool.setPower(0);
        }

        if(gamepad1.left_trigger> 0.01){ //notice the dead zone!
            spool.setPower(-gamepad1.left_trigger);
        }else{
            spool.setPower(0);
        }

        if(gamepad1.a){
            grabber.setPosition((15) *(Math.PI/180));
        }else if(gamepad1.x){
            grabber.setPosition(30 * (Math.PI/180));
        }
    }
}
