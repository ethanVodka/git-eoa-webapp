package com.eoa.webapp.core.ic.controller;

import com.eoa.webapp.core.config.InstagramConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class InstagramAuthController {
    private final InstagramConfig config;
    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/callback")
    public ResponseEntity<?> callback(@RequestParam("code") String code) {
        String tokenUrl = "https://api.instagram.com/oauth/access_token";

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("client_id", config.getClientId());
        body.add("client_secret", config.getClientSecret());
        body.add("grant_type", "authorization_code");
        body.add("redirect_uri", config.getRedirectUri());
        body.add("code", code);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.exchange(tokenUrl, HttpMethod.POST, request, Map.class);
        Map<String, Object> responseBody = response.getBody();

        String accessToken = (String) Objects.requireNonNull(responseBody).get("access_token");

        // 必要なら Instagram ユーザー情報も取得する
        // String userId = ((Map)responseBody.get("user")).get("id").toString();

        return ResponseEntity.ok(Collections.singletonMap("access_token", accessToken));
    }

    @GetMapping("/me")
    public ResponseEntity<?> getUserInfo(@RequestParam("access_token") String accessToken) {
        String url = "https://graph.instagram.com/me?fields=id,username&access_token=" + accessToken;
        Map response = restTemplate.getForObject(url, Map.class);
        return ResponseEntity.ok(response);
    }
}
