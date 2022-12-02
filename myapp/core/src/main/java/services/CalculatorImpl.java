package services;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = Calculator.class, immediate = true)
@Designate(ocd = CalculatorConfiguration.class)
public class CalculatorImpl implements Calculator 
{
	int factor;
	String[] numbers;
	boolean isTrue;
  
	@Activate
	public void activate(CalculatorConfiguration config) 
	{
		factor = config.calculator_multiply_factor();
	}

	@Override
	public int add(int a, int b) 
	{
		return a + b;
	}

	@Override
	public int subtract(int a, int b)
	{
		return a - b;
	}

	@Override
	public int multiply(int a, int b) 
	{
		return a * b;
	}

	@Override
	public int multiplyByFactor(int a) 
	{
		return a * factor;
	}

}
