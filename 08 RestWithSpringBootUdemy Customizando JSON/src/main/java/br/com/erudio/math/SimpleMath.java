package br.com.erudio.math;

public class SimpleMath {

	public Double sum(double numberOne, double numberTwo) {
		Double result = numberOne + numberTwo; 
		return result;
	}
	
	public Double subtraction(double numberOne, double numberTwo) {
		Double result = numberOne - numberTwo; 
		return result;
	}
	
	public Double multiplication(double numberOne, double numberTwo) {
		Double result = numberOne * numberTwo; 
		return result;
	}
	
	public Double division(double numberOne, double numberTwo) {
		Double result = numberOne / numberTwo; 
		return result;
	}
	
	public Double mean(double numberOne, double numberTwo) {
		Double result = (numberOne + numberTwo) / 2.0; 
		return result;
	}
	
	public Double squareRoot(double number) {
		Double result = Math.sqrt(number); 
		return result;
	}
}
