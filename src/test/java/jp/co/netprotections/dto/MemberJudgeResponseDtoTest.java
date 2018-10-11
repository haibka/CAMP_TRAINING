package jp.co.netprotections.dto;

import junit.framework.TestCase;

public class MemberJudgeResponseDtoTest extends TestCase {
	public void testGetMemberName() {
		MemberJudgeResponseDto resDto = new MemberJudgeResponseDto();
		resDto.setMemberName("yamada");
		assertEquals("yamada",resDto.getMemberName());
	}
	public void testGetEnlistedPropriety() {
		MemberJudgeResponseDto resDto = new MemberJudgeResponseDto();
		resDto.setEnlistedPropriety(true);
		assertEquals(true,resDto.isEnlistedPropriety());
	}

}
