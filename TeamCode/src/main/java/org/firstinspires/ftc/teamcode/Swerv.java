package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import android.annotation.SuppressLint;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

    @TeleOp(name ="La pep")
    public class Swerv extends OpMode {
        //variable declarations or methods
        DcMotor one;
        DcMotor two;

        DcMotor three;

        DcMotor four;
        public void init(){
            one = hardwareMap.dcMotor.get("DcMotor1");
            two = hardwareMap.dcMotor.get("DcMotor2");
            three = hardwareMap.dcMotor.get("DcMotor3");
            four = hardwareMap.dcMotor.get("Dcmotor4");
        }
        public void loop(){

        }
    }
    

