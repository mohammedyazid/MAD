package univbechar.dz.mad.Videos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import univbechar.dz.mad.Users.Users;
import univbechar.dz.mad.Users.UsersRepository;

import java.util.List;

@Configuration
public class VideoConfig {
    @Bean
    CommandLineRunner commandLinerunner(VideoRepository repository){
        return args -> {
            Video video1 = new Video(
                    "Video 1",
                    "2:24"
            );
            Video video2 = new Video(
                    "Video 2",
                    "30:01"
            );
            Video video3 = new Video(
                    "Video 3",
                    "1:40"
            );
            repository.saveAll(List.of(video1,video2,video3));
        };
    }
}
