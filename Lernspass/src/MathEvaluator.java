import java.util.ArrayList;

public class MathEvaluator {

	
	public static ArrayList<Character> allChar = new ArrayList<Character>();
	
	
	
	
	public static double evaluateInput(String calc) {
		
		//INIT CHARS
		allChar.add('l');
		allChar.add('r');
		allChar.add('s');
		allChar.add('c');
		allChar.add('^');
		allChar.add('*');
		allChar.add('/');
		allChar.add('%');
		
		allChar.add('+');
		allChar.add('-');
		
		
		
		//------------------------
		calc = replaceExpressions(calc);
		System.out.println("REPLACED "+calc);
		calc = removeSpace(calc);
		calc = calcBracket(calc);
		System.out.println("TEXT R"+calc);
		
		return unfoldDouble(calc);
	}
	
	public static String replaceExpressions(String calc) {
		
		calc = calc.replace("sin","s");
		calc = calc.replace("cos","c");
		calc = calc.replace("sqrt","r");
		calc = calc.replace("pi",""+Math.PI);
		calc = calc.replace("e",""+Math.E);
		calc = calc.replace("ln","l");
		return calc;
	}
	
	public static String calcBracket(String calc) {
		
		int closingBracket = -1;
		int lastBracket = -1;
		for (int i = 0;i< calc.length();i++) {
			if (calc.charAt(i) == '(') {
				lastBracket = i;
			}
			if (calc.charAt(i) == ')') {
				closingBracket = i;
				break;
			}
		}
		
	
		if (lastBracket == -1) {
			return calcAllChars(calc);
		}
		else {
			String result = calcAllChars(calc.substring(lastBracket+1,closingBracket));
			result = calc.substring(0,lastBracket) +result+calc.substring(closingBracket+1,calc.length());
			
			System.out.println("RESDEB "+ result);
			return calcBracket(result);
		}
	
		
		
		
	}
	public static String calcAllChars(String calc) {
		
		for (char c : allChar) {
			if (calc.contains(c+"")) {
				calc = calcChars(calc , c);
			}
			
		}
		return calc;
	}
	
	
	public static String calcChars(String calc,char c) {
		
		String ori = calc;
		System.out.println("["+c+"] --- "+calc);
		while (true) {
			int i = findCharNextIndex(calc, c);
			if ( i == -1 || onlyOneNumberLeft(calc)) {
				break;
			}
			calc = calc.substring(0,getNBIndex(calc, i)) + foldDouble(calculate(getNB(calc, i), getNF(calc, i), c)) +calc.substring(getNFIndex(calc, i),calc.length());
			System.out.println("["+i+"] --- "+calc);
			//System.out.println( calculate(getNB(calc, i), getNF(calc, i), c));
			//calc = calc.substring(i+1,getNFIndex(calc, i));
		}
		
	
		return calc;
	}
	
	
	public static boolean onlyOneNumberLeft(String calc) {
		
		return calc.matches("-?[\\d.?]+") || calc.matches("-?[\\d.?]+E-?[\\d.?]+");
		
	}
	
	public static double calculate(double a,double b,char operator) {
		
		
		if (operator == '+') {
			return a + b;
		}
		if (operator == '-') {
			return a - b;
		}
		if (operator == '*') {
			return a * b;
		}
		if (operator == '/') {
			return a / b;
		}
		if (operator == '%') {
			return a % b;
		}
		if (operator == '^') {
			return Math.pow(a,b);
		}
		if (operator == 'r') {
			return Math.sqrt(b);
		}
		if (operator == 's') {
			return Math.sin(b);
		}
		if (operator == 'c') {
			return Math.cos(b);
		}
		if (operator == 'l') {
			return Math.log(b);
		}
		return 0;
	}
	
	public static String foldDouble(double d) {
		String out = ""+d;
		
		return out.replace("E-", "N");
	}
	public static double unfoldDouble(String s) {
		String o = s.replace("N", "E-");
		
		return Double.parseDouble(o);
	}
	public static int getNBIndex(String calc,int index) {
		int i = index-1;
		
		while (i >= 0) {
			char c = calc.charAt(i);
		
			
			
			i--;
		
			if ((!isPartOfDouble(c) && c != '.')) {
				i++;
				if (c == '-' && !indexIsDigit(calc, i-1)) {
					i--;
					
				}
				break;
			}
		}
		return i+1;
	}
	
	public static int getNFIndex(String calc,int index) {
		int i = index+1;
		
		while (i < calc.length()) {
			char c = calc.charAt(i);
			
		
			if (i == index+1) {
				if (c == '-') {
					i++;
					continue;
				}
			}
			
			i++;
			if (!isPartOfDouble(c) && c != '.') {
				i--;
				break;
			}
		}
		return i;
	}
	
	public static boolean isPartOfDouble(char c) {
		if (Character.isDigit(c) || c == '.' || c == 'E'|| c == 'N') {
			return true;
		}
		return false;
	}
	public static double getNB(String calc,int index) {
		String number = "";
		
		for (int i = index-1;i>=0;i--) {
			char c = calc.charAt(i);
			if ((isPartOfDouble(c) || c == '.')) {
				number = c+number;
			}
			else {
				if (c == '-' && !indexIsDigit(calc, i-1)) {
					number = c+number;
				}
				break;
			}
		}
		System.out.println("[CALC NB] "+calc +" [RES] "+number);
		if (number.isEmpty()) {
			number = "0";
		}
		return unfoldDouble(number);
	}
	
	
	public static double getNF(String calc,int index) {
		String number = "";
		for (int i = index+1;i<calc.length();i++) {
			char c = calc.charAt(i);
			if ((isPartOfDouble(c) || c == '.') || (i ==  index+1&& c == '-')) {
				number = number+c;
			}
			else {
				break;
			}
		}
		System.out.println("[CALC NF] "+calc +" [RES] "+number);
		return unfoldDouble(number);
	}
	
	public static boolean indexIsDigit(String s,int index) {
		if (index < 0 || index >= s.length()) {
			return false;
		}
		
		return (Character.isDigit( s.charAt(index)));
		
	}
	public static String removeSpace(String calc) {
		
		return calc.replace(" ", "");
	}
	
	public static int diffrentCount(String calc) {
		
		
		
		int count = 0;
		for (char c : allChar) {
			if (containsChar(calc, c)) {
				count+= 1;
			}
		}
		
		return count;
	}
	
	
	public static boolean containsChar(String s,char c) {
		for (int i = 0;i<s.length();i++) {
			if (s.charAt(i)== c) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static int findCharNextIndex(String s,char c) {
		
		ArrayList<Integer> index = new ArrayList<Integer>();
		for (int i = 0;i<s.length();i++) {
			if (s.charAt(i)== c) {
				return i;
			}
		}
		
		return -1;
	}
}
