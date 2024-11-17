package co.kr.user.infra.config;

import co.kr.common.config.TaskExecutorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class AsyncConfig extends TaskExecutorConfigurer {

	@Bean
	public TaskExecutor taskExecutor() {
		return taskExecutor(30, 30, 1000);
	}
}
