package nl.confighurator.backend.user.application.dto;

import org.jetbrains.annotations.NotNull;

public record UserDto(Long id, @NotNull String username,@NotNull String password,@NotNull String email) {
}

