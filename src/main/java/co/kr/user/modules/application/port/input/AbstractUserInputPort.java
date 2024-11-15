package co.kr.user.modules.application.port.input;

import co.kr.user.modules.application.port.output.UserManagementOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractUserInputPort {
	@Autowired protected UserManagementOutputPort userManagementOutputPort;
}
