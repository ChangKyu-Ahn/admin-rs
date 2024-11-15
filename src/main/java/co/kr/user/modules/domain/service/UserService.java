package co.kr.user.modules.domain.service;

import co.kr.common.security.jwt.JwtTokenUtil;
import co.kr.common.security.jwt.dto.JwtUserDetailDto;
import co.kr.common.security.jwt.dto.JwtUserDetailResponse;
import co.kr.user.modules.domain.entity.User;

public class UserService {
	public static JwtUserDetailResponse creatToken(User request, User saved) throws Exception {
		UserValidationService.checkLoginPossible(request, saved);

		JwtUserDetailDto jwtTokenRequestDto = JwtUserDetailDto.newInstance(saved.getUserId(), saved.getType());
		return JwtTokenUtil.generateTokenAndSetTokenInfo(jwtTokenRequestDto);
	}
}
