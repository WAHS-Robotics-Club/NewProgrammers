package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name ="Ryan Autonomous Right")
public class ExampleAutonomous extends LinearOpMode {

    //DriveTrain DcMotors:
    DcMotor fl;
    DcMotor bl;
    DcMotor fr;
    DcMotor br;
    //Appendage DcMotors:
    DcMotor spool;
    DcMotor grab;
    DcMotor carousel;




    @Override
    public void runOpMode() throws InterruptedException {
        //INIT PHASE BUTTON PRESSED
        //HardwareMap DcMotors:
        fl = hardwareMap.dcMotor.get("frontLeftMotor");
        bl = hardwareMap.dcMotor.get("backLeftMotor");
        fr = hardwareMap.dcMotor.get("frontRightMotor");
        br = hardwareMap.dcMotor.get("backRightMotor");
        grab = hardwareMap.dcMotor.get("grab");
        spool = hardwareMap.dcMotor.get("spoolMotor");
        carousel = hardwareMap.dcMotor.get("carouselSpinner");

        DriveTrain robot = new DriveTrain(fl,fr,br,bl);
        BananaFruit gyro = new BananaFruit();
        gyro.runBananaFruit(hardwareMap, telemetry);

        telemetry.addData("FL Power: ", fl.getPower());
        telemetry.addData("BL Power: ", bl.getPower());
        telemetry.addData("FR Power", fr.getPower());
        telemetry.addData("BR Power", br.getPower());
        telemetry.update();



        //PLAY PHASE BUTTON PRESSED
        //Wait for the button and subsequently wait 1/4 secs to start the program:
        waitForStart();
        sleep(250);
        robot.driving(-40, 0.8, telemetry);
        robot.turning(90, telemetry, gyro);
        robot.driving(-1,0.5,telemetry);
        grab.setPower(-0.2);
        sleep(1000);
        grab.setPower(0);
        robot.driving(1,0.5,telemetry);
        robot.turning(0, telemetry, gyro);
        robot.driving(45,0.8, telemetry);
        robot.turning(-90, telemetry, gyro);
        robot.driving(-70, 0.8, telemetry);








    }
}

