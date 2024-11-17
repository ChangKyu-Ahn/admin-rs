package co.kr.user.modules.application.port.input;

import co.kr.user.modules.application.port.output.ExternalUserDataProcessManagementOutputPort;
import co.kr.user.modules.application.usecase.UserDeleteUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDeleteInputPort extends AbstractUserInputPort implements UserDeleteUsecase {
	private final ExternalUserDataProcessManagementOutputPort externalUserManagementOutputPort;

	@Override
	public void delete(String userId) {
		userManagementOutputPort.delete(userId);
		externalUserManagementOutputPort.deleteAllByUserId(userId);
	}
}
