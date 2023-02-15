package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
//WELCOME!


@TeleOp(name ="Single Driver TeleOp")
public class SingleDriver extends OpMode {
    //Variable declarations
DcMotor frontLeft, frontRight, backLeft, backRight, spool, chunker;
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
       chunker = hardwareMap.dcMotor.get("chunker");
    }

    //Loop process: runs when play is pressed
    @Override
    public void loop () {

        if (gamepad1.y) {
            frontLeft.setPower(1);
            backLeft.setPower(1);
            backRight.setPower(-1);
            backLeft.setPower(-1);
        }
        if (gamepad1.a) {
            frontLeft.setPower(-1);
            backLeft.setPower(-1);
            backRight.setPower(1);
            backLeft.setPower(1);
        }
        if (gamepad1.b) {
            frontLeft.setPower(-1);
            backLeft.setPower(-1);
            backRight.setPower(-1);
            backLeft.setPower(-1);
        }
        if (gamepad1.a) {
            frontLeft.setPower(1);
            backLeft.setPower(1);
            backRight.setPower(1);
            backLeft.setPower(1);
        }
        if (gamepad1.right_trigger > 0) {
            spool.setPower(gamepad1.right_trigger);
        }
        if (gamepad1.left_trigger > 0) {
            spool.setPower(-gamepad1.left_trigger);

        } else {
            spool.setPower(0);
        }
        if (gamepad1.dpad_up) {
//            grabber.setPosition(30 * (180/Math.PI));
        }
        if (gamepad1.dpad_down) {
            grabber.setPosition(0);

        }
    }
        //Loop process: runs when play i pressed
        @Override
        public void loop () {

      if (gamepad1.left_bumper) {
          frontLeft.setPower((-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x)/4);
          backLeft.setPower((-gamepad1.left_stick_y + gamepad2.left_stick_x + gamepad1.right_stick_x/4);
          frontRight.setPower((-gamepad1.left_stick_y + gamepad2.left_stick_x + gamepad1.right_stick_x/4);
          backRight .setPower((-gamepad1.left_stick_y + gamepad2.left_stick_x + gamepad1.right_stick_x)/4;
      }
      else {
          frontLeft.setPower((-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x));
          backLeft.setPower((-gamepad1.left_stick_y + gamepad2.left_stick_x + gamepad1.right_stick_x));
          frontRight.setPower((-gamepad1.left_stick_y + gamepad2.left_stick_x + gamepad1.right_stick_x));
          backRight .setPower((-gamepad1.left_stick_y + gamepad2.left_stick_x + gamepad1.right_stick_x));
      }
     if (gamepad1.right_trigger > 0) {
         spool.setPower(gamepad1.right_trigger);
     }else{
         spool.setPower(0);
     }
     if (gamepad1.right_bumper) {
         chunker.setPower(1.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001);
     }else{
         chunker.setPower(0);
     }
    }
}