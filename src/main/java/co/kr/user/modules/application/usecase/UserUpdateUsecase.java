package co.kr.user.modules.application.usecase;

import co.kr.common.domain.vo.Identifier;
import co.kr.user.modules.framework.input.rest.dto.UserUpdate;

public interface UserUpdateUsecase {
	Identifier<String> update(String userId, UserUpdate userUpdate);
}
