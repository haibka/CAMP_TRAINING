package jp.co.netprotections.dto;

import java.util.ArrayList;
import java.util.List;

public class RequestDtoArr {
	//リクエストフォーム

	private List<RequestDto> memberCandidatesList = new ArrayList<RequestDto>();

	public List<RequestDto> getMemberCandidatesList() {
		return memberCandidatesList;
	}

	public void setMemberCandidatesList(List<RequestDto> memberCandidatesList) {
		this.memberCandidatesList = memberCandidatesList;
	}

}
