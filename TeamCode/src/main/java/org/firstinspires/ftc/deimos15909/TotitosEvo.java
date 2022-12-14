package org.firstinspires.ftc.deimos15909;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Ultimatrix", group = "Control")
public class TotitosEvo extends OpMode {

    DcMotor izqE;
    DcMotor derE;
    DcMotor izqA;
    DcMotor derA;
    DcMotor brazo;
    DcMotor elev;
    DcMotor elev2;
    Servo garra;
    Servo rotador;
    boolean slowmode = false;


    @Override
    public void init() {
        izqE = hardwareMap.dcMotor.get("izqE"); //izquierdo enfrente
        izqA = hardwareMap.dcMotor.get("izqA");
        derE = hardwareMap.dcMotor.get("derE");
        derA = hardwareMap.dcMotor.get("derA");
        garra = hardwareMap.servo.get("garra"); //servo que permite agarrar
        rotador = hardwareMap.servo.get("rotador"); //servo que permite girar la garra
        brazo = hardwareMap.dcMotor.get("brazo");
        //Control hub
        elev =  hardwareMap.dcMotor.get("elev");
        elev2 = hardwareMap.dcMotor.get("elev2");
        //expansion hub





    }

    @Override
    public void loop() {
        elev.setPower(gamepad2.left_stick_y);
        elev2.setPower(gamepad2.left_stick_y);
        brazo.setPower(gamepad2.right_stick_y);

        if (gamepad2.a) {
            garra.setPosition(0);
        }

        if (gamepad2.b) {
            garra.setPosition(1);
        }
        if (gamepad2.right_bumper) {
            rotador.setPosition(0);
        }
        if (gamepad2.left_bumper) {
            rotador.setPosition(1);
        }
        if(gamepad2.y){
            rotador.setPosition(0.5);
        }
        double drive  = -gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double twist  = gamepad1.right_stick_x;


        double[] speeds = {
                (drive + strafe + twist),
                (drive - strafe - twist),
                (drive - strafe + twist),
                (drive + strafe - twist)
        };


        double max = Math.abs(speeds[0]);
        for(int i = 0; i < speeds.length; i++) {
            if ( max < Math.abs(speeds[i]) ) max = Math.abs(speeds[i]);
        }


        if (max > 1) {
            for (int i = 0; i < speeds.length; i++) speeds[i] /= max;
        }
        if (gamepad1.right_bumper) {
            slowmode = !slowmode;
        }
        if(slowmode == false) {
            izqE.setPower(speeds[0]);
            derE.setPower(speeds[1]);
            izqA.setPower(-speeds[2]);
            derA.setPower(speeds[3]);
        }


    if (slowmode == true){
        izqE.setPower(speeds[0]*0.5);
        derE.setPower(speeds[1]*0.5);
        izqA.setPower(-speeds[2]*0.5);
        derA.setPower(speeds[3]*0.5);
      }
    }
}
//