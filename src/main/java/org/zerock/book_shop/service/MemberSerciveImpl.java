package org.zerock.book_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.book_shop.dto.MemberVO;
import org.zerock.book_shop.mapper.MemberMapper;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@Transactional
public class MemberSerciveImpl implements MemberService {
	
	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public void memberJoin(MemberVO member) throws Exception {
		memberMapper.memberJoin(member);
	}

	@Override
	public int memberIdChk(String memberId) throws Exception {
		return memberMapper.memberidCheck(memberId);
	}

	
}
