package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.MissionRegisterDTO form, Store store) {
        return Mission.builder()
                .reward(form.getReward())
                .deadline(form.getDeadline())
                .missionSpec(form.getMission_spec())
                .store(store)
                .build();
    }
    public static MissionResponseDTO.MissionResultDTO toMissionResultDTO(String msg) {
        return MissionResponseDTO.MissionResultDTO.builder()
                .msg(msg)
                .build();
    }

    public static MissionResponseDTO.MissionRegisterDTO toMissionRegisterDTO(Mission mission) {
        return MissionResponseDTO.MissionRegisterDTO.builder()
                .reward(mission.getReward())
                .mission_id(mission.getId())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .store_id(mission.getStore().getId())
                .build();
    }
}
