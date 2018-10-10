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
import jp.co.netprotections.dto.RequestDto;

@RunWith(JUnit4.class)
@ExtendWith(MockitoExtension.class)
public class MemberJudgeServiceImplTest {
	
	RequestDto requestDto = Mockito.mock(RequestDto.class);
	MemberJudgeService memberJudgeService = new MemberJudgeServiceImpl();
	
	@Before
	public void setUp() {
		when(requestDto.getMemberName()).thenReturn("member");
		when(requestDto.getCogitation()).thenReturn(2);
		when(requestDto.getCoodination()).thenReturn(2);
		when(requestDto.getEventPlanning()).thenReturn(4);
		when(requestDto.getInfrastructureKnowledge()).thenReturn(3);
		when(requestDto.getProgrammingKnowledge()).thenReturn(3);	
		
	}
	
	@Test
	public void isValidTest() {
		assertEquals(true, memberJudgeService.isValid(requestDto));
	}
	
	@Test
	public void checkLimitTest() {
		assertEquals(true, memberJudgeService.checkLimit(requestDto));
	}
}