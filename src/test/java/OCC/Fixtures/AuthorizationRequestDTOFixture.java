package OCC.Fixtures;

import OCC.DTOs.Request.AuthorizationRequestDTO;
import OCC.Data.OCCDataTest;
import OCC.Enums.BrandEnum;
import OCC.Enums.GrantTypeEnum;
import OCC.Utils.Utils;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static OCC.Enums.BrandEnum.ALEXANDREBIRMAN;
import static OCC.Enums.BrandEnum.ALME;
import static OCC.Enums.BrandEnum.ANACAPRI;
import static OCC.Enums.BrandEnum.AREZZO;
import static OCC.Enums.BrandEnum.FIEVER;
import static OCC.Enums.BrandEnum.SCHUTZ;
import static OCC.Enums.BrandEnum.VANS;
import static OCC.Enums.BrandEnum.ZZMALL;
import static OCC.Enums.GrantTypeEnum.APPLE_ID;
import static OCC.Enums.GrantTypeEnum.CLIENT_CREDENTIALS;
import static OCC.Enums.GrantTypeEnum.FACEBOOK;
import static OCC.Enums.GrantTypeEnum.PASSWORD;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public final class AuthorizationRequestDTOFixture {

	private static String CONTENT_TYPE = "application/x-www-form-urlencoded";
	private static String CLIENT_ID = "mobile_android";
	private static String CLIENT_SECRET = "arezzoco2014";
	private static String SCOPE = "basic";
	private static List<GrantTypeEnum> grantTypes = new ArrayList<>();
	private static List<BrandEnum> brands = new ArrayList<>();

	static {
		grantTypes.add(PASSWORD);
		grantTypes.add(CLIENT_CREDENTIALS);
		grantTypes.add(APPLE_ID);
		grantTypes.add(FACEBOOK);
		brands.add(AREZZO);
		brands.add(ALEXANDREBIRMAN);
		brands.add(ANACAPRI);
		brands.add(ALME);
		brands.add(FIEVER);
		brands.add(SCHUTZ);
		brands.add(VANS);
		brands.add(ZZMALL);
	}

	private AuthorizationRequestDTO authorizationRequestDTO;

	private AuthorizationRequestDTOFixture() {
		this.authorizationRequestDTO = new AuthorizationRequestDTO();
	}

	public static AuthorizationRequestDTOFixture get() {
		return new AuthorizationRequestDTOFixture();
	}

	public static AuthorizationRequestDTOFixture getRandom() {
		return AuthorizationRequestDTOFixture.get().random();
	}

	public static List<AuthorizationRequestDTO> buildRandomList(int quantity) {
		return IntStream
				.range(0, quantity)
				.mapToObj(x -> AuthorizationRequestDTOFixture.get().random().build())
				.collect(Collectors.toList());
	}

	public static List<AuthorizationRequestDTO> buildRandomList() {
		return buildRandomList(nextInt(1, 10));
	}

	public AuthorizationRequestDTO build() {
		return authorizationRequestDTO;
	}

	private AuthorizationRequestDTOFixture random() {
		return this
			.withContentType(CONTENT_TYPE)
			.withClientId(CLIENT_ID)
			.withClientSecret(CLIENT_SECRET)
			.withScope(SCOPE)
			.withGrantType(grantTypes.get(nextInt(0, grantTypes.size())))
			.withSiteUid(brands.get(nextInt(0, brands.size())))
			.withUsername(UserRegisterRequestDTOFixture.get().automationUser().build().getUid())
			.withPassword(RandomStringUtils.random(5));
	}

	public AuthorizationRequestDTOFixture withDefaultUser() {
		authorizationRequestDTO.setGrantType(PASSWORD.getValue());
		authorizationRequestDTO.setUsername(OCCDataTest.getDefaultUser());
		authorizationRequestDTO.setPassword(OCCDataTest.getDefaultUserPassword());
		authorizationRequestDTO.setSiteUid(Utils.getSiteUid());
		return this;
	}

	public AuthorizationRequestDTOFixture withAnonymousUser() {
		authorizationRequestDTO.setGrantType(CLIENT_CREDENTIALS.getValue());
		authorizationRequestDTO.setSiteUid(null);
		authorizationRequestDTO.setUsername(null);
		authorizationRequestDTO.setPassword(null);
		return this;
	}

	public AuthorizationRequestDTOFixture withAppleUser() {
		authorizationRequestDTO.setGrantType(APPLE_ID.getValue());
		authorizationRequestDTO.setUsername(OCCDataTest.getAppleUserUsername());
		authorizationRequestDTO.setUserAppleId(OCCDataTest.getAppleUserAppledId());
		authorizationRequestDTO.setFirstName(OCCDataTest.getAppleUserFirstName());
		authorizationRequestDTO.setLastName(OCCDataTest.getAppleUserLastName());
		authorizationRequestDTO.setSiteUid(Utils.getSiteUid());
		return this;
	}

	public AuthorizationRequestDTOFixture withFacebookUser() {
		authorizationRequestDTO.setGrantType(FACEBOOK.getValue());
		authorizationRequestDTO.setFacebookToken(OCCDataTest.getFacebookToken());
		authorizationRequestDTO.setSiteUid(Utils.getSiteUid());
		return this;
	}

	public AuthorizationRequestDTOFixture withContentType(String contentType) {
		authorizationRequestDTO.setContentType(contentType);
		return this;
	}

	public AuthorizationRequestDTOFixture withClientId(String clientId) {
		authorizationRequestDTO.setClientId(clientId);
		return this;
	}

	public AuthorizationRequestDTOFixture withClientSecret(String clientSecret) {
		authorizationRequestDTO.setClientSecret(clientSecret);
		return this;
	}

	public AuthorizationRequestDTOFixture withGrantType(GrantTypeEnum grantType) {
		authorizationRequestDTO.setGrantType(grantType.getValue());
		return this;
	}

	public AuthorizationRequestDTOFixture withScope(String scope) {
		authorizationRequestDTO.setScope(scope);
		return this;
	}

	public AuthorizationRequestDTOFixture withSiteUid(BrandEnum siteUid) {
		authorizationRequestDTO.setSiteUid(siteUid.getValue());
		return this;
	}

	public AuthorizationRequestDTOFixture withUsername(String username) {
		authorizationRequestDTO.setUsername(username);
		return this;
	}

	public AuthorizationRequestDTOFixture withPassword(String password) {
		authorizationRequestDTO.setPassword(password);
		return this;
	}

}
