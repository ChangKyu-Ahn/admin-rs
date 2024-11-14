package co.kr.user.modules.domain.entity;

import co.kr.common.domain.vo.Identifier;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class User extends Identifier<Long> {
	private String userId;
	private String name;
	private String password;
}
