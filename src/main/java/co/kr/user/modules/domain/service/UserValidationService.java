package co.kr.user.modules.domain.service;

import co.kr.common.specification.BooleanCheckSpec;
import co.kr.common.specification.DataOwnerSpec;
import co.kr.common.specification.SpecificationExecutor;
import co.kr.common.util.SecurityUtil;
import co.kr.user.modules.domain.entity.User;
import co.kr.user.modules.domain.specification.UserLoginCheckSpeck;

public class UserValidationService {
	public static void checkCreatable(boolean isDuplicate) {
		SpecificationExecutor specificationExecutor = new SpecificationExecutor();

		specificationExecutor.addSpecification(new BooleanCheckSpec("이미 등록된 아이디 입니다"), !isDuplicate);

		specificationExecutor.validateAll();
	}

	public static void checkLoginPossible(User request, User saved) {
		SpecificationExecutor specificationExecutor = new SpecificationExecutor();

		specificationExecutor.addSpecification(new UserLoginCheckSpeck(saved), request);

		specificationExecutor.validateAll();
	}

	public static void checkDataOwner(String requestUserId) {
		SpecificationExecutor specificationExecutor = new SpecificationExecutor();

		specificationExecutor.addSpecification(new DataOwnerSpec(requestUserId), SecurityUtil.getUserId());

		specificationExecutor.validateAll();
	}
}
