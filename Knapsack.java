package quora;

import java.util.Arrays;

public class Knapsack 
{
	public static void main(String args[])
	{
		int n = 3;
		int w = 5;
		int[] score = { 100, 50, 50};
		int[] height = { 4, 2, 2};
		int[][] v = new int[n+1][w+1];
		int[][] keep = new int[n+1][w+1];
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=w;j++)
			{
				if(i==0||j==0)
                {
                    v[i][j]=0;
                    keep[i][j]=0;
                }
                else if(height[i-1]>j)
                {
                    v[i][j]=v[i-1][j];
                    keep[i][j]=0;
                }
                else  
                {
                    v[i][j]=Math.max(v[i-1][j],score[i-1]+v[i-1][j-height[i-1]]);
                    if(v[i][j]==score[i-1]+v[i-1][j-height[i-1]])
                    {
                        keep[i][j]=1;
                    }
                }
			}
		}
		System.out.println("Keep:");
		for(int i=0;i<keep.length;i++)
        {
            System.out.println(Arrays.toString(keep[i]));
        }
		System.out.println("V:");
		for(int i=0;i<v.length;i++)
        {
            System.out.println(Arrays.toString(v[i]));
        }
		System.out.println(v[n][w]);
		int a = v[n][w];
		int nc = n;
		int wc = w;
		while(v[nc][wc]==a)
		{
			System.out.println("Iterate");
			while(n!=0)
			{
				if(keep[n][w]==1)
				{
					int ncopy =n;
					while(v[n-1][w]==a)
					{
						n=n-1;
					}
					for(int k=n;k<=ncopy;k++)
					{
						if(keep[k][w]==1)
						{
							n=k;
							break;
						}
					}
					//take n,H
					n=n-1;
					w = w - height[n];
					System.out.println(" "+(n+1));
				}
				else
				{
					n = n-1;
				}
				
			}
			wc--;
			nc--;
			w=wc;
			n=nc;
		}
	}
}
