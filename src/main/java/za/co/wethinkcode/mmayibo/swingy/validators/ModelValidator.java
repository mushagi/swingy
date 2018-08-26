package za.co.wethinkcode.mmayibo.swingy.validators;

import za.co.wethinkcode.mmayibo.swingy.models.players.AbstractPlayer;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ModelValidator {
	
	private static ModelValidator modelValidator;
	private Validator validator;
	
	public static ModelValidator getInstance() {
		if ( modelValidator == null)
			modelValidator = new ModelValidator();
		return modelValidator;
	}
	
	private ModelValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	public Set<ConstraintViolation<AbstractPlayer>> validatePlayer (AbstractPlayer player) {
		Set<ConstraintViolation<AbstractPlayer>>
				constraintViolations = validator.validate(player);
		return constraintViolations;
	}
}
