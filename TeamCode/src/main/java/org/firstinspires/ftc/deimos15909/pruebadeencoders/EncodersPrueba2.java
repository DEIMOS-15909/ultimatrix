package org.firstinspires.ftc.deimos15909.pruebadeencoders;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "EncodersPrueba2")
public class EncodersPrueba2 extends OpMode {

    DcMotor FR = null;
    DcMotor FL = null;
    DcMotor BR = null;
    DcMotor BL = null;

    final double TICkS_PER_REV = 537.6;       // EG: TETRIX Motor Encoder
    final double DRIVE_GEAR_REDUCTION = 1; // This is < 1.0 if geared up
    final double WHEEL_DIAMETER_INCHES = 3.77953; // PARECE ESTAR YA BIEN (EQUIVALENCIA EN INCH)
    double COUNTS_PER_INCH = (TICkS_PER_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    @Override
    public void init(){

        FL = hardwareMap.get(DcMotor.class, "FL");
        FR = hardwareMap.get(DcMotor.class, "BL");
        BL = hardwareMap.get(DcMotor.class, "BL");
        BR = hardwareMap.get(DcMotor.class, "BR");
        //this command below resets any data on the encoder and makes sure it is 0
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // this offsets the 2 motors that are facing the opposite direction.
        FR.setDirection(DcMotor.Direction.REVERSE);
        BR.setDirection(DcMotor.Direction.REVERSE);

    }
    @Override
    public void loop(){

    }

    public void encoderDrive(double speed, double leftInches, double rightInches) {
// this creates the variable that will be calculated
        int newLeftFrontTarget = 0;
        int newRightFrontTarget = 0;
        int newLeftBackTarget = 0;
        int newRightBackTarget = 0;
// calculate distance that robot has to move
        newLeftFrontTarget = FL.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
        newRightFrontTarget = FR.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
        newRightBackTarget = BR.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
        newLeftBackTarget = BL.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
        // this gets the position and makes the robot ready to move
        FL.setTargetPosition(newLeftFrontTarget);
        FR.setTargetPosition(-newRightFrontTarget);
        BR.setTargetPosition(newRightBackTarget);
        BL.setTargetPosition(-newLeftBackTarget);

        //the robot will run to that position and stop once it gets to the postion
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //this gets the absolute speed and converts it into power for the motor
        FR.setPower(Math.abs(speed));
        FR.setPower(Math.abs(speed));
        FR.setPower(Math.abs(speed));
        FR.setPower(Math.abs(speed));

        FR.setPower(0);
        FL.setPower(0);
        BR.setPower(0);
        BL.setPower(0);
        //the robot will run to that position
        FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //reset all encoders
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);








    }
}
