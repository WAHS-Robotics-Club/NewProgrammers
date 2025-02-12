package org.firstinspires.ftc.teamcode.ForNewProgrammers;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
//WELCOME!


@TeleOp(name ="safeDrive")
@Disabled
public class Kidvention extends OpMode {
    //Variable declarations yos
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor spool;
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
        if(gamepad1.left_bumper){
            frontLeft.setPower((-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x)/4);
            backLeft.setPower((-gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.right_stick_x)/4);
            frontRight.setPower((gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x)/4);
            backRight.setPower((gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.right_stick_x)/4);

        } else{
            frontLeft.setPower((-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x)/2);
            backLeft.setPower((-gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.right_stick_x)/2);
            frontRight.setPower((gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x)/2);
            backRight.setPower((gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.right_stick_x)/2);


        }

    }
}
