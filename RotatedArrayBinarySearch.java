//asked at Microsoft coding round
public class RotatedArrayBinarySearch 
{
	public static void main(String args[])
	{
		int[] a = {1,2,3,4,5,6,7,8,9,10,0};
		System.out.println(findIndex(a,0));
	}
	public static int findIndex(int[] a, int key)
	{
		int low =0;
		int high = a.length*2;
		int mid = (low+high)/2;
		while(low<high)
		{
			if(mid>=a.length)
			{
				int tempmid = mid-a.length;
				if(a[tempmid]>key)
				{
					high = mid;
					mid = (low+high)/2;
				}
				else if(a[tempmid]<key)
				{
					low = mid;
					mid = (low+high)/2;
				}
				else //a[tempmid]==key				{
				{
					return tempmid;
				}
			}
			else
			{
				if(a[mid]>key)
				{
					high = mid;
					mid = (low+high)/2;
				}
				else if(a[mid]<key)
				{
					low = mid;
					mid = (low+high)/2;
				}
				else //a[mid]==key				
				{
					return mid;
				}
			}
		}
		return -1;
	}
}
