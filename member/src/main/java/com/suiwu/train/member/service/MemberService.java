package com.suiwu.train.member.service;

import com.suiwu.train.member.mapper.MemberMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Resource
//    @Autowired
    private MemberMapper memberMapper;
    public int count(){
        return memberMapper.count();
    }
}
