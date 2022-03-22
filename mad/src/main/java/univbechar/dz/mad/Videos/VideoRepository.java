package univbechar.dz.mad.Videos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import univbechar.dz.mad.Videos.Video;

import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    @Query("SELECT s FROM Video s WHERE s.title =?1")
    Optional<Video> findVideoByTitle(String title);
}
