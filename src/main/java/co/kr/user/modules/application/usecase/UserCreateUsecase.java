package co.kr.user.modules.application.usecase;

import co.kr.common.domain.vo.Identifier;
import co.kr.user.modules.framework.input.rest.dto.UserCreate;

public interface UserCreateUsecase {
	Identifier<String> create(UserCreate userCreate);
}
