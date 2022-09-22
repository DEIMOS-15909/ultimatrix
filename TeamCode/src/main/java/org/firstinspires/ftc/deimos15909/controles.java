package org.firstinspires.ftc.deimos15909;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TeleOpFinal", group = "controles")
public class

controles extends OpMode {

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
        /** MOTORES CONTROLHUB */
        izqE = hardwareMap.dcMotor.get("izqE");//motor control 0
        izqA = hardwareMap.dcMotor.get("izqA");//motor control 3
        derE = hardwareMap.dcMotor.get("derE");//motor control 1
        derA = hardwareMap.dcMotor.get("derA");//motor control 2

        garra = hardwareMap.servo.get("garra");//servo control 0

        /** MOTORES EXPANSION */
        brazo = hardwareMap.dcMotor.get("brazo");//motor expansion 3
        elev =  hardwareMap.dcMotor.get("elev");//motor expansion 0
        elev2 = hardwareMap.dcMotor.get("elev2");//motor expansion 1

        rotador = hardwareMap.servo.get("rotador");//servo expansion 0
    }

    @Override
    public void loop() {

        elev.setPower(gamepad2.left_stick_y);
        elev2.setPower(gamepad2.left_stick_y);
        brazo.setPower(-gamepad2.right_stick_y);

        if (gamepad2.a) {
            garra.setPosition(1);
        }
        if (gamepad2.b) {
            garra.setPosition(0.4);
        }
        if (gamepad2.x) {
            rotador.setPosition(0);
        }
        if (gamepad2.y) {
            rotador.setPosition(1);
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
