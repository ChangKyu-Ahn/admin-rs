package co.kr.user.modules.application.port.input;

import co.kr.user.modules.application.usecase.UserDeleteUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDeleteInputPort extends AbstractUserInputPort implements UserDeleteUsecase {

	@Override
	public void delete(String userId) {
		userManagementOutputPort.delete(userId);
	}
}
