package jp.co.netprotections.dto;

import junit.framework.TestCase;

public class ResponseDtoTest extends TestCase {
	public void testGetMemberName() {
		ResponseDto resDto = new ResponseDto();
		resDto.setMemberName("yamada");
		assertEquals("yamada",resDto.getMemberName());
	}
	public void testGetEnlistedPropriety() {
		ResponseDto resDto = new ResponseDto();
		resDto.setEnlistedPropriety(true);
		assertEquals(true,resDto.isEnlistedPropriety());
	}

}
