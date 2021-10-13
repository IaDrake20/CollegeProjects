import org.graalvm.compiler.api.replacements.Snippet.VarargsParameter;

// A class containing static methods for dealing with postfix expressions
// The two public static methods are for 
//     1. coverting an infix expression to a postfix expression
//     2. evaluating a postfix expression
// The private static methods are helper methods that are called
// by the public static methods as necessary
// You have to complete all the methods using the comments within the code


public class Postfix 
{
	public static String convertToPostfix(String infix)
	{
		LinkedStack<Character> operatorStack = new LinkedStack<>();
		// String postfix = a new empty String
		String postfix = "";
		
		char topOperator;

		//Set up loop to iterate through characters in infix
		for(int i = 0; i < infix.length(); i++){

			//do something with infix.charAt(i);
		} 

		{
			//char nextCharacter = next character of infix

			if (Character.isLetter(nextCharacter)){
				// Append nextCharacter to postfix
				postfix += nextCharacter;
			}

				
			else {
				switch (nextCharacter)
				{
					case '+': case '-': case '*': case '/':
						// while operatorStack is not empty and 
						// precedence of nextCharacter <= precedence of operatorStack.peek()
			
			
						{
							// Append operatorStack.peek() to postfix;
							postfix += operatorStack.pop();
						} 
 
						operatorStack.push(nextCharacter);
						break;
				   
					case '(':
						operatorStack.push(nextCharacter);
						break;

					case ')': 
						topOperator = operatorStack.pop();
						while (topOperator != '(')
						{
							//Append topOperator to postfix

							postfix += topOperator;
						} 
						break;

					default: break; // Ignore unexpected characters
				}
			}
		}
    
		while (!operatorStack.isEmpty())
		{
			topOperator = operatorStack.pop();
			//Append topOperator to postfix

		} 
		return postfix.toString();
	}

	// Indicates the precedence of a given operator.
	// Precondition: operator is a character that is (, ), +, -, *, or /.
	// Returns an integer that indicates the precedence of operator:
	//         0 if ( or ), 1 if + or -, 2 if * or /, 
	//         -1 if anything else. 
	private static int getPrecedence(char operator){

		switch(operator){
			case '+': return 1;
			case '-': return 1;
			case '*': return 2;
			case '/': return 2;

			default: 
			System.out.println("An operator is not present in the variable operator.");
		}

		//if this returns -1, something went wrong
		return -1;
	}


	public static double evaluatePostfix(String postfix)
	{
		LinkedStack<Double> valueStack = new LinkedStack<>();
      
		// loop to iterate through postfix
		for(int i =0; i < postfix.length(); i++){

			valueStack.pop(postfix.charAt(i));
		}
		
		{
		
			//nextCharacter = next character in postfix
		
			if (Character.isLetter(nextCharacter))
				valueStack.push(valueOf(nextCharacter));  // check
			else {
				switch(nextCharacter)  {
				   
					case '+': case '-': case '*': case '/': case '^':
						double operandTwo = valueStack.pop();
						double operandOne = valueStack.pop();
						// result = the result of the operation in nextCharacter 
						// and its operands operandOne and operandTwo

						valueStack.push(result);
						break;
					   
					default: break; // Ignore unexpected characters
				}
			}
		}       
		return (valueStack.peek()).doubleValue();
	}

	// method to set values of 2.0 for a, 3.0 for b, 4.0 for c
	// 5.0 for d and 6.0 for e. Other values are assigned 0
	private static double valueOf(char variable){

		switch(variable){

			case 'a': variable = 2.0;
			break;

			case 'b': variable = 3.0;
			break;

			case 'c': variable = 4.0;
			break;

			case 'd': variable = 5.0;
			break;

			case 'e': variable = 6.0;
			break;

			default: 
			System.out.println("I don't recognize the input. \n Error report from method valueOf(char) at line 140. \n");
		}
	}

	// method to calculate the result of two operands with
	// an operator which is either +, -, * or /
	private static double compute(double operandOne, double operandTwo, char operator){
		
		switch(operator){

			case '+': return operandOne + operandTwo;
			case '-': return operandOne - operandTwo;
			case '*': return operandOne * operandTwo;
			case '/': return operandOne / operandTwo;
		}

		return Math.PI; //return pii for the lols
	}
} 
                 
