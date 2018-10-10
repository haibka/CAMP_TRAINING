package jp.co.netprotections.dto;

import junit.framework.TestCase;

public class RequestDtoTest extends TestCase {
	public void testGetMemberName() {
		RequestDto resDto = new RequestDto();
		resDto.setMemberName("yamada");
		assertEquals("yamada",resDto.getMemberName());
	}
	
	public void testGetEventPlanning() {
		RequestDto resDto = new RequestDto();
		resDto.setEventPlanning(1);
		assertEquals(1,resDto.getEventPlanning());
	}
	
	public void testGetCoodination() {
		RequestDto resDto = new RequestDto();
		resDto.setCoodination(1);
		assertEquals(1,resDto.getCoodination());
	}
	
	public void testGetProgrammingKnowledge() {
		RequestDto resDto = new RequestDto();
		resDto.setProgrammingKnowledge(1);
		assertEquals(1,resDto.getProgrammingKnowledge());
	}
	
	public void testGetInfrastructureKnowledge() {
		RequestDto resDto = new RequestDto();
		resDto.setInfrastructureKnowledge(1);
		assertEquals(1,resDto.getInfrastructureKnowledge());
	}

}
