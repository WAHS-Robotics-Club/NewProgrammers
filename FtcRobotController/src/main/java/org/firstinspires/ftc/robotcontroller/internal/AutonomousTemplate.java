package org.firstinspires.ftc.robotcontroller.internal;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
//WELCOME!

@Autonomous(name ="Autonomous")
public class AutonomousTemplate extends LinearOpMode {
    //variable declarations or methods



    @Override
    public void runOpMode() throws InterruptedException {
        //INIT PHASE BUTTON PRESSED
        //HardwareMap DcMotors:
        //create objectsgit

        //PLAY PHASE BUTTON PRESSED
        //Wait for the button and subsequently wait 1/4 secs to start the program:
        waitForStart();
        sleep(250);

        }
    }

