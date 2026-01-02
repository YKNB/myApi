package com.springboot.Api.controller;


import com.springboot.Api.dto.user.RegisterDto;
import com.springboot.Api.service.auth.AuthService;
import com.springboot.Api.dto.auth.LoginDto;
import com.springboot.Api.dto.auth.LoginResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Tag(name = "Auth")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Login User that give a user info and access token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User details",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = LoginResponseDto.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Bad Credentials!",
                    content = @Content)
    })

    @PostMapping("/auth")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto dto) {
        return authService.login(dto);
    }

    @PostMapping("/user")
    public ResponseEntity<String> register(@RequestBody RegisterDto dto) {
        return authService.register(dto);
    }
}
