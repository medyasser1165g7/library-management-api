package com.arthur.library_management_api.Services;

import com.arthur.library_management_api.DTOs.MemberDTOs.MemberCreateDTO;
import com.arthur.library_management_api.DTOs.MemberDTOs.MemberDetailsResponseDTO;
import com.arthur.library_management_api.DTOs.MemberDTOs.MemberResponseDTO;
import com.arthur.library_management_api.Entities.Member;
import com.arthur.library_management_api.Exceptions.MemberNotFoundException;
import com.arthur.library_management_api.Mappers.MemberMapper;
import com.arthur.library_management_api.Repositories.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;

    //create member
    public MemberResponseDTO createMember(MemberCreateDTO memberCreateDTO){
        Member member = memberRepository.save(memberMapper.toEntity(memberCreateDTO));
        return memberMapper.toMemberResponseDTO(member);

    }
    //get member by id
    public MemberDetailsResponseDTO getMemberById(Long memberId){
        return memberMapper.toMemberDetailsResponseDTO(memberRepository.findById(memberId).orElseThrow( () -> new MemberNotFoundException("Member with id: " + memberId + " not found."))); // set member not found exception later
    }

    //get all members
    public List<MemberDetailsResponseDTO> getAllMembers(){
        List<MemberDetailsResponseDTO> members = new ArrayList<>();
        for( Member member: memberRepository.findAll() ){
            members.add(memberMapper.toMemberDetailsResponseDTO(member));
        }
        return members;
    }
    //delete member by id
    public void deleteMemberById(Long memberId){
        memberRepository.findById(memberId).orElseThrow( () -> new MemberNotFoundException("Member with id: " + memberId + " not found.")); // throw exception later
        memberRepository.deleteById(memberId);
    }
}

