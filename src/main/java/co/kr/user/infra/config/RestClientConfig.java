package co.kr.user.infra.config;

import co.kr.common.api.BoardApi;
import co.kr.common.config.JwtTokenRestClientConfigurer;
import co.kr.common.io.rest.InternalClient;
import co.kr.common.io.rest.JwtTokenAuthorizedInterceptor;
import co.kr.common.properties.ApiProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestClient;

@Configuration
@RequiredArgsConstructor
public class RestClientConfig extends JwtTokenRestClientConfigurer {

	private static final int connectTimeOut = 10; // 초 단위
	private static final int readTimeOut = 10; // 초 단위

	private final ApiProperties apiProperties;

	@Bean
	ClientHttpRequestInterceptor jwtTokenAuthorizedInterceptor() {
		return new JwtTokenAuthorizedInterceptor();
	}

	@Bean
	public InternalClient boardInternalClient(ClientHttpRequestInterceptor jwtTokenAuthorizedInterceptor) {
		return getInternalClient(apiProperties.getBoard(), jwtTokenAuthorizedInterceptor);
	}

	@Bean
	public BoardApi boardApi(InternalClient boardInternalClient) {
		return new BoardApi(boardInternalClient);
	}

	private InternalClient getInternalClient(String baseUrl, ClientHttpRequestInterceptor jwtTokenAuthorizedInterceptor) {
		RestClient restClient = jwtTokenRestClient(connectTimeOut, readTimeOut, baseUrl, jwtTokenAuthorizedInterceptor);
		return new InternalClient(baseUrl, restClient);
	}

}