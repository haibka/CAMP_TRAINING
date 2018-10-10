package jp.co.netprotections.service;

import jp.co.netprotections.dto.RequestDto;

public interface MemberJudgeService {
	boolean isValid(RequestDto dto); // enlistedProprietyの価値を判断する
	boolean checkLimit(RequestDto dto); // 値の限定をチェックする
}
