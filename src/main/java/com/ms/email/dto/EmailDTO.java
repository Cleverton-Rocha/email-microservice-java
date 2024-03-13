package com.ms.email.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailDTO(
                @NotBlank(message = "You must inform the recipient.") @Email(message = "Invalid email format for recipient.") String emailTo,

                @NotBlank(message = "Subject cannot be empty.") String subject,

                @NotBlank(message = "Message cannot be empty.") String message) {
}