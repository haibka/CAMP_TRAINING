package jp.co.netprotections.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.netprotections.dto.RequestDto;
import jp.co.netprotections.dto.RequestDtoArr;
import jp.co.netprotections.dto.ResponseDto;
import jp.co.netprotections.dto.ResponseDtoArr;
import jp.co.netprotections.service.MemberJudgeService;

/**
 * リクエストを処理するControllerクラスです.
 * @author s.nozaki
 */
@RestController
@RequestMapping("/api")
public class MainController {
	@Autowired private MemberJudgeService memberJudgeService; //ロジックを処理する価値
	
	@RequestMapping(value="/main", method = RequestMethod.POST, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseDtoArr execute(@RequestBody RequestDtoArr dtoArr) {
		
		List<RequestDto> listMem = dtoArr.getMemberCandidatesList();//リクエストを受けた
		ResponseDtoArr responseArr = new ResponseDtoArr();//レスポンスの価値
		List<ResponseDto> resList = new ArrayList<ResponseDto>(); //リストの素子
		
		for (int i  = 0; i < listMem.size(); i++) {
			ResponseDto response = new ResponseDto();
			RequestDto currentItem = listMem.get(i);
			response.setMemberName(listMem.get(i).getMemberName());
			if (!memberJudgeService.checkLimit(currentItem)) return null; 
			// 価値の限定を違反する時レスポンスが空くになる
			if (memberJudgeService.isValid(currentItem)) {
				response.setEnlistedPropriety(true);
			} else {
				response.setEnlistedPropriety(false);
			}
			resList.add(response);
		}
		responseArr.setJudgedCandidatesResultList(resList);
		
		return responseArr;
	}

}
