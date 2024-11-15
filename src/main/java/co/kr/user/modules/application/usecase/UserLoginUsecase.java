package co.kr.user.modules.application.usecase;

import co.kr.common.security.jwt.dto.JwtUserDetailResponse;
import co.kr.user.modules.framework.input.rest.dto.UserLoginDto;

public interface UserLoginUsecase {
	JwtUserDetailResponse login(UserLoginDto userLoginDto) throws Exception;
}
