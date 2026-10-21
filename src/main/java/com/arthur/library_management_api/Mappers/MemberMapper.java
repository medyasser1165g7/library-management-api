package com.arthur.library_management_api.Mappers;

import com.arthur.library_management_api.DTOs.MemberDTOs.MemberCreateDTO;
import com.arthur.library_management_api.DTOs.MemberDTOs.MemberDetailsResponseDTO;
import com.arthur.library_management_api.DTOs.MemberDTOs.MemberResponseDTO;
import com.arthur.library_management_api.Entities.Member;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MemberMapper {

    public Member toEntity(MemberCreateDTO memberCreateDTO){
        Member member = new Member();
        member.setName(memberCreateDTO.getName());
        member.setEmail(memberCreateDTO.getEmail());
        member.setJoinedAt(LocalDateTime.now());
        return member;
    }
    //
    public MemberResponseDTO toMemberResponseDTO(Member member){
       MemberResponseDTO memberResponseDTO = new MemberResponseDTO();
       memberResponseDTO.setId(member.getId());
       memberResponseDTO.setName(member.getName());
       memberResponseDTO.setEmail(member.getEmail());
       member.setJoinedAt(member.getJoinedAt());
       return  memberResponseDTO;
    }
    //detailed member
    public MemberDetailsResponseDTO toMemberDetailsResponseDTO(Member member){
        MemberDetailsResponseDTO memberDetailsResponseDTO = new MemberDetailsResponseDTO();
        memberDetailsResponseDTO.setId(member.getId());
        memberDetailsResponseDTO.setName(member.getName());
        memberDetailsResponseDTO.setEmail(member.getEmail());
        memberDetailsResponseDTO.setJoinedAt(member.getJoinedAt());
        //memberDetailsResponseDTO.setBorrowings(member.getBorrowings());
        return  memberDetailsResponseDTO;
    }
}
