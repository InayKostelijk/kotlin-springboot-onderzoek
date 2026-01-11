package nl.confighurator.backend.user.presentation;

import jakarta.validation.Valid;
import nl.confighurator.backend.user.presentation.exception.ResourceNotFoundException;
import nl.confighurator.backend.user.application.UserService;
import nl.confighurator.backend.user.application.dto.UserDto;
import nl.confighurator.backend.user.application.dto.UserRetrieveDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok("Het aanmaken van de gebruiker is gelukt");
    }


    @GetMapping("/{userId}")
    public ResponseEntity<UserRetrieveDto> getUser(@Valid @PathVariable Long userId) {
        UserRetrieveDto userById = userService.getUserById(userId);
        if (userById == null) {
            throw new ResourceNotFoundException("User with id " + userId + " not found");
        }
        return ResponseEntity.ok(userById);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@Valid @PathVariable Long userId, @RequestBody UserDto userDto) {
        userService.updateUser(userId, userDto);
        return ResponseEntity.ok("Het updated van de gebruiker is gelukt");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@Valid @PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("Gebruiker is verwijderd");
    }

}
