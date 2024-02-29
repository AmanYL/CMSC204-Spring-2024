import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<String>();

		stack.push("Minecraft");
		stack.push("Gordon Muray Auto");
		stack.push("Rimac Automobilli");
		stack.push("Hennesy");
		stack.push("Toyota");
		
		String s1 = stack.pop();
		String s2 = stack.peek();
		
		System.out.println(s1);
		System.out.println(s2);
		
		
	
	}

}
