package zw.co.econet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.econet.model.Session;

public interface Sessionrepository extends JpaRepository<Session, Long> {
}
