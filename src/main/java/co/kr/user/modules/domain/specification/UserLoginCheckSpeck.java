package co.kr.user.modules.domain.specification;

import static co.kr.common.config.CommonConfigurer.passwordEncoder;

import co.kr.common.domain.vo.Password;
import co.kr.common.specification.shared.Specification;
import co.kr.user.modules.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

@RequiredArgsConstructor
public class UserLoginCheckSpeck extends Specification<User> {
	private final User savedUser;

	@Override
	protected boolean check(User request) {
		if (ObjectUtils.anyNull(request, savedUser)) {
			return false;
		}

		Password password = request.getPassword();
		if (ObjectUtils.isEmpty(password)) {
			return false;
		}

		return passwordEncoder().matches(StringUtils.defaultString(password.getValue()), savedUser.getPassword().getValue());
	}

	@Override
	public String getErrorMessage() {
		return "로그인 정보를 확인해 주세요";
	}
}
