package jp.co.netprotections.dto;

public class MemberJudgeRequestDto {
	//リクエストの属性
	private String memberName;
	private int eventPlanning;
	private int cogitation;
	private int coodination;
	private int programmingAbility;
	private int infrastructureKnowledge;
	
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getEventPlanning() {
		return eventPlanning;
	}

	public void setEventPlanning(int eventPlanning) {
		this.eventPlanning = eventPlanning;
	}

	public int getCogitation() {
		return cogitation;
	}

	public void setCogitation(int cogitation) {
		this.cogitation = cogitation;
	}

	public int getCoodination() {
		return coodination;
	}

	public void setCoodination(int coodination) {
		this.coodination = coodination;
	}

	public int getInfrastructureKnowledge() {
		return infrastructureKnowledge;
	}

	public void setInfrastructureKnowledge(int nfrastructureKnowledge) {
		this.infrastructureKnowledge = nfrastructureKnowledge;
	}

	public int getProgrammingAbility() {
		return programmingAbility;
	}

	public void setProgrammingAbility(int programmingAbility) {
		this.programmingAbility = programmingAbility;
	}
}
