package org.firstinspires.ftc.deimos15909;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name = "Life is a highway", group =  "autonomo")
public class Life_is_a_highway extends LinearOpMode {
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
        //motores control hub
        Brazito = hardwareMap.dcMotor.get("Brazito");
        Elev =  hardwareMap.dcMotor.get("Elev");
        Elev2 = hardwareMap.dcMotor.get("Elev2");
        Elev3 = hardwareMap.dcMotor.get("Elev3");
        //motores expansion hub
        Carpus = hardwareMap.servo.get("Carpus");
        DeChill = hardwareMap.servo.get ("DeChill");
        DeChill2 = hardwareMap.servo.get("DeChill2");
        Garrita = hardwareMap.servo.get("Garrita");
        waitForStart();


    }
}
