package cominatorics;


public class BinomialFormula extends Cominatorics{//For the purpose of this code being stand-alone you can remove the extends decleration
	String nomial;
	String coeficent1;
	String coeficent2;
	String variable1;
	String variable2;
	int num1;
	int num2;
	int multiplier1=1;
	int multiplier2=1;
BinomialFormula(int n, String nomial){
	super(n);
	nomial= nomial.trim();
	int pos=0;
	int pos2=0;
	if(nomial.charAt(0)=="+".charAt(0)){
		nomial = " "+nomial.substring(1);
		multiplier1 = 1;
	}
	else if(nomial.charAt(0)=="-".charAt(0)){
		nomial = " "+nomial.substring(1);
		multiplier1 = -1;
	}
	for(int i=0;i<nomial.length();i++){
		if(nomial.charAt(i)=="+".charAt(0)){
			nomial = nomial.substring(0,i)+" "+nomial.substring(i+1);
			multiplier2 = 1;
			break;
		}
		else if(nomial.charAt(i)=="-".charAt(0)){
			//got here
			nomial = nomial.substring(0,i)+" "+nomial.substring(i+1);
			multiplier2 = -1;
			break;
		}
	}
	nomial = nomial.trim();
	for(pos=0;pos<nomial.length();pos++){
		if(!(Character.isDigit(nomial.charAt(pos)))){
			break;
		}
	}
	coeficent1 = nomial.substring(0,pos);
	if(!(coeficent1.isEmpty())){
	num1 = Integer.parseInt(coeficent1);
	num1 = num1*multiplier1;
	}else{
		num1=multiplier1;
	}
	for(int i = pos+1;i<nomial.length();i++){
		if((Character.isSpaceChar(nomial.charAt(i)))){
			pos2 = i + 1;
			break;
		}
	}
	variable1 = nomial.substring(pos,pos2);
	variable1 = variable1.trim();
	pos = pos2;
	
	for(int i = pos;i<nomial.length();i++){
		if(!(Character.isDigit(nomial.charAt(i)))){
			if(i==pos){
				break;
			}
			pos2 = i;
			break;
		}
	}
	coeficent2 = nomial.substring(pos, pos2);
	if(!(coeficent2.isEmpty())){
		num2 = Integer.parseInt(coeficent2)*multiplier2;
	}
	else{
		num2 = multiplier2;
	}
	
	variable2 = nomial.substring(pos2);
	//System.out.println(num1);
	//System.out.println(variable1);
	//System.out.println(num2);
	//System.out.println(variable2);
	for(int i=0;i<fract.length;i++){
		
		System.out.print(Des((Spow(variable1,n-i)+Spow(variable2,i)),comb(i)*Math.pow(num1, n-i)*Math.pow(num2,i)));
		if(i<fract.length-1){
			System.out.print(" + ");
		}
	}
	
}
public String Spow(String s, int n){
	if(n==1){
		return s;
	}
	if(n==0){
		return "";
	}
	return s + "^"+n;
}
public String Des(String s, double n){
	if(n==1){
		return s;
	}
	int k = (int)n;
	return k+s;
}

	public static void main(String[] args) {
		System.out.println("Enter the your expression in the form (a+b)^n");
		String total = IO.readString();
		int end;
		for(end=0;end<total.length();end++){
			if(total.charAt(end)==")".charAt(0)){
				
			}
		}
		String nomail = total.substring(1, end+1);
		BinomialFormula(6,"78x+5y");
		
		
	}
	public static void BinomialFormula(int n, String nomial){
		 new BinomialFormula(n,nomial);
	}

}
