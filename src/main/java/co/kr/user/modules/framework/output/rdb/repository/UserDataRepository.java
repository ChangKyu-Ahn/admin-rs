package co.kr.user.modules.framework.output.rdb.repository;

import co.kr.user.modules.framework.output.rdb.data.UserData;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long>  {
	boolean existsByUserId(String userId);

	void deleteByUserId(String userId);

	Optional<UserData> findByUserId(String userId);

	Optional<UserData> findByUserIdAndPassword(String userId, String password);
}
