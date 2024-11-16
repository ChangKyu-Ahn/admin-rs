package co.kr.user.modules.domain.mapper;

import co.kr.common.code.UserType;
import co.kr.common.domain.vo.Identifier;
import co.kr.common.domain.vo.Password;
import co.kr.user.modules.domain.entity.User;
import co.kr.user.modules.domain.entity.User.UserBuilder;
import co.kr.user.modules.framework.input.rest.dto.UserCreate;
import co.kr.user.modules.framework.input.rest.dto.UserDto;
import co.kr.user.modules.framework.input.rest.dto.UserLoginDto;
import co.kr.user.modules.framework.input.rest.dto.UserResponse;
import co.kr.user.modules.framework.input.rest.dto.UserUpdate;
import co.kr.user.modules.framework.output.rdb.data.UserData;
import org.apache.commons.lang3.ObjectUtils;

public class UserMapper {
	public static UserBuilder<?, ?> dtoToDomainBuilder(UserDto userDto) {
		return User.builder()
			.name(userDto.getName())
			.type(ObjectUtils.defaultIfNull(userDto.getType(), UserType.CUSTOMER))
			.password(Password.newInstanceWithEncrypted(userDto.getPassword()));
	}

	public static User createDtoToDomain(UserCreate userCreate) {
		return dtoToDomainBuilder(userCreate)
			.userId(userCreate.getId())
			.build();
	}

	public static User updateDtoToDomain(UserUpdate userUpdate) {
		return dtoToDomainBuilder(userUpdate).build();
	}

	public static User dataToDomain(UserData userData) {
		return User.builder()
			.id(userData.getId())
			.userId(userData.getUserId())
			.name(userData.getName())
			.password(Password.newInstance(userData.getPassword()))
			.type(userData.getType())
			.build();
	}

	public static User loginDtoToDomain(UserLoginDto userLoginDto) {
		return User.builder()
			.userId(userLoginDto.getId())
			.password(Password.newInstance(userLoginDto.getPassword()))
			.build();
	}

	public static UserResponse domainToResponseDto(User user) {
		return UserResponse.builder()
			.id(user.getUserId())
			.name(user.getName())
			.type(user.getType())
			.build();
	}

	public static Identifier<String> toUserIdResponse(User user) {
		return Identifier.<String>builder()
			.id(user.getUserId())
			.build();
	}
}
