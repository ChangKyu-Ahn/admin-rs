package co.kr.user.modules.framework.output.external;

import co.kr.common.api.BoardApi;
import co.kr.user.modules.application.port.output.ExternalUserDataProcessManagementOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExternalUserDataProcessManagementAdapter implements ExternalUserDataProcessManagementOutputPort {
	private final BoardApi boardApi;

	@Override
	public void deleteAllByUserId(String userId) {
		boardApi.deleteAllByUserId(userId);
	}
}
