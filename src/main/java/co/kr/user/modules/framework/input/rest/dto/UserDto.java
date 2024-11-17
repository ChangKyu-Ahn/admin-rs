package co.kr.user.modules.framework.input.rest.dto;


import co.kr.common.code.UserType;
import co.kr.common.util.SecurityUtil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserDto{
	@NotBlank
	@Pattern(regexp = "^[A-Za-z가-힣\\s]{2,50}$", message = "영문, 공백, 한글 입력 가능하며 최소 2글자에서 최대 50글자까지 입력 가능합니다.")
	private String name;

	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9\\s!@#$%^&*(),.?\":{}|<>]{5,20}$", message = "대소문자, 숫자, 특수문자 입력이 가능하며 최소 5자 이상 최대 20자까지 가능합니다")
	private String password;

	private UserType type;

	public UserType getType() {
		return SecurityUtil.isAdmin() ? this.type : UserType.CUSTOMER;
	}
}
