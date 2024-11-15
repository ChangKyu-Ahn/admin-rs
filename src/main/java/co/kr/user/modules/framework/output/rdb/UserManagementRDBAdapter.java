package co.kr.user.modules.framework.output.rdb;

import co.kr.common.exception.NotExistDataException;
import co.kr.user.modules.application.port.output.UserManagementOutputPort;
import co.kr.user.modules.domain.entity.User;
import co.kr.user.modules.domain.mapper.UserMapper;
import co.kr.user.modules.framework.output.rdb.data.UserData;
import co.kr.user.modules.framework.output.rdb.mapper.UserRDBMapper;
import co.kr.user.modules.framework.output.rdb.repository.UserDataRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserManagementRDBAdapter implements UserManagementOutputPort {
	private final UserDataRepository userDataRepository;

	@Override
	public User persist(User user) {
		UserData saved = userDataRepository.save(UserRDBMapper.domainToData(user));
		return UserMapper.dataToDomain(saved);
	}

	@Override
	@Transactional(readOnly = true)
	public User retrieve(String userId) {
		return optionalRetrieve(userId).orElseThrow(NotExistDataException::new);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> optionalRetrieve(String userId) {
		return userDataRepository.findByUserId(userId)
			.map(UserMapper::dataToDomain);
	}

	@Override
	@Transactional
	public User update(String userId, User user) {
		UserData data = userDataRepository.findByUserId(userId).orElseThrow(NotExistDataException::new);

		data.update(user);

		return UserMapper.dataToDomain(data);
	}

	@Override
	public void delete(String userId) {
		userDataRepository.deleteByUserId(userId);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExistByUserId(String userId) {
		return userDataRepository.existsByUserId(userId);
	}
}
