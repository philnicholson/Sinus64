package com.phil;

/* C64 Logo Sinus
 * --------------
 *
 * X = number of chars to left of logo * 8 (pixels)
 *
 * Example: X = 40, 4096=$1000
 *
 * FOR A=0TO255:B=INT(X+(X*COS(A*(360/256))))
 * POKE 4096+A,B:NEXT
 *
 * Cos is the ratio of the adjacent side to the hypotenuse so returns values from -1 to +1 cos(0)=1, cos(90)=0
 * 360/256 divides the 360 degrees of a circle into 256 (perfect for C64 memory)
 * Formula COS(A*(360/256)) gives numbers from -1 to +1
 * The "40 *" scales the numbers from -40 to +40
 * The "40 +" moves the graph up to positive numbers 0 to +80
 *
 * This example will give a range of values between 0 and 80. Copy output to Excel and plot graph to see curve.
 */

public class Sinus {

    public static void main(String[] args) {

        for(int i=0; i<256; i++) {
            // Kick Assembler version:
            // fill 256, 127.5 + 127.5*sin(toRadians(i*360/256)) // Generates a sine curve

            // i*360/256 = divided 360 (circle!) by the 256 data points we want, multiply by i to move through each

            double d = 40 + (40 * Math.cos(Math.toRadians(i*(360.0d/256.0d))));       //   Use i/20.0d else it is converted to an int here

            //System.out.println(i + "->" + String.format("%.7f", d));

            long l = Math.round(d);
            //System.out.println(i + "->" + l);
            System.out.println(l);

        }
    }
}
