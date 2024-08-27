package perscholas.form;

public class HhqForm {
	
	private Integer Id;
	
	private String question;
	
	private Integer checkUncheck;

	public Integer getId() {
		return Id;
	}

	public String getQuestion() {
		return question;
	}

	public Integer getCheckUncheck() {
		return checkUncheck;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setCheckUncheck(Integer checkUncheck) {
		this.checkUncheck = checkUncheck;
	}

	@Override
	public String toString() {
		return "HhqForm [Id=" + Id + ", question=" + question + ", checkUncheck=" + checkUncheck + "]";
	}
}
