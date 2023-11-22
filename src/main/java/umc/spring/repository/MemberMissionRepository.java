package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mappings.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
