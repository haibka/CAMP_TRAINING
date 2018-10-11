package jp.co.netprotections.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeRequestDtoArr;
import jp.co.netprotections.dto.MemberJudgeResponseDto;
import jp.co.netprotections.dto.MemberJudgeResponseDtoArr;

@Service
public class MemberJudgeServiceImpl implements MemberJudgeService{
	
	@Override
	// enlistedProprietyの価値を判断する
	public boolean isValid(MemberJudgeRequestDto dto){
		boolean result = true;
		int totalPoint = dto.getCogitation() + dto.getEventPlanning() 
			+ dto.getCoodination() + dto.getProgrammingKnowledge() + dto.getInfrastructureKnowledge(); //合計点
		if(dto.getEventPlanning() < 1 || dto.getCoodination() < 1 || totalPoint < 10) {
			result = false;
		} else {
			if (dto.getCogitation() == 0 && dto.getEventPlanning() != 0 
				&& dto.getCoodination() == 0 && dto.getProgrammingKnowledge() == 0 && dto.getInfrastructureKnowledge() == 0) {
				result = false; //イベント企画力以外が全て0点である
			}
			else {
				result = true;
			}
		}
		return result;
	}
	
	@Override
	// 値の限定をチェックする
	public boolean checkLimit(MemberJudgeRequestDto dto) {
		System.out.println("Coodddasdasd" + dto.getCogitation());
		if (dto.getCogitation() > 5 || dto.getCoodination() > 5 || dto.getEventPlanning() > 5 
			|| dto.getInfrastructureKnowledge() > 5 || dto.getProgrammingKnowledge() > 5) {
			return false;
		} else {
			if (dto.getCogitation() < 1 || dto.getCoodination() < 1 || dto.getEventPlanning() < 1 
				|| dto.getInfrastructureKnowledge() < 1 || dto.getProgrammingKnowledge() < 1)
				return false;
		}
		return true;
	};
	
	@Override
	// Controllerから呼び掛させるクラス
	public MemberJudgeResponseDtoArr createResponse(MemberJudgeRequestDtoArr dtoArr) {
		List<MemberJudgeRequestDto> listMem = dtoArr.getMemberCandidatesList();//リクエストを受けた
		MemberJudgeResponseDtoArr responseArr = new MemberJudgeResponseDtoArr();//レスポンスの価値
		List<MemberJudgeResponseDto> resList = new ArrayList<MemberJudgeResponseDto>(); //リストの素子
		
		for (int i  = 0; i < listMem.size(); i++) {
			MemberJudgeResponseDto response = new MemberJudgeResponseDto();
			MemberJudgeRequestDto currentItem = listMem.get(i);
			response.setMemberName(listMem.get(i).getMemberName());
			if (!this.checkLimit(currentItem)) return null; 
			// 価値の限定を違反する時レスポンスが空くになる
			if (this.isValid(currentItem)) {
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
