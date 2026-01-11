package nl.confighurator.backend.user.application;

import jakarta.transaction.Transactional;
import nl.confighurator.backend.user.application.dto.UserDto;
import nl.confighurator.backend.user.application.dto.UserRetrieveDto;
import nl.confighurator.backend.user.application.mapper.UserMapper;
import nl.confighurator.backend.user.data.UserRepository;
import nl.confighurator.backend.user.domain.User;
import nl.confighurator.backend.user.presentation.exception.BadRequestException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserRetrieveDto getUserById(Long id){
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            throw new BadRequestException("User not found");
        }

        return userMapper.toUserDto(user);
    }

    public void createUser(UserDto userDto) {
        User user = new User(
                null,
                userDto.username(),
                userDto.password(),
                userDto.email()
        );
        userRepository.save(user);

    }

    public void updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new BadRequestException("User not found");
        }
        user.updateUser(
                userDto.username(),
                userDto.password(),
                userDto.email()
        );
    }

}
