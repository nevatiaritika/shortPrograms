package quora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FeedOptimizer
{
	static int N, W, H, minid=0;
	static int[] storytime, storyscore, storyheight;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		W = Integer.parseInt(s[1]);
		H = Integer.parseInt(s[2]);
		storytime = new int[N];
		storyscore = new int[N];
		storyheight = new int[N];
		int idcounter = 0;
		for(int i=0;i<N;i++)
		{
			String[] in = br.readLine().split(" ");
			char type = in[0].charAt(0);
			if(type=='S')
			{
				storytime[idcounter]=Integer.parseInt(in[1]);
				storyscore[idcounter]=Integer.parseInt(in[2]);
				storyheight[idcounter]=Integer.parseInt(in[3]);
				idcounter++;
			}
			else if(type=='R')
			{
				if(W!=0)
				{
					reload(idcounter-1,Integer.parseInt(in[1]));
				}
				else
				{
					System.out.print("0 0");
				}
				System.out.println();
			}
		}
	}
	public static void reload(int maxid, int time)
	{
		while(time-storytime[minid]>W)
		{
			minid++;
		}
		int n = maxid-minid+1;
		int[][] v = new int[n+1][H+1];
		int[][] keep = new int[n+1][H+1];
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=H;j++)
			{
				if(i==0||j==0)
				{
					v[i][j]=0;
					keep[i][j]=0;
				}
				else if(storyheight[i-1+minid]<=j)
				{
					if(v[i-1][j]<storyscore[i-1+minid]+v[i-1][j-storyheight[i-1+minid]])
					{
						keep[i][j]=1;
						v[i][j]=storyscore[i-1+minid]+v[i-1][j-storyheight[i-1+minid]];
					}
					else
					{
						keep[i][j]=0;
						v[i][j]=v[i-1][j];
					}
				}
				else
				{
					v[i][j]=v[i-1][j];
					keep[i][j]=0;
				}
			}
		}
		int hcopy = H;
		System.out.print(v[n][H]);
		StringBuilder sb = new StringBuilder();
		int count=0;
		while(n!=0)
		{
			if(keep[n][hcopy]==1)
			{
				int ncopy =n;
				int a = v[n][hcopy];
				while(v[n-1][hcopy]==a)
				{
					n=n-1;
				}
				for(int k=n;k<=ncopy;k++)
				{
					if(keep[k][hcopy]==1)
					{
						n=k;
						break;
					}
				}
				//take n,H
				n=n-1;
				int temp = n+minid;
				hcopy = hcopy - storyheight[temp];
				sb.append((temp+1)+" ");
				count++;
			}
			else
			{
				n = n-1;
			}
		}
		sb.append(count+" ");
		sb.reverse();
		System.out.print(sb.toString());
	}
}
/*
 * if(keep[n][hcopy]==1)
			{
				//take n,H
				n=n-1;
				int temp = n+minid;
				hcopy = hcopy - storyheight[temp];
				sb.append(temp+1+" ");
				count++;
			}*/
