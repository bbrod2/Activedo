package perscholas.form;

import javax.validation.constraints.Pattern;

public class PreScreenForm {
	private Integer Id;
	
	private Double height;
	
	private Double weight; 
	
	private Integer goalWeight;
	

	public Integer getId() {
		return Id;
	}

	public Double getHeight() {
		return height;
	}

	public Double getWeight() {
		return weight;
	}

	public Integer getGoalWeight() {
		return goalWeight;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public void setGoalWeight(Integer goalWeight) {
		this.goalWeight = goalWeight;
	}

	@Override
	public String toString() {
		return "PreScreenForm [Id=" + Id + ", height=" + height + ", weight=" + weight + ", goalWeight=" + goalWeight
				+ "]";
	} 
}
