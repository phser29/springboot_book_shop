package org.zerock.book_shop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.book_shop.dto.MemberVO;

@Mapper
public interface MemberMapper {	
	//회원가입
	public void memberJoin(MemberVO member);
	//데이터 중복 검사
	public int memberidCheck(String memberId);
	
}
