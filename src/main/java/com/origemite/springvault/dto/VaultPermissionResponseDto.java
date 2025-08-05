package com.origemite.springvault.dto;

import lombok.Data;
import java.util.List;

@Data
public class VaultPermissionResponseDto {
    private String userId;

    private List<String> get;
    private List<String> post;
    private List<String> put;
    private List<String> delete;
}
