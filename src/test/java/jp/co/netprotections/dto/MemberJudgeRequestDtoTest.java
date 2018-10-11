package jp.co.netprotections.dto;

import junit.framework.TestCase;

public class MemberJudgeRequestDtoTest extends TestCase {
	public void testGetMemberName() {
		MemberJudgeRequestDto resDto = new MemberJudgeRequestDto();
		resDto.setMemberName("yamada");
		assertEquals("yamada",resDto.getMemberName());
	}
	
	public void testGetEventPlanning() {
		MemberJudgeRequestDto resDto = new MemberJudgeRequestDto();
		resDto.setEventPlanning(1);
		assertEquals(1,resDto.getEventPlanning());
	}
	
	public void testGetCoodination() {
		MemberJudgeRequestDto resDto = new MemberJudgeRequestDto();
		resDto.setCoodination(1);
		assertEquals(1,resDto.getCoodination());
	}
	
	public void testGetProgrammingKnowledge() {
		MemberJudgeRequestDto resDto = new MemberJudgeRequestDto();
		resDto.setProgrammingKnowledge(1);
		assertEquals(1,resDto.getProgrammingKnowledge());
	}
	
	public void testGetInfrastructureKnowledge() {
		MemberJudgeRequestDto resDto = new MemberJudgeRequestDto();
		resDto.setInfrastructureKnowledge(1);
		assertEquals(1,resDto.getInfrastructureKnowledge());
	}

}
