package nl.confighurator.backend.user.application.dto;

import org.jetbrains.annotations.NotNull;

public record UserRetrieveDto(Long id, @NotNull String username,@NotNull String email) {

}
