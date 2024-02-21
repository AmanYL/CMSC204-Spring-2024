public class Notation {
	/**
	 * Converts a postfix expression to infix notation.
	 * 
	 * @param postfix The postfix expression to convert.
	 * @return The resulting infix expression.
	 * @throws InvalidNotationFormatException If the notation format is invalid.
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
		postfix = postfix.replaceAll("\\s","");
		String finalStr;
		MyStack<String> stack = new MyStack();
		for(int i=0; i<postfix.length(); i++) 
		{	
			char currentChar = postfix.charAt(i);
			
			if(Character.isLetterOrDigit(currentChar)) {
				try {
					stack.push(String.valueOf(currentChar));
				} catch (StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}		
			}
			else if(currentChar == '*' || currentChar == '/' || currentChar == '+' || currentChar == '-'){
				try
				{
					String num2 = stack.pop();
					String num1 = stack.pop();
					String str = '(' + num1 +currentChar+ num2 + ')';
					stack.push(str);
				} catch (StackUnderflowException | StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			}		
		}
		try {
			finalStr = (String)stack.pop();
		} catch (StackUnderflowException e) {
			throw new InvalidNotationFormatException();
		}
		if(!stack.isEmpty()) {
			throw new InvalidNotationFormatException();
		}
		return finalStr;
	}
	/**
	 * Converts an infix expression to postfix notation.
	 * 
	 * @param infix The infix expression to convert.
	 * @return The resulting postfix expression.
	 * @throws InvalidNotationFormatException If the notation format is invalid.
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		infix = infix.replaceAll("\\s", "");
		MyQueue<Character> queue = new MyQueue();
		MyStack<Character> stack = new MyStack();
		for(int i=0; i<infix.length(); i++)
		{
			char currentChar = infix.charAt(i);
			if(Character.isLetterOrDigit(currentChar)) {
				try {
					queue.enqueue(currentChar);
				} catch (QueueOverflowException e) {
					throw new InvalidNotationFormatException();					
				}	
			}
			else if(currentChar == '(')
				try {
					stack.push(currentChar);
				} catch (StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			else if(currentChar == ')') {
				try {
					while(!stack.isEmpty() && stack.top() != '(') {
						queue.enqueue(stack.pop());}
				} catch (StackUnderflowException | QueueOverflowException e) {
					throw new InvalidNotationFormatException();
				}
				try {
					stack.pop();//Discards the '('.
				} catch (StackUnderflowException e) {
					throw new InvalidNotationFormatException();
				} 
			}
			else if(currentChar == '*' || currentChar == '/' || currentChar == '+' || currentChar == '-'){
				try {
					while(!stack.isEmpty() && 
						  precedence(currentChar) <= precedence(stack.top())) {
						queue.enqueue(stack.pop());
					}
				} catch (StackUnderflowException | QueueOverflowException e) {
					throw new InvalidNotationFormatException();
				}
				try {
					stack.push(currentChar);
				} catch (StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			}
		}
		while(!stack.isEmpty())
			try {
				queue.enqueue(stack.pop());
			} catch (QueueOverflowException | StackUnderflowException e) {
				throw new InvalidNotationFormatException();
			}
		
		return queue.toString();
	}
	/**
	 * Evaluates a postfix expression and returns the result.
	 * 
	 * @param postfixExpr The postfix expression to evaluate.
	 * @return The result of the postfix expression evaluation.
	 * @throws InvalidNotationFormatException If the notation format is invalid.
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
		postfixExpr = postfixExpr.replaceAll("\\s", "");
		MyStack stack = new MyStack();
		double finalResult;
		for(int i=0; i<postfixExpr.length(); i++)
		{
			char currentChar = postfixExpr.charAt(i);
			double num1, num2;
			if(Character.isDigit(currentChar)) {
				try {
					stack.push(currentChar);
				} catch (StackOverflowException e) {
					System.out.println(e.getMessage());
				}
			}
			else if(currentChar == '*' || currentChar == '/' || currentChar == '+' || currentChar == '-') {
				try {
					num2 = Double.parseDouble(stack.pop().toString());
				} catch (NumberFormatException | StackUnderflowException e) {
					throw new InvalidNotationFormatException();
				}
				try {
					num1 = Double.parseDouble(stack.pop().toString());
				} catch (NumberFormatException | StackUnderflowException e) {
					throw new InvalidNotationFormatException();
				}
				try {
					switch(currentChar) {
					case '*':
						stack.push(num1 * num2);
						break;
					case '/':
						stack.push(num1 / num2);
						break;
					case '+':
						stack.push(num1 + num2);
						break;
					case '-':
						stack.push(num1 - num2);
						break;
					}
				} catch (StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			}
		}
		if(stack.size() == 1) {
			try {
				finalResult = (Double)stack.pop();
				return finalResult;
			} catch (StackUnderflowException e) {
				throw new InvalidNotationFormatException();
			}
		}
		else
			throw new InvalidNotationFormatException();
	}
	/**
	 * Determines the precedence of an operator.
	 * 
	 * @param oper The operator to determine precedence for.
	 * @return The precedence value.
	 */
	private static int precedence(char oper) {
		switch(oper) {
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			default:
				return 0;		
		}
	}
}
