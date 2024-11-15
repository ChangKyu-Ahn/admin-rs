package co.kr.user.modules.framework.input.rest.dto;


import co.kr.common.code.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	private String id;
	private String name;
	private UserType type;
}
