import java.util.Scanner;

public class contains_Integer 
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		System.out.print("Enter a string to check for an integer: ");
		String kbInput=s.next();
		boolean containsDigit=checkForNum(kbInput);
		if(containsDigit)
		{
			System.out.println("The string entered contains a number.");
		}
		else
		{
			System.out.println("The string entered does not contain a number.");
		}
		
	}
	public static boolean checkForNum(String input)
	{
		for(int i=0;i<input.length();i++)
		{
			if(Character.isDigit(input.charAt(i)))
			{
				return true;
			}
		}
		return false;
	}
}
