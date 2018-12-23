package com.ejogajog.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ejogajog.entities.User;
import com.ejogajog.services.UserService;
import com.ejogajog.utils.HttpServletUtils;

public class CustomTokenEnhancer implements TokenEnhancer {

	@Autowired
	private UserService userService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> additionalInfo = new HashMap<>();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		additionalInfo.put("exp", accessToken.getExpiration());
		this.loadRequestRelatedClaims(request, additionalInfo);
		this.loadUserRelatedClaims(authentication.getName(), additionalInfo);

		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
		return accessToken;
	}

	private void loadUserRelatedClaims(String email, Map<String, Object> additionalInfo) {
		User user = userService.getByEmail(email);
		if (user == null) {
			return;
		}
		additionalInfo.put("sub", user.getId());
	}

	private void loadRequestRelatedClaims(HttpServletRequest request, Map<String, Object> additionalInfo) {
		additionalInfo.put("iss", HttpServletUtils.getBaseUrl(request));
		additionalInfo.put("aud", HttpServletUtils.getRefererBaseUrl(request));
	}

}