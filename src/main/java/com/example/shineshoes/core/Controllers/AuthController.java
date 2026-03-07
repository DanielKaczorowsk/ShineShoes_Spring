package com.example.shineshoes.core.Auth;

import com.example.shineshoes.core.DTO.UserDTO;
import com.example.shineshoes.core.Services.RegisterService; // Twoja klasa z metodą register()
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final RegisterService registerService;

    public AuthController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        registerService.register(userDTO);
        return ResponseEntity.ok("Użytkownik zarejestrowany pomyślnie!");
    }
}