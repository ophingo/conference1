package zw.co.econet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.econet.model.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
