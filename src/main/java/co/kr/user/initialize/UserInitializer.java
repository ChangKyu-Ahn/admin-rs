package co.kr.user.initialize;

import co.kr.common.code.UserType;
import co.kr.user.infra.config.CommonConfig;
import co.kr.user.modules.framework.output.rdb.data.UserData;
import co.kr.user.modules.framework.output.rdb.repository.UserDataRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserInitializer {
	private final UserDataRepository userRepository; // JPA Repository

	@PostConstruct
	public void initUsers() {
		// 관리자 계정
		UserData admin =
			UserData.builder()
				.userId("admin")
				.name("admin")
				.password(CommonConfig.passwordEncoder().encode("admin"))
				.type(UserType.SYS_ADMIN)
				.build();

		// 일반 사용자 계정
		UserData customer =
			UserData.builder()
				.userId("customer")
				.name("customer")
				.password(CommonConfig.passwordEncoder().encode("customer"))
				.type(UserType.CUSTOMER)
				.build();

		userRepository.saveAll(List.of(admin, customer));
	}
}