package pl.coderslab.app;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsOldEnoughValidator implements 
		ConstraintValidator<IsOldEnough, Integer> {

	@Override
	public void initialize(IsOldEnough constraintAnnotation) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		return (2018 - value) > 18;
	}

}
