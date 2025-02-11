package org.firstinspires.ftc.teamcode.OpModes.Autonomi.Yos;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Objects.BananaFruit;
import org.firstinspires.ftc.teamcode.Objects.DriveTrain;
import org.firstinspires.ftc.teamcode.Objects.Grabber;

//@Autonomous(name ="Reset - Autonomous")
public class ResetAutonomous extends LinearOpMode {

    DriveTrain driveTrain;
    Grabber grabber;

    @Override
    public void runOpMode() throws InterruptedException {
        driveTrain = DriveTrain.initDriveTrain(hardwareMap, DcMotor.ZeroPowerBehavior.BRAKE);
        grabber = Grabber.initGrabber(hardwareMap);

        telemetry.addData("IsBusy", driveTrain.isBusy());
        driveTrain.logTelemetry(telemetry, driveTrain);
        telemetry.update();
        driveTrain.resetEncoders();
        BananaFruit gyro = new BananaFruit();
        gyro.runBananaFruit(hardwareMap, telemetry);
        telemetry.update();

        waitForStart();

        //ONLY MODIFY STUFF AFTER THIS

    /*  Grabber Commands:
        grabber.setHeightTo(telemetry, 500);
        grabber.toggleGrabberAuto();

        Drive Train Commands:
        driveTrain.moveForwardsBy(telemetry, 10);
        driveTrain.turnToHeading(gyro, telemetry, 90);

        Misc:
        sleep(1000);
        misc.toggleCarouselAuto();
    */

        //grabber.toggleGrabberAuto();
        // grabber.setHeightTo(telemetry, 0);
        sleep(500);

    }
}