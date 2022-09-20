package org.firstinspires.ftc.deimos15909;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Ultimatrix", group = "Control")
public class TotiosEvo extends OpMode {

    DcMotor Izqe;
    DcMotor Dere;
    DcMotor Izqa;
    DcMotor Dera;
    DcMotor Brazito;
    DcMotor Elev;
    DcMotor Elev2;
    DcMotor Elev3;
    Servo Garrita;
    Servo Carpus;
    Servo Burgir;
    Servo DeChill2;
    Servo DeChill;


    @Override
    public void init() {
        Izqe = hardwareMap.dcMotor.get("Izqe");
        Izqa = hardwareMap.dcMotor.get("Izqa");
        Dere = hardwareMap.dcMotor.get("Dere");
        Dera = hardwareMap.dcMotor.get("Dera");
        //MOTORES CONTROLHUB

        Brazito = hardwareMap.dcMotor.get("Brazito");
        Elev =  hardwareMap.dcMotor.get("Elev");
        Elev2 = hardwareMap.dcMotor.get("Elev2");
        Elev3 = hardwareMap.dcMotor.get("Elev3");
        //MOTORES EXPANSION

        Carpus = hardwareMap.servo.get("Carpus");
        DeChill = hardwareMap.servo.get ("DeChill");
        DeChill2 = hardwareMap.servo.get("DeChill2");
        Garrita = hardwareMap.servo.get("Garrita");
        Burgir  = hardwareMap.servo.get("burigir");

    }

    @Override
    public void loop() {
        Elev.setPower(gamepad2.left_stick_y);
        Elev2.setPower(gamepad2.left_stick_y);
        Brazito.setPower(gamepad2.right_stick_y);
        Elev3.setPower(gamepad2.right_trigger);
        Elev3.setPower(-gamepad2.left_trigger);

        if(gamepad2.a){
            Carpus.setPosition(1);
        }

        if(gamepad2.b)
            Carpus.setPosition(0);



        if(gamepad2.x){
            Burgir.setPosition(0.51);
        }
        else{
            Burgir.setPosition(1);

        if(gamepad2.b){
            Garrita.setPosition(0);
        }
        else {
            Garrita.setPosition(.5);
        }
        }

        if(gamepad2.right_bumper){


        }
        if(gamepad2.b){

            Garrita.setPosition(0);
        }
         if(gamepad2.left_bumper){
             Garrita.setPosition(1);
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


        Izqe.setPower(speeds[0]);
        Dere.setPower(speeds[1]);
        Izqa.setPower(-speeds[2]);
        Dera.setPower(speeds[3]);

    }
}
