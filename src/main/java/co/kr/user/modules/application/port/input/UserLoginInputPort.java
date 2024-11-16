package co.kr.user.modules.application.port.input;

import co.kr.common.security.jwt.dto.JwtUserDetailResponse;
import co.kr.user.modules.application.usecase.UserLoginUsecase;
import co.kr.user.modules.domain.entity.User;
import co.kr.user.modules.domain.mapper.UserMapper;
import co.kr.user.modules.domain.service.UserService;
import co.kr.user.modules.framework.input.rest.dto.UserLoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginInputPort extends AbstractUserInputPort implements UserLoginUsecase {

	@Override
	public JwtUserDetailResponse login(UserLoginDto userLoginDto) throws Exception {
		User request = UserMapper.loginDtoToDomain(userLoginDto);
		User saved = userManagementOutputPort.retrieve(request.getUserId());

		return UserService.creatToken(request, saved);
	}
}
