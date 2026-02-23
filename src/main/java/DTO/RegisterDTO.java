package DTO;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO
{
    @NotBlank(message = "Email nie może być pusty")
    @Email(message = "To nie jest poprawny adres email")
    private String email;

    @NotBlank(message = "Imię nie może być puste")
    @Size(min = 3, max = 50, message = "Imię musi mieć od 3 do 50 znaków")
    private String name;

    @NotBlank(message = "Hasło jest wymagane")
    @Size(min = 8, message = "Hasło musi mieć minimum 8 znaków")
    private String password;
    public boolean verification;
}
