package co.kr.user.modules.framework.output.rdb.mapper;

import co.kr.common.domain.vo.Password;
import co.kr.common.util.MapperUtil;
import co.kr.user.modules.domain.entity.User;
import co.kr.user.modules.framework.output.rdb.data.UserData;

public class UserRDBMapper {
	public static UserData domainToData(User user) {
		return UserData.builder()
			.userId(user.getUserId())
			.name(user.getName())
			.password(MapperUtil.getValue(user.getPassword(), Password::getValue))
			.type(user.getType())
			.build();
	}
}
