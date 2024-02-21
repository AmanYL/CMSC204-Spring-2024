
public class TheBabaorae {

//	public static String infixToPostfix(String infix) throws StackOverflowException, StackUnderflowException {
//        StringBuilder postfix = new StringBuilder();
//        MyStack<Character> stack = new MyStack<>(100);
//
//        for (char c : infix.toCharArray()) {
////            if (Character.isLetterOrDigit(c)) {
////                postfix.append(c);
////            } else if (c == '(') {
////                stack.push(c);
////            } else if (c == ')') {
////                while (!stack.isEmpty() && stack.top() != '(') {
////                    postfix.append(stack.pop());
////                }
////                stack.pop(); // Discard the '('
////            } else { // Operator
////                while (!stack.isEmpty() && precedence(c) <= precedence(stack.top())) {
////                    postfix.append(stack.pop());
////                }
////                stack.push(c);
////            }
////        }
////
////        while (!stack.isEmpty()) {
////            postfix.append(stack.pop());
////        }
////
////        return postfix.toString();
////    }
////
////    private static int precedence(char operator) {
////        switch (operator) {
////            case '+':
////            case '-':
////                return 1;
////            case '*':
////            case '/':
////                return 2;
////            default:
////                return 0;
////        }
//    }

    public static void main(String[] args) throws StackOverflowException, StackUnderflowException, InvalidNotationFormatException, QueueOverflowException {
//        String infix = "a+b*c-(d/e+f)*g";
//        String postCheck23 = "abc*+de/f+g*-";
//        String postfix = Notation.convertInfixToPostfix​(infix);
//        String infixCheck23 = Notation.convertPostfixToInfix(postCheck23);
//        System.out.println("Infix: " + infixCheck23);
//        System.out.println("Postfix: " + postfix); //abc*+de/f+g*-
        
        String invalidInfixExpression = "A+B*C+D-+G43+-*G";
        String testCa_1 = Notation.convertInfixToPostfix(invalidInfixExpression);
        System.out.println(testCa_1);
        
        String invalidPostfixExpression = "354+*-";
        String testCa_2 = Notation.convertPostfixToInfix(invalidPostfixExpression);
        System.out.println(testCa_2);
    	
//    	String invalidPostfixExpression = "354+*-";
//        String testCa_3 = Notation.convertPostfixToInfix(invalidPostfixExpression);
//        System.out.println(testCa_3);
        
    }
}
