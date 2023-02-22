package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


//WELCOME!


@TeleOp(name ="Single Driver TeleOp")
public class SingleDriver extends OpMode {
    //Variable declarations
    //trying this out

    DcMotor frontLeft, frontRight, backLeft, backRight, spool, xButton;

    //Initiation process:
    @Override
    public void init () {
        //HardwareMap ALL motors:
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        spool = hardwareMap.dcMotor.get("spool");
        xButton = hardwareMap.dcMotor.get("xButton");



    }

    //Loop process: runs when play is pressed
    @Override
    public void loop () {

        if(gamepad1.left_bumper) {
            frontLeft.setPower((-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x)/4);
            frontRight.setPower((-gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.right_stick_x)/4);
            backLeft.setPower((gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x)/4);
            backRight.setPower((gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.right_stick_x)/4);

        }else {
            frontLeft.setPower((-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x));
            frontRight.setPower((-gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.right_stick_x));
            backLeft.setPower((gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x));
            backRight.setPower((gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.right_stick_x));
        }

        if(gamepad1.right_trigger > 0){
            spool.setPower(gamepad1.right_trigger);
        } else{
            spool.setPower(0);
        }

        if(gamepad1.x){
            xButton.setPower(0.75);
        } else{
            xButton.setPower(0);
        }

    }
}