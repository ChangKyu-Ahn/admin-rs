package co.kr.user.modules.application.port.input;

import co.kr.common.domain.vo.Identifier;
import co.kr.user.modules.application.usecase.UserUpdateUsecase;
import co.kr.user.modules.domain.entity.User;
import co.kr.user.modules.domain.mapper.UserMapper;
import co.kr.user.modules.domain.service.UserValidationService;
import co.kr.user.modules.framework.input.rest.dto.UserUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUpdateInputPort extends AbstractUserInputPort implements UserUpdateUsecase {

	@Override
	public Identifier<String> update(String userId, UserUpdate userUpdate) {
		UserValidationService.checkDataOwner(userId);

		User user = UserMapper.updateDtoToDomain(userUpdate);

		User updated = userManagementOutputPort.update(userId, user);

		return UserMapper.toUserIdResponse(updated);
	}
}
