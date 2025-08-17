package org.zerock.book_shop.service;

import org.zerock.book_shop.dto.MemberVO;

public interface MemberService {
	public void memberJoin(MemberVO member) throws Exception;
	public int memberIdChk(String memberId) throws Exception;
}
