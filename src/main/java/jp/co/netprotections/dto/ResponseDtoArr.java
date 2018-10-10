package jp.co.netprotections.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseDtoArr {
	//レスポンスのフォーム
	private List<ResponseDto> judgedCandidatesResultList = new ArrayList<ResponseDto>();

	public List<ResponseDto> getJudgedCandidatesResultList() {
		return judgedCandidatesResultList;
	}

	public void setJudgedCandidatesResultList(List<ResponseDto> judgedCandidatesResultList) {
		this.judgedCandidatesResultList = judgedCandidatesResultList;
	}

}
