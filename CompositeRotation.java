//Author - Ritika

package rai;

import java.util.Scanner;

public class CompositeRotation {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value for Yaw: ");
		double yaw = sc.nextFloat()*3.14/180;
		System.out.println("Enter the value for Pitch: ");
		double pitch = sc.nextDouble()*3.14/180;
		System.out.println("Enter the value for Roll: ");
		double roll = sc.nextDouble()*3.14/180;
		double sinyaw = Math.sin(yaw);
		double cosyaw = Math.cos(yaw);
		double sinpitch = Math.sin(pitch);
		double cospitch = Math.cos(pitch);
		double sinroll = Math.sin(roll);
		double cosroll = Math.cos(roll);
		System.out.println("Enter the (x,,y,z) coordinate of the initial position of tool tip:");
		float[][] s = new float[3][1];
		s[0][0]= sc.nextFloat();
		s[1][0]= sc.nextFloat();
		s[2][0]=sc.nextFloat();
		sc.close();
		double[][] r = new double[3][3];
		r[0][0]= cospitch*cosroll;
		r[0][1]= sinyaw*sinpitch*cosroll - cosyaw*sinroll;
		r[0][2]= cosyaw*sinpitch*cosroll + sinyaw*sinroll;
		r[1][0]= cospitch*sinroll;
		r[1][1]= sinyaw*sinpitch*sinroll + cosyaw*cosroll;
		r[1][2]= cosyaw*sinpitch*sinroll - sinyaw*cosroll;
		r[2][0]= -sinpitch;
		r[2][1]= sinyaw*cospitch;
		r[2][2]=cosyaw*cospitch;
		System.out.println("Composite Matrix is:");
		for(int i=0;i<3;i++)
		{
			float x1=0;
			for(int j=0;j<3;j++)
			{
				x1 += r[j][i]*s[j][0];
			}
			System.out.println(x1);
		}
	}

}

/*Output:
 * Enter the value for Yaw: 
30
Enter the value for Pitch: 
45
Enter the value for Roll: 
60
Enter the (x,,y,z) coordinate of the initial position of tool tip:
2 1 3
Composite Matrix is:
-0.80000854
0.65370655
3.5962*/
