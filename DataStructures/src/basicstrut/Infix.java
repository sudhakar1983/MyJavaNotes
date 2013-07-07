package basicstrut;

import java.util.Stack;

public class Infix {
	
	private String infixStr;
	
	private Stack<Character> oprStack;

	public Infix(String infixStr){
		oprStack = new Stack<Character>();
		this.infixStr = infixStr;
	}
	
	public String toPostFix(){
		StringBuffer buf = new StringBuffer(infixStr.length());
		
		for(int i=0;i<infixStr.length();i++){
			char str = (infixStr.charAt(i));			
			if(valueOfOpr(str) == 0){
				buf.append(str);
				
				if(i != infixStr.length()-1 && !oprStack.isEmpty()){
					char nextChar = (infixStr.charAt(i+1));
					char opStack = oprStack.peek();
					
					int compare =  compareOperators (opStack,nextChar);	
					
					if(compare >0 && valueOfOpr(opStack) != 5) {
						opStack = oprStack.pop();
						buf.append(opStack);
					}
				}				
			}	
			
			if(i == infixStr.length()-1){
				if(valueOfOpr(str) > 0 && valueOfOpr(str) != 6) throw new RuntimeException("Invalid Expression");
				while(!oprStack.isEmpty()){
					char temp = oprStack.pop();
					if(valueOfOpr(temp) != 5)buf.append(temp);
				}
			}else if (valueOfOpr(str) > 0){
				
				if(oprStack.isEmpty()) {
					oprStack.push(str);
				}else{ 
					
					if(valueOfOpr(str) == 6){
						while(!oprStack.isEmpty()){
							char temp = oprStack.pop();
							if(valueOfOpr(temp) != 5)buf.append(temp);
						}					
					}else{
						char opStack = oprStack.pop();
						int compare =  compareOperators (opStack,str);	
						
						if(compare >0) {
							oprStack.push(str);oprStack.push(opStack);					
						}else{
							oprStack.push(opStack);oprStack.push(str);
						}	
					}
				}					
			}
			
			
			
		}
		
		return buf.toString();
	}
	
	
	public int compareOperators(char op1 , char op2){		
		return valueOfOpr( op1) - valueOfOpr( op2) ;
	}
	
	
	public int valueOfOpr(char op){
		int value = 0;
		
		switch (op) {
		case '*':
			value = 4;
			break;
		case '/':
			value = 3;
			break;
		case '+':
			value = 2;
			break;			
		case '-':
			value = 1;
			break;	
		case '[':			
		case ']':
		case '(':		
			value = 5;	
			break;
		case ')':
			value = 6;	
			break;			
		default:
			break;
		}
		
		return value;
	}
	
	
	
	public static void main(String[] args) {
		Infix i = new Infix("A+B");
/*		System.out.println("A+B -->"+i.toPostFix());
		i = new Infix("A+B-C");
		System.out.println("A+B-C -->"+i.toPostFix());
		
		i = new Infix("A+B*C");
		System.out.println("A+B*C -->"+i.toPostFix());
		i = new Infix("A*B+C");
		System.out.println("A*B+C -->"+ i.toPostFix());		
		i = new Infix("A/B+C");
		System.out.println("A/B+C -->"+i.toPostFix());
		i = new Infix("A+B/C");
		System.out.println("A+B/C -->"+ i.toPostFix());
		*/
		i = new Infix("A*(B+C)");
		System.out.println("A*(B+C) -->"+ i.toPostFix());
		
		i = new Infix("A*(B+C)*(D+E)");
		System.out.println("A*(B+C)*(D+E) -->"+ i.toPostFix());
		
		i = new Infix("A*(B+C)-D/(E+F)");
		System.out.println("A*(B+C)-D/(E+F) -->"+ i.toPostFix());		
		
		i = new Infix("A*(B+C)-D/(E+F)*G+H");
		System.out.println("A*(B+C)-D/(E+F)*G+H -->"+ i.toPostFix());
		
		i = new Infix("(A*B*(C+D))");
		System.out.println("(A*B*(C+D)) -->"+ i.toPostFix());
		
		i = new Infix("(A*B*(C+D)*E+F)");
		System.out.println("(A*B*(C+D)*E+F) -->"+ i.toPostFix());
		
	}
}
