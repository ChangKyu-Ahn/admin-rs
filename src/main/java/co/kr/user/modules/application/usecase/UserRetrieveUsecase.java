package co.kr.user.modules.application.usecase;

import co.kr.user.modules.framework.input.rest.dto.UserResponse;

public interface UserRetrieveUsecase {
	UserResponse detail(String userId);
}
