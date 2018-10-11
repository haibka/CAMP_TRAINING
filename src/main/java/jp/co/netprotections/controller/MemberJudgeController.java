package jp.co.netprotections.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.netprotections.dto.MemberJudgeRequestDtoArr;
import jp.co.netprotections.dto.MemberJudgeResponseDtoArr;
import jp.co.netprotections.service.MemberJudgeService;

@RestController
@RequestMapping("/api")
public class MemberJudgeController {
	@Autowired private MemberJudgeService memberJudgeService; //ロジックを処理する価値
	
	@RequestMapping(value="/main", method = RequestMethod.POST, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public MemberJudgeResponseDtoArr execute(@RequestBody MemberJudgeRequestDtoArr dtoArr) {
		return memberJudgeService.createResponse(dtoArr);
	}

}
