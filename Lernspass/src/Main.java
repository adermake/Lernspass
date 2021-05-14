import java.util.Arrays;

public class Main {

	
	
	public static int a = 6;
	public static int b = 5;
	public static int c = 11;
	
	
	
	
    public static void main(String[] args) {
    	
    	System.out.println("RESULT: "+MathEvaluator.evaluateInput("2+2-1"));
    	
    	String a = "" +'a';
    	//System.out.println("RESULT: "+MathEvaluator.evaluateInput("1+sin(pi)"));
 
    	//- math
    	

       	//double d = Math.PI; //Speichert PI in einer double d
    	//System.out.println(Math.abs(-2)); // Gibt absoluten Wert von -2 aus (2)
    	
    	//- while
    	/*
    	int a = 2;
    	
   
    	while (a < 20) { 			
    		System.out.println(a);
    		
    		if (a == 7) {
    			
    		 
    		
    		a = a + 2; 
    		//a++;//a = a + 1; 	
    	}
    	*/
    	/*
    	int a = 0;
    	
    	while (a < 10) { 	
    		
    		
    		
    		a = a + 1;
    	}
    	
    	for (int i = 0; i<10 ;i=i+1) {
    		System.out.println(i);
    	}
    		
    		*/
    	/*
    	for (int i = 30; i>=-10;i--) {
    		System.out.println(i);
    		
    	}
    	*/
    	//int a = 2;
    	/*
    	int a = b;
    	
    	int[] z = new int[10]; //Int Array der Länge 10
    	//for (int i = 0; i<5 ;i = i + 1) { 		 		
    		//z[i] = i*4;  	
     	for (int i = 0; i<10;i = i + 1) { 		
     		z[i] = i + 1;   	
     		//System.out.println(i);  		
    	}
     	//System.out.println(Arrays.toString(z));
    	printArray(z);
    	
    
    	*/
    	
    	//- for
    	//- array
    	
    	
    	
    
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	/*
	int[] aArray = new int[] {0,1,2};
	int[] bArray = new int[1000];
	int[] cArray = new int[2000];
	for (int i = 0;i< bArray.length;i++) {
		bArray[i] = i;
	}
	int start = 1000;
	for (int i = 0;i< cArray.length;i++) {
		cArray[i] = start;
		start = start - 1;
	}
	
	printArray(aArray);
	printArray(bArray);
	printArray(cArray);
	
	printArray(createIntArray(-800, 100, -2));
	*/
    
    public static int[] createIntArray(int start,int end,int step) {
    	
    	
    	if ((start < end && step < 0) || (start > end && step>0)) {
    		return new int[0];
    	}
    	int distance = Math.abs(start-end);
    	int result[] = new int[distance/Math.abs(step)];
    	
    	
    	
    	
    	for (int i = 0;i< result.length;i++) {
    		
    		
    		result[i] = start;
    		start = start + step;
    	}
    	
    	return result;
    }
    
    
    public static void printArray(int[] ar) 
    {
    	String out = "[";
    	for (int i = 0;i< ar.length;i++) {
    		out += ar[i];
    		if (i < ar.length-1) {
    			out += " ";
    		}
    	}
    	out += "]";
    	System.out.println(out);
    	
    	
    }
    
    
public static void print(String Ausgabe) {
    System.out.println(Ausgabe);
}



public static double negate(double Zahl) {
    return -Zahl;
}

public static int max(int a, int b, int c) {
    if (a>b && a>c) {
        return a;
    }
    else if (b>c){
            return b;
    }
    else {
                return c;
    }
}

public static boolean isEven(int a) {
   
    
    return a%2 == 0; 
}
	
public static boolean isDividable(int a, int b) {
    if(a%b == 0) {
        return true;
    }
    else {
        return false;
    }
}

	
	
	
	
	
	
	
	public static void an() {
		
	}
	
	
}
