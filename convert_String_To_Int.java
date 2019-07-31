import java.util.Scanner;
public class convert_String_To_Int 
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		String kbInput;
		int result;
		char choice;
		boolean convert;
		System.out.print("Enter a string to convert to an integer: ");
		kbInput=s.next();
		System.out.println("If a Non-numeric character is detected would you like to convert it to its ASCII value?\nType 'y' for yes and 'n' for no.");
		choice=s.next().charAt(0);
		if(convertToAscii(choice))
		{
			convert=true;
		}
		else
		{
			convert=false;
		}
		result=convertStringToInt(kbInput,convert);
		System.out.println("The converted string result: "+result);
		
	}
	public static int convertStringToInt(String input,boolean convert)
	{
		int convertedNum=0, factor=10, asciiValue, iterator=0;
		boolean isNegative=false;
		if(input.charAt(0)=='-')
		{
			isNegative=true;
			iterator=1;  //skip first char if negative
		}
		while(iterator<input.length()) //iterating through string
		{
			if(!Character.isDigit(input.charAt(iterator)))
			{
				if(convert)
				{
					asciiValue=(int)input.charAt(iterator);
					if(asciiValue>9 && asciiValue<100)   //if ascii value is 2 digits, have to move over by 2
					{
						factor=100;
					}
					else if(asciiValue>100) //if ascii value is 3 digits, have to move over by 3
					{
						factor=1000;
					}
					try //checks for overflow/underflow
					{
						convertedNum=Math.multiplyExact(convertedNum,factor); 
						convertedNum=Math.addExact(convertedNum, asciiValue);
					}
					catch(ArithmeticException e)
					{
						if(isNegative)
						{
							convertedNum*=-1;
						}
						System.out.println("The resulting conversion will result in an under/overflow. Returning converted result so far.\n");
						return convertedNum;
					}
				}
			}
			else
			{
				factor=10; 
				try
				{
					convertedNum=Math.multiplyExact(convertedNum,factor); 
					convertedNum=Math.addExact(convertedNum, Character.getNumericValue(input.charAt(iterator)));
				}
				catch(ArithmeticException e)
				{
					if(isNegative)
					{
						convertedNum*=-1;
					}
					System.out.println("The resulting conversion will result in an under/overflow. Returning converted result.\n");
					return convertedNum;
				}
			}
			iterator++;
		}
		if(isNegative)
		{
			convertedNum*=-1;
		}
		return convertedNum;
	}
	public static boolean convertToAscii(char answer)  //gets result for if user wants to convert to ASCII
	{
		if(answer=='y' || answer=='Y')
		{
			System.out.println("Non-numeric character(s) will be converted to ascii");
			return true;
		}
		else if(answer=='n'||answer=='N')
		{
			System.out.println("Non-numeric character(s) will be ignored.");
			return false;
		}
		else
		{
			System.out.println(answer+" is an invalid input. Ignoring non-numeric character(s).");
			return false;
		}
	}
}
