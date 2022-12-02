package services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Calculator Configuration")
public @interface CalculatorConfiguration 
{

	@AttributeDefinition(name = "Multiply Factor", required = true,
			description = "enter factor to which given number should be multiplied with")
	int calculator_multiply_factor() default 4;

     @AttributeDefinition(
            name = "calculator numbers",
            type = AttributeType.STRING,
            cardinality = Integer.MAX_VALUE)
    String[] calculator_numbers();

    @AttributeDefinition(
            name = "Boolean value",
            type = AttributeType.BOOLEAN)
    boolean is_true();

}
