// 실행시간: 80 ms
// 메모리: 11472 kb

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException { 
		// 중위표기식을 후위표기식으로 표현
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		Stack<Character> stack = new Stack<>(); // 연산자를 저장한다.
				
		// 피연산자 A~Z, 연산자 +, -, *, /, (, )
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if('A' <= ch && ch <= 'Z') sb.append(ch); // 피연산자인 경우 바로 출력
			else {
				switch(ch) {
				case '(': 
					stack.push(ch);
					break;
				case ')':
					while(!stack.isEmpty()) {
						char tmp = stack.pop();
						if (tmp == '(') break;
						sb.append(tmp);
					}
					break;
				default: // +, -, *, /
					
					// 들어오는 연산자가 스택의 top 위치의 연산자보다 우선순위가 작거나 같으면 출력
					while(!stack.isEmpty() && isAvaiable(stack.peek(), ch))
						sb.append(stack.pop());
					stack.push(ch);
				}
			}
		}
		
		// stack에 남아있다면 연산자 제거
		while(!stack.isEmpty()) sb.append(stack.pop());
		
		System.out.println(sb);
	}
	
	// 두 연산자의 우선순위 비교. op1의 우선순위가 크면 true 리턴.
	public static boolean isAvaiable(char op1, char op2) {
		int p1 = priority(op1);
		int p2 = priority(op2);
		
		if (p2 <= p1) return true;
		else return false;
	}
	
	// 연산자 우선순위를 반환하는 메소드
	public static int priority(char op) {
		int num = 0;
		switch(op) {
		case '*': case '/': num = 2; break;
		case '+': case '-': num = 1; break;
		case '(': num = 0; break;
		}
		return num;
	}
}
