package com.train.member.service;

import cn.hutool.core.collection.CollUtil;
import com.train.member.domain.Member;
import com.train.member.domain.MemberExample;
import com.train.member.mapper.MemberMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Resource
    private MemberMapper memberMapper;

    public int count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    public long register(String phone) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(phone);
        List<Member> members = memberMapper.selectByExample(memberExample);
        if(CollUtil.isNotEmpty(members)){
            throw new  RuntimeException("手机号已注册");
        }

        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(phone);
        memberMapper.insert(member);
        return member.getId();
    }

}
