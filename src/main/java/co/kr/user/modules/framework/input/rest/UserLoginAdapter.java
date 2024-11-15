package co.kr.user.modules.framework.input.rest;

import co.kr.common.security.jwt.dto.JwtUserDetailResponse;
import co.kr.user.modules.application.usecase.UserLoginUsecase;
import co.kr.user.modules.framework.input.rest.dto.UserLoginDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users/login")
@RequiredArgsConstructor
public class UserLoginAdapter {
	private final UserLoginUsecase userLoginUsecase;

	/**
	 * <pre>
	 *  사용자 로그인
	 * </pre>
	 *
	 * @param userLoginDto User Login DTO
	 * @return JwtUserDetailResponse
	 */
	@PostMapping
	public JwtUserDetailResponse login(@RequestBody @Valid UserLoginDto userLoginDto) throws Exception {
		return userLoginUsecase.login(userLoginDto);
	}
}
