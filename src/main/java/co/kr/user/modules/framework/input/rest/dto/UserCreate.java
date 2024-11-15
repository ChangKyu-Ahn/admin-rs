package co.kr.user.modules.framework.input.rest.dto;


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
public class UserCreate extends UserDto {
	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9]{3,15}$", message = "영문 및 숫자 입력이 가능하며 최소 3글자에서 최대 15글자까지 입력 가능합니다")
	private String id;
}
