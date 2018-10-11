package jp.co.netprotections.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import jp.co.netprotections.dto.MemberJudgeRequestDto;

@RunWith(JUnit4.class)
@ExtendWith(MockitoExtension.class)
public class MemberJudgeServiceImplTest {
	
	MemberJudgeRequestDto requestDto = Mockito.mock(MemberJudgeRequestDto.class); //EnlistedProprietyの価値はtrue
	MemberJudgeRequestDto requestDto_2 = Mockito.mock(MemberJudgeRequestDto.class); //リクエスト中に限定以外の価値がある
	MemberJudgeRequestDto requestDto_3 = Mockito.mock(MemberJudgeRequestDto.class); //合計が10点以下である
	MemberJudgeService memberJudgeService = new MemberJudgeServiceImpl();
	
	@Before
	public void setUp() {
		when(requestDto.getMemberName()).thenReturn("member_1");
		when(requestDto.getCogitation()).thenReturn(2);
		when(requestDto.getCoodination()).thenReturn(2);
		when(requestDto.getEventPlanning()).thenReturn(4);
		when(requestDto.getInfrastructureKnowledge()).thenReturn(3);
		when(requestDto.getProgrammingKnowledge()).thenReturn(3);	
		
		when(requestDto_2.getMemberName()).thenReturn("member_2");
		when(requestDto_2.getCogitation()).thenReturn(2);
		when(requestDto_2.getCoodination()).thenReturn(2);
		when(requestDto_2.getEventPlanning()).thenReturn(9);
		when(requestDto_2.getInfrastructureKnowledge()).thenReturn(3);
		when(requestDto_2.getProgrammingKnowledge()).thenReturn(3);	
		
		when(requestDto_3.getMemberName()).thenReturn("member_3");
		when(requestDto_3.getCogitation()).thenReturn(2);
		when(requestDto_3.getCoodination()).thenReturn(1);
		when(requestDto_3.getEventPlanning()).thenReturn(1);
		when(requestDto_3.getInfrastructureKnowledge()).thenReturn(1);
		when(requestDto_3.getProgrammingKnowledge()).thenReturn(1);	
	}
	
	@Test
	public void isValidTestTrue() {
		assertEquals(true, memberJudgeService.isValid(requestDto));
	}
	
	@Test
	public void isValidTestFalse() {
		assertEquals(false, memberJudgeService.isValid(requestDto_3));
	}
	
	@Test
	public void checkLimitTestTrue() {
		assertEquals(true, memberJudgeService.checkLimit(requestDto));
	}
	
	@Test
	public void checkLimitTestFalse() {
		assertEquals(false, memberJudgeService.checkLimit(requestDto_2));
	}
}