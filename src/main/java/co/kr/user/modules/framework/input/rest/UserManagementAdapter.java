package co.kr.user.modules.framework.input.rest;

import co.kr.common.domain.vo.Identifier;
import co.kr.common.security.jwt.dto.JwtUserDetailResponse;
import co.kr.user.modules.application.usecase.UserCreateUsecase;
import co.kr.user.modules.application.usecase.UserDeleteUsecase;
import co.kr.user.modules.application.usecase.UserLoginUsecase;
import co.kr.user.modules.application.usecase.UserRetrieveUsecase;
import co.kr.user.modules.application.usecase.UserUpdateUsecase;
import co.kr.user.modules.framework.input.rest.dto.UserCreate;
import co.kr.user.modules.framework.input.rest.dto.UserLoginDto;
import co.kr.user.modules.framework.input.rest.dto.UserResponse;
import co.kr.user.modules.framework.input.rest.dto.UserUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserManagementAdapter {
	private static final String USER_ID_PATH = "/{userId}";

	private final UserCreateUsecase userCreateUsecase;
	private final UserUpdateUsecase userUpdateUsecase;
	private final UserDeleteUsecase userDeleteUsecase;
	private final UserRetrieveUsecase userRetrieveUsecase;
	private final UserLoginUsecase userLoginUsecase;

	/**
	 * <pre>
	 *  사용자 로그인
	 * </pre>
	 *
	 * @param userLoginDto User Login DTO
	 * @return JwtUserDetailResponse
	 */
	@PostMapping("/login")
	public JwtUserDetailResponse login(@RequestBody @Valid UserLoginDto userLoginDto) throws Exception {
		return userLoginUsecase.login(userLoginDto);
	}

	/**
	 * <pre>
	 *  사용자 생성
	 * </pre>
	 *
	 * @param userCreate User Create DTO
	 * @return User ID
	 */
	@PostMapping("/sign")
	@ResponseStatus(HttpStatus.CREATED)
	public Identifier<String> create(@RequestBody @Valid UserCreate userCreate) {
		return userCreateUsecase.create(userCreate);
	}

	/**
	 * <pre>
	 *  사용자 조회
	 * </pre>
	 *
	 * @param userId User ID
	 * @return User Detail Response DTO
	 */
	@GetMapping(USER_ID_PATH)
	public UserResponse detail(@PathVariable String userId) {
		return userRetrieveUsecase.detail(userId);
	}

	/**
	 * <pre>
	 *  사용자 수정
	 * </pre>
	 *
	 * @param userId User ID
	 * @return User Detail Response DTO
	 */
	@PutMapping(USER_ID_PATH)
	public Identifier<String> update(@PathVariable String userId, @RequestBody @Valid UserUpdate userUpdate) {
		return userUpdateUsecase.update(userId, userUpdate);
	}

	/**
	 * <pre>
	 *  사용자 삭제
	 * </pre>
	 *
	 * @param userId User ID
	 * @return User Detail Response DTO
	 */
	@DeleteMapping(USER_ID_PATH)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String userId) {
		userDeleteUsecase.delete(userId);
	}
}
