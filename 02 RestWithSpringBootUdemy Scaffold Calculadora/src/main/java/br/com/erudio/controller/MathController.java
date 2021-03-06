package br.com.erudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.mathService.SimpleMathServices;
import br.com.erudio.request.converters.NumberConverter;

@RestController
public class MathController {
	
	@Autowired
	private SimpleMathServices math;
	
	
	//Especificando o método get com path variable para obrigar vir com valor
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
		{
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
				
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	//Especificando o método get com path variable para obrigar vir com valor
	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
		{
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
				
		return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	//Especificando o método get com path variable para obrigar vir com valor
	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
		{
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
				
		return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	//Especificando o método get com path variable para obrigar vir com valor
	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
		{
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
						
		if(NumberConverter.convertToDouble(numberTwo) == 0)
		{
			throw new UnsuportedMathOperationException("Please define a non-zero denominator! ");
		}
		
		return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	//Especificando o método get com path variable para obrigar vir com valor
	@RequestMapping(value="/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
		{
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
				
		return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	//Especificando o método get com path variable para obrigar vir com valor
	@RequestMapping(value="/squareRoot/{number}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number) throws Exception {
		if(!NumberConverter.isNumeric(number))
		{
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
				
		return math.squareRoot(NumberConverter.convertToDouble(number));
	}		
}
