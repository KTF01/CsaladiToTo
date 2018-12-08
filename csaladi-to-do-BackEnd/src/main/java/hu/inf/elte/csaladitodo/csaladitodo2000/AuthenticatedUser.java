package hu.inf.elte.csaladitodo.csaladitodo2000;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import hu.inf.elte.csaladitodo.csaladitodo2000.modell.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RequestScope
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticatedUser {
    private User user;
}
