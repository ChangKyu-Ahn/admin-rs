package co.kr.user.modules.framework.output.rdb.data;

import co.kr.common.code.UserType;
import co.kr.common.converter.UserTypeConverter;
import co.kr.common.domain.vo.Password;
import co.kr.common.util.MapperUtil;
import co.kr.user.modules.domain.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
	name = "app_user",
	uniqueConstraints = {
		@UniqueConstraint(name = "uk01_user", columnNames = {"userId"})
	}
)
public class UserData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 15, nullable = false)
	private String userId;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 500, nullable = false)
	private String password;

	@Column(length = 3, nullable = false)
	@Convert(converter = UserTypeConverter.class)
	private UserType type;

	// ################################################################
	public void update(User user) {
		this.name = user.getName();
		this.password = MapperUtil.getValue(user.getPassword(), Password::getValue);
		this.type = user.getType();
	}
}
