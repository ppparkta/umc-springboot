package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.base.Code;
import umc.spring.base.ResponseDto;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MissionRestController {
    private final MissionCommandService missionCommandService;
    @PostMapping("/missions/{missionId}/perform")
    public ResponseDto<MissionResponseDTO.MissionResultDTO> challenge(@PathVariable("missionId")Long missionId){
        missionCommandService.challenge(missionId);
        return ResponseDto.onSuccess(
                MissionConverter.toMissionResultDTO("도전 미션에 추가되었습니다."), Code.OK
        );
    }

    @PostMapping("/missions/{shopId}")
    public ResponseDto<MissionResponseDTO.MissionRegisterDTO> register(@PathVariable("shopId")Long shopId, @RequestBody @Valid MissionRequestDTO.MissionRegisterDTO form){
        Mission mission = missionCommandService.register(shopId, form);
        return ResponseDto.onSuccess(
                MissionConverter.toMissionRegisterDTO(mission), Code.OK
        );
    }
}
