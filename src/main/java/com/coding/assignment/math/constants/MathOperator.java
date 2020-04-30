package com.coding.assignment.math.constants;

import com.coding.assignment.math.dto.MathInput;
import com.coding.assignment.math.dto.MathResult;

/**
 * 
 * Easy to extend it to multiply, divide etc by adding more constants to this enum.
 * Just provide corresponding anonymous inner type for MathOperation interface,
 * flavor of Strategy pattern,
 */
public enum MathOperator
{
    ADD {
        @Override public MathResult calculate(MathInput mathInput) {
        	return getResult(mathInput, new MathOperation() {
				@Override
				public Double calculate(Double x, Double y) {
					return x + y;
				}
			});
        }
    },
    SUB {
        @Override public MathResult calculate(MathInput mathInput) {
        	return getResult(mathInput, new MathOperation() {
				@Override
				public Double calculate(Double x, Double y) {
					return x - y;
				}
			});
        }
    };
	
    private final MathResult result = new MathResult();
    
    public MathResult getResult(MathInput mathInput, MathOperation mathOperation) {
        try {
			Double x = Double.parseDouble(mathInput.getX());
			Double y = Double.parseDouble(mathInput.getY());
			
			result.setResult(Double.toString(mathOperation.calculate(x, y)));
		} catch (NullPointerException e) {
			result.setResult(MathConstants.MANDATORY_FIELDS_ERROR);
		} catch (NumberFormatException e) {
			result.setResult(MathConstants.NON_NUMERICAL_ERROR);
		} catch (Exception e) {
			result.setResult(MathConstants.GENERIC_ERROR);
		}
    	
        return result;
    }
    
    public abstract MathResult calculate(MathInput mathInput);
}

interface MathOperation {
	public Double calculate(Double x, Double y);
}