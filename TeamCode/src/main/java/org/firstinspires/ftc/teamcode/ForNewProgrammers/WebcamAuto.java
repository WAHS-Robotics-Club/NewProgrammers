package org.firstinspires.ftc.teamcode.ForNewProgrammers;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

//WELCOME!

@Autonomous(name ="Webcam")
public class WebcamAuto extends LinearOpMode {
    TFObjectDetector TFO;
    DcMotor frontLeft, frontRight, backLeft, backRight;



    @Override
    public void runOpMode() throws InterruptedException {
        //INIT PHASE BUTTON PRESSED
        //HardwareMap DcMotors and other objects connected to the revhubs
        //MAKE SURE THE OBJECTS YOU ARE ASSIGNING ACTUALLY EXIST IN REAL LIFE
        //ALSO, THE GREEN STRING PARAMETER MUST EXACTLY EQUAL WHAT THE PORT IS CALLED IN THE ROBOT CONTROLLER APP ON THE ANDROID PHONES

        //create objects




        //PLAY PHASE BUTTON PRESSED
        //Wait for the button and subsequently wait 1/4 secs to start the program:
        waitForStart();
        sleep(250);

    }
}

