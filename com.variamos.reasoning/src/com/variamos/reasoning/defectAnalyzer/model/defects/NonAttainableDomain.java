package com.variamos.reasoning.defectAnalyzer.model.defects;

import com.variamos.hlcl.BooleanExpression;
import com.variamos.hlcl.Identifier;
import com.variamos.reasoning.defectAnalyzer.model.enums.DefectType;

public class NonAttainableDomain extends Defect {
	private Identifier identifier;
	private Integer unreachableValue;

	public NonAttainableDomain(Identifier identifier, Integer unreachableValue,
			BooleanExpression verificationExpression) {
		super();
		this.identifier = identifier;
		this.id = identifier.getId() + " = " + unreachableValue.toString();
		this.unreachableValue = unreachableValue;
		defectType = DefectType.NON_ATTAINABLE_DOMAIN;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}

	public Integer getUnreachableValue() {
		return unreachableValue;
	}

	public void setUnreachableValue(Integer unreachableValue) {
		this.unreachableValue = unreachableValue;
	}

	

}
