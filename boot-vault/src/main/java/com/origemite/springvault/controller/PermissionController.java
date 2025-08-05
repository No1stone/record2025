package com.origemite.springvault.controller;

import com.origemite.springvault.dto.VaultPermissionRequestDto;
import com.origemite.springvault.dto.VaultPermissionResponseDto;
import com.origemite.springvault.service.VaultPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final VaultPermissionService service;

    @PostMapping("/{userId}")
    public ResponseEntity create(@PathVariable String userId, @RequestBody VaultPermissionRequestDto dto) {
        service.save(userId, dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity update(@PathVariable String userId, @RequestBody VaultPermissionRequestDto dto) {
        service.save(userId, dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public VaultPermissionResponseDto read(@PathVariable String userId) {
        return service.read(userId);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity delete(@PathVariable String userId) {
        service.delete(userId);
        return ResponseEntity.ok().build();
    }
}
