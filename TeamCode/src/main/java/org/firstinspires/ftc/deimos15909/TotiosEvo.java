package org.firstinspires.ftc.deimos15909;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Ultimatrix", group = "Control")
public class TotiosEvo extends OpMode {

    DcMotor izqE;
    DcMotor derE;
    DcMotor izqA;
    DcMotor derA;
    DcMotor brazo;
    DcMotor elev;
    DcMotor elev2;
    Servo garra;
    Servo rotador;


    @Override
    public void init() {
        izqE = hardwareMap.dcMotor.get("izqE");
        izqA = hardwareMap.dcMotor.get("izqA");
        derE = hardwareMap.dcMotor.get("derE");
        derA = hardwareMap.dcMotor.get("derA");
        //MOTORES CONTROLHUB

        brazo = hardwareMap.dcMotor.get("brazo");
        elev =  hardwareMap.dcMotor.get("elev");//
        elev2 = hardwareMap.dcMotor.get("elev2");//expansion 1
        //MOTORES EXPANSION

        garra = hardwareMap.servo.get("garra");//control 0
        rotador = hardwareMap.servo.get("rotador");// expansion 0

    }

    @Override
    public void loop() {

        elev2.setPower(gamepad2.left_stick_y);
        brazo.setPower(gamepad2.right_stick_y);
        


        if (gamepad2.x) {
            garra.setPosition(1);
        } else {
            garra.setPosition(0.50);

            if (gamepad2.b) {
                garra.setPosition(0);
            }

            if (gamepad2.b) {
                garra.setPosition(0);
            }
            if (gamepad2.left_bumper) {
                garra.setPosition(1);
            }

            double drive = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double twist = gamepad1.right_stick_x;


            double[] speeds = {
                    (drive + strafe + twist),

                    (drive - strafe - twist),
                    (drive - strafe + twist),
                    (drive + strafe - twist)
            };


            double max = Math.abs(speeds[0]);
            for (int i = 0; i < speeds.length; i++) {
                if (max < Math.abs(speeds[i])) max = Math.abs(speeds[i]);
            }


            if (max > 1) {
                for (int i = 0; i < speeds.length; i++) speeds[i] /= max;
            }


            izqE.setPower(speeds[0]);
            derE.setPower(speeds[1]);
            izqA.setPower(-speeds[2]);
            derA.setPower(speeds[3]);

        }
    }
}
