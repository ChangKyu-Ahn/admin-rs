package co.kr.user.modules.application.port.input;

import co.kr.common.domain.vo.Identifier;
import co.kr.user.modules.application.usecase.UserCreateUsecase;
import co.kr.user.modules.domain.entity.User;
import co.kr.user.modules.domain.mapper.UserMapper;
import co.kr.user.modules.domain.service.UserValidationService;
import co.kr.user.modules.framework.input.rest.dto.UserCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreateInputPort extends AbstractUserInputPort implements UserCreateUsecase {

	@Override
	public Identifier<String> create(UserCreate userCreate) {
		User user = UserMapper.createDtoToDomain(userCreate);

		UserValidationService.checkCreatable(
			userManagementOutputPort.isExistByUserId(user.getUserId())
		);

		User persistedUser = userManagementOutputPort.persist(user);

		return UserMapper.toUserIdResponse(persistedUser);
	}
}
