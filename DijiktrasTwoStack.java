//evaluates expressions

import java.util.Scanner;
import java.util.Stack;


public class DijiktrasTwoStack
{
	public static void main(String args[])
	{
		Stack<Character> ops = new Stack<Character>();
		Stack<Integer> values = new Stack<Integer>();
		System.out.println("Enter expression:");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		for(int i=0;i<input.length();i++)
		{
			char ch = input.charAt(i);
			if(ch=='(')
			{
			}
			else if(ch=='+')
			{
				ops.push('+');
			}
			else if(ch=='*')
			{
				ops.push('*');
			}
			else if(ch>='0' && ch<='9')
			{
				values.push((int)ch-48);
			}
			else if(ch==')')
			{
				int a = values.pop();
				int b = values.pop();
				int result=0;
				char op = ops.pop();
				if(op=='+')
				{
					result = a+b;
				}
				else if(op=='*')
				{
					result = a*b;
				}
				values.push(result);
			}
		}
		sc.close();
		System.out.println("Evaluation: "+values.pop());
	}
}
