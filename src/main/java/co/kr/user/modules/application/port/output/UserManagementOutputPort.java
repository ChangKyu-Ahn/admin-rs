package co.kr.user.modules.application.port.output;

import co.kr.user.modules.domain.entity.User;
import java.util.Optional;

public interface UserManagementOutputPort {
	User persist(User user);

	User retrieve(String userId);

	Optional<User> optionalRetrieve(String userId);

	User update(String userId, User user);

	void delete(String userId);

	boolean isExistByUserId(String userId);
}
