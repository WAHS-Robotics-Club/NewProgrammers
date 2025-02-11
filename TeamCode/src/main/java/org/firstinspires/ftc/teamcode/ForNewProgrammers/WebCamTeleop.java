package org.firstinspires.ftc.teamcode.ForNewProgrammers;/* Copyright (c) 2019 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
//import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
//import org.firstinspires.ftc.robotcore.external.tfod.Recognition;


/**
 * This 2022-2023 OpMode illustrates the basics of using the TensorFlow Object Detection API to
 * determine which image is being presented to the robot.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list.
 *
 * IMPORTANT: In order to use this OpMode, you need to obtain your own Vuforia license key as
 * is explained below.
 */
@Autonomous(name = "WebCammer", group = "Concept")
@Disabled
public class WebCamTeleop extends LinearOpMode {

    /*


    DcMotor fl;
    DcMotor bl;
    DcMotor fr;
    DcMotor br;
    //Appendage DcMotors:
    DcMotor spool;
    Servo grabber;
    private static final String TFOD_MODEL_ASSET = "PowerPlay.tflite";
    // private static final String TFOD_MODEL_FILE  = "/sdcard/FIRST/tflitemodels/CustomTeamModel.tflite";


    private static final String[] LABELS = {
            "1 Bolt",
            "2 Bulb",
            "3 Panel"
    };


    // * IMPORTANT: You need to obtain your own license key to use Vuforia. The string below with which
     //* 'parameters.vuforiaLicenseKey' is initialized is for illustration only, and will not function.
     //* A Vuforia 'Development' license key, can be obtained free of charge from the Vuforia developer
     //* web site at https://developer.vuforia.com/license-manager.
     //*
     //* Vuforia license keys are always 380 characters long, and look as if they contain mostly
     //* random data. As an example, here is a example of a fragment of a valid key:
     //*      ... yIgIzTqZ4mWjk9wd3cZO9T1axEqzuhxoGlfOOI2dRzKS4T0hQ8kT ...
    //* Once you've obtained a license key, copy the string from the Vuforia web site
     //* and paste it in to your code on the next line, between the double quotes.

    private static final String VUFORIA_KEY =
            "AR3F1JH/////AAABmaBubj4IyEg5sspSyfoKRhB673S30gFjMeEd3ljB72+VPrpVQnl4firMQIi0plJsBL7keghaiW94V+HjgCuFwLbN5V7s9a5kLsZcIaBZfmfkeUT3RFnqtariWWqx/eG+gaJixdSZj7LNPnh/ukpiD0sj5DDe6etEYlIu9UGzQlKxm51q3rIIGywYGGrTjIUCpYOEc1X10JRaKfOFftcRklQUIfLG6Zds2idGX4KRknLXmwykLjygmHMQLUhhlEtWbu6YsnsXcAvElPWO+HNb1ZWXkzKoMjnRm1rUh3CbC3KAIfrdoaRraKum6dmuUzjciu0MZ9TSgTLzn74RgDmQdHzP4urT3FdyEYXVNNhcHF1H";


     //* {@link #vuforia} is the variable we will use to store our instance of the Vuforia
    // * localization engine.

    private VuforiaLocalizer vuforia;


     //* {@link #tfod} is the variable we will use to store our instance of the TensorFlow Object
     //* Detection engine.

    private TFObjectDetector tfod;

     */

    @Override
    public void runOpMode() throws InterruptedException {
        /*
        // The TFObjectDetector uses the camera frames from the VuforiaLocalizer, so we create that
        // first.
        initVuforia();
        initTfod();
        fl = hardwareMap.dcMotor.get("frontLeft");
        fr = hardwareMap.dcMotor.get("frontRight");
        bl = hardwareMap.dcMotor.get("backLeft");
        br = hardwareMap.dcMotor.get("backRight");
        spool = hardwareMap.dcMotor.get("spool");
        grabber = hardwareMap.servo.get("grabber");
        DriveTrain robot = new DriveTrain(fl, fr, br, bl);
        BananaFruit gyro = new BananaFruit();
        gyro.runBananaFruit(hardwareMap, telemetry);
        int i =0;


         //* Activate TensorFlow Object Detection before we wait for the start command..

        if (tfod != null) {
            tfod.activate();

            tfod.setZoom(1.0, 16.0/9.0);
        }

        telemetry.addData(">", "Press Play to start op mode");
        telemetry.update();
        waitForStart();
        sleep(250);
        robot.driving(-5, 0.2, telemetry);
        if (opModeIsActive()) {
            while (opModeIsActive()) {
                if (tfod != null) {
                    // getUpdatedRecognitions() will return null if no new information is available since
                    // the last time that call was made.
                    List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                    if (updatedRecognitions != null) {
                        telemetry.addData("# Objects Detected", updatedRecognitions.size());
                        //test to see if this number goes away after object is removed

                        // step through the list of recognitions and display image position/size information for each one
                        // Note: "Image number" refers to the randomized image orientation/number
                        for (Recognition recognition : updatedRecognitions) { //for each recognition
                            double col = (recognition.getLeft() + recognition.getRight()) / 2 ; //left and right ends of object
                            double row = (recognition.getTop()  + recognition.getBottom()) / 2 ; //top and bottom ends of object
                            double width  = Math.abs(recognition.getRight() - recognition.getLeft()) ;
                            double height = Math.abs(recognition.getTop()  - recognition.getBottom()) ;

                            telemetry.addData(""," ");
                            telemetry.addData("Image", "%s (%.0f %% Conf.)", recognition.getLabel(), recognition.getConfidence() * 100 );
                            telemetry.addData("- Position (Row/Col)","%.0f / %.0f", row, col);
                            telemetry.addData("- Size (Width/Height)","%.0f / %.0f", width, height);
                            telemetry.update();

                            if(col < 300 ){
                                //fl.setPower(0.5);
                                //fr.setPower(0.5);
                                //bl.setPower(0.5);
                                //br.setPower(0.5);
                                robot.turning(((int)gyro.getHeading()+5), telemetry, gyro);
                            }
                            else if(col >500 ){
                               //fl.setPower(-0.5);
                                //fr.setPower(-0.5);
                                //bl.setPower(-0.5);
                                //br.setPower(-0.5);
                                robot.turning(((int)gyro.getHeading()-5), telemetry, gyro);
                            }
                            else if (col <500 && col >300){
                                    robot.driving(-20,0.8,telemetry);
                                    terminateOpModeNow();
                            }

                        }


                    }

                }

            }
        }

         */
    }



    /*
    //Initialize the Vuforia localization engine.

    private void initVuforia() {

         //* Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.

        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraName = hardwareMap.get(WebcamName.class, "Webcam 1");

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);
    }

    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minResultConfidence = 0.75f;
        tfodParameters.isModelTensorFlow2 = true;
        tfodParameters.inputSize = 300;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);

        // Use loadModelFromAsset() if the TF Model is built in as an asset by Android Studio
        // Use loadModelFromFile() if you have downloaded a custom team model to the Robot Controller's FLASH.
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABELS);
        // tfod.loadModelFromFile(TFOD_MODEL_FILE, LABELS);
    }
    */
}
