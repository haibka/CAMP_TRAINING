package jp.co.netprotections.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import jp.co.netprotections.BootCampStartupApplication;
import jp.co.netprotections.service.MemberJudgeService;

@RunWith(JUnit4.class)
@SpringBootTest(classes = BootCampStartupApplication.class)
public class MemberJudgeControllerTest {
	private MockMvc mockMvc;

    @Mock
    private MemberJudgeService memberJudgeService;

    @InjectMocks
    private MemberJudgeController mainController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
        	.standaloneSetup(mainController)
            .build();
    }
    
    @Test
    public void mainControllerTest() throws Exception {
    	String json = "{\n" +
    		"\"memberCandidatesList\" : [" + "\n{" +
            "  \"memberName\": \"snozaki\",\n" +
            "  \"eventPlanning\": \"2\",\n" +
            "  \"cogitation\": \"2\",\n" +
            "  \"coodination\": \"2\",\n" +
            "  \"programmingKnowledge\": \"3\",\n" +
            "  \"infrastructureKnowledge\": \"3\"\n" +
            "} ]\n" + "}" ;
    	mockMvc.perform(post("/api/main")
    		.contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk())
            .andReturn();
    }
    
    @Test
    //　条件に違反した時、空のレスポンスを返却する
    public void mainControllerConditionTest() throws Exception {
    	String json = "{\n" +
    		"\"memberCandidatesList\" : [" + "\n{" +
            "  \"memberName\": \"yamada\",\n" +
            "  \"eventPlanning\": \"8\",\n" +
            "  \"cogitation\": \"8\",\n" +
            "  \"coodination\": \"8\",\n" +
            "  \"programmingKnowledge\": \"8\",\n" +
            "  \"infrastructureKnowledge\": \"8\"\n" +
            "} ]\n" + "}" ;
    	mockMvc.perform(post("/api/main")
    		.contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk())
            .andDo(mvcResult -> {  // レスポンスの内容
            });
    }
    
    @Test
    public void mainControllerTypeTest() throws Exception {
    	String json = "{\n" +
    		"\"memberCandidatesList\" : [" + "\n{" +
            "  \"memberName\": \"yamada\",\n" +
            "  \"eventPlanning\": \"dsd\",\n" + //価値のタイプはStringので間違い
            "  \"cogitation\": \"\",\n" +
            "  \"coodination\": \"8\",\n" +
            "  \"programmingKnowledge\": \"8\",\n" +
            "  \"infrastructureKnowledge\": \"8\"\n" +
            "} ]\n" + "}" ;
    	mockMvc.perform(post("/api/main")
    		.contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isBadRequest());
    }
}