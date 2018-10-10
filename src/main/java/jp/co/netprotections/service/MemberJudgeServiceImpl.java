package jp.co.netprotections.service;

import org.springframework.stereotype.Service;

import jp.co.netprotections.dto.RequestDto;

@Service
public class MemberJudgeServiceImpl implements MemberJudgeService{
	
	@Override
	// enlistedProprietyの価値を判断する
	public boolean isValid(RequestDto dto){
		boolean result = true;
		int total_point = dto.getCogitation() + dto.getEventPlanning() 
			+ dto.getCoodination() + dto.getProgrammingKnowledge() + dto.getInfrastructureKnowledge(); //合計点
		if(dto.getEventPlanning() < 1 || dto.getCoodination() < 1 || total_point < 10) {
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
	
	// 値の限定をチェックする
	public boolean checkLimit(RequestDto dto) {
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
}
