package com.origemite.springvault.service;

import com.origemite.springvault.dto.VaultPermissionRequestDto;
import com.origemite.springvault.dto.VaultPermissionResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class VaultPermissionService {
    private final VaultTemplate vaultTemplate;

    private String getPath(String userId) {
        return "secret/data/user-permissions/" + userId;
    }

    public void save(String userId, VaultPermissionRequestDto dto) {
        Map<String, Object> data = new HashMap<>();
        data.put("get", dto.getGet());
        data.put("post", dto.getPost());
        data.put("put", dto.getPut());
        data.put("delete", dto.getDelete());

        vaultTemplate.write(getPath(userId), Map.of("data", data));
    }

    public VaultPermissionResponseDto read(String userId) {
        VaultResponse response = vaultTemplate.read(getPath(userId));
        Map<String, Object> data = Optional.ofNullable(response)
                .map(VaultResponse::getData)
                .map(d -> (Map<String, Object>) d.get("data"))
                .orElse(Map.of());

        VaultPermissionResponseDto dto = new VaultPermissionResponseDto();
        dto.setUserId(userId);
        dto.setGet((List<String>) data.getOrDefault("get", List.of()));
        dto.setPost((List<String>) data.getOrDefault("post", List.of()));
        dto.setPut((List<String>) data.getOrDefault("put", List.of()));
        dto.setDelete((List<String>) data.getOrDefault("delete", List.of()));

        return dto;
    }

    public void delete(String userId) {
        vaultTemplate.delete(getPath(userId));
    }
}
