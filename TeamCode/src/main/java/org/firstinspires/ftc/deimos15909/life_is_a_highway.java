package org.firstinspires.ftc.deimos15909;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "liah", group = "control")
public class life_is_a_highway extends LinearOpMode {

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
    Servo DeChill;
    Servo DeChill2;

    @Override
    public void runOpMode() throws InterruptedException {
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


        waitForStart();
        Izqe.setPower(1);
        Dera.setPower(1);
        Izqa.setPower(-1);
        Dere.setPower(1);
        sleep(700);
        Izqe.setPower(-0.7);
        Dera.setPower(0.7);
        Izqa.setPower(-0.7);
        Dere.setPower(0.7);
        sleep(700);
        Izqe.setPower(0);
        Dera.setPower(0);
        Izqa.setPower(0);
        Dere.setPower(0);


    }
}
