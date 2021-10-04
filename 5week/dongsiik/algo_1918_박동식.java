//14152, 136
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class algo_1918_박동식 {

	public static void main(String args[]) throws IOException {
		// 입출력 도구
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//원본 문자열과 연산자들을 저장할 스택
		String src = br.readLine();
		Stack<Character> operations = new Stack<>();
		
		for(int i=0;i<src.length();i++) {
			//현재 문자
			char c = src.charAt(i);
			
			//알파벳이면 바로 출력문에 넣음
			if(Character.isUpperCase(c))
				sb.append(c);
			//여는 괄호라면 스택에 넣음
			else if(c=='(')
				operations.push(c);
			//닿는 괄호라면 여는 괄호가 나올때까지 연산자들을 다 출력문에 넣음
			else if(c==')') {
				while(operations.peek()!='(') 
					sb.append(operations.pop());
				operations.pop();
			}
			//연산자라면
			else {
				//지금보다 우선순위가 높은 애들을 스택에서 빼서 출력문에 넣음
				while(!operations.isEmpty() && getPriority(operations.peek())>=getPriority(c)) 
					sb.append(operations.pop());
				//지금 연산자를 스택에 넣음
				operations.push(c);
			}
		}
		
		//스택에 남은 연산자들을 출력문에 넣음
		while(!operations.isEmpty()) 
			sb.append(operations.pop());
		
		//출력
		System.out.println(sb);
	}
	
	//우선순위. 곱셈과 나눗셈이 덧셈과 뺄셈보다 우선순위가 높음
	static int getPriority(char c) {
		if(c=='*' || c=='/') return 2;
		else if(c=='+' || c=='-') return 1;
		else return 0;
	}
}