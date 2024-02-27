package com.suiwu.train.member.service;

import cn.hutool.core.collection.CollUtil;
import com.suiwu.train.common.util.SnowUtil;
import com.suiwu.train.member.domain.Member;
import com.suiwu.train.member.domain.MemberExample;
import com.suiwu.train.member.mapper.MemberMapper;
import com.suiwu.train.member.req.MemberRegisterReq;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Resource
//    @Autowired
    private MemberMapper memberMapper;
    public int count(){
        return Math.toIntExact(memberMapper.countByExample(null));
    }


    public long register(MemberRegisterReq req){
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list =  memberMapper.selectByExample(memberExample);
        if(CollUtil.isNotEmpty(list)){
//            return list.get(0).getId();
            throw new RuntimeException("手机号已注册");

        }
        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile);

        memberMapper.insert(member);
        return member.getId();
    }
}
