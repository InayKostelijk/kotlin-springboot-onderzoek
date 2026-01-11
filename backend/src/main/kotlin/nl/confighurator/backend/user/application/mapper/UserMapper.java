package nl.confighurator.backend.user.application.mapper;

import nl.confighurator.backend.user.application.dto.UserRetrieveDto;
import nl.confighurator.backend.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserRetrieveDto toUserDto(User user) {
        return new UserRetrieveDto(
                user.getId(),
                user.getUsername(),
                user.getEmail());
    }
}
