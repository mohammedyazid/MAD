package univbechar.dz.mad.Users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UsersConfig {
    @Bean
    CommandLineRunner commandLineRunner(UsersRepository repository){
        return args -> {
            Users user1 = new Users(
                    "Yazid",
                    "yazidl0.0l.bn@gmail.com"
            );
            Users user2 = new Users(
                    "Mohammed",
                    "mail@gmail.com"
            );
            Users user3 = new Users(
                    "user",
                    "user@mail.com"
            );
            repository.saveAll(List.of(user1,user2,user3));
        };
    }
}
