package co.kr.user.modules.application.port.input;

import co.kr.user.modules.application.usecase.UserRetrieveUsecase;
import co.kr.user.modules.domain.entity.User;
import co.kr.user.modules.domain.mapper.UserMapper;
import co.kr.user.modules.domain.service.UserValidationService;
import co.kr.user.modules.framework.input.rest.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRetrieveInputPort extends AbstractUserInputPort implements UserRetrieveUsecase {

	@Override
	public UserResponse detail(String userId) {
		UserValidationService.checkDataOwner(userId);

		User retrieved = userManagementOutputPort.retrieve(userId);

		return UserMapper.domainToResponseDto(retrieved);
	}
}
