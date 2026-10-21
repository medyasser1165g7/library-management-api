package com.arthur.library_management_api.Controllers;

import com.arthur.library_management_api.DTOs.MemberDTOs.MemberCreateDTO;
import com.arthur.library_management_api.DTOs.MemberDTOs.MemberDetailsResponseDTO;
import com.arthur.library_management_api.DTOs.MemberDTOs.MemberResponseDTO;
import com.arthur.library_management_api.Services.MemberService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/members")
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponseDTO> createMember(@Valid @RequestBody MemberCreateDTO memberCreateDTO){
        MemberResponseDTO responseDTO = memberService.createMember(memberCreateDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MemberDetailsResponseDTO> getMemberById(@PathVariable Long id){
        MemberDetailsResponseDTO responseDTO = memberService.getMemberById(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMemberById(@PathVariable Long id){
        memberService.deleteMemberById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
