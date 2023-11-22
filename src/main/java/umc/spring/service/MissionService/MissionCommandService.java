package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.base.Code;
import umc.spring.base.exception.handler.MemberHandler;
import umc.spring.base.exception.handler.MissionHandler;
import umc.spring.base.exception.handler.StoreHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mappings.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.MissionRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionCommandService {
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final StoreRepository storeRepository;
    public void challenge(Long missionId){
        Member member = memberRepository.findById(1L).orElseThrow(() -> new MemberHandler(Code.MEMBER_NOT_FOUND));
        Mission check_mission = missionRepository.findById(missionId).orElseThrow(() -> new MissionHandler(Code.MISSION_NOT_FOUND));

        List<MemberMission> missionMembers = member.getMemberMissionList();

        for (MemberMission missionMember : missionMembers) {
            Mission mission = missionMember.getMission();
            if (check_mission.equals(mission)){
                throw new MissionHandler(Code.MISSION_ALREADY_REGISTER);
            }
        }
        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(check_mission)
                .status(MissionStatus.CHALLENGING)
                .build();
        memberMissionRepository.save(memberMission);
    }

    public Mission register(Long shopId, MissionRequestDTO.MissionRegisterDTO form) {
        Store store = storeRepository.findById(shopId).orElseThrow(() -> new StoreHandler(Code.STORE_NOT_FOUND));
        Mission mission = MissionConverter.toMission(form, store);
        return missionRepository.save(mission);

    }
}
