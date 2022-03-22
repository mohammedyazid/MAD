package univbechar.dz.mad.Videos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import univbechar.dz.mad.Users.Users;
import univbechar.dz.mad.Users.UsersRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> getVideo() {
        return videoRepository.findAll();
    }

    public void addNewVideo(Video video) {
        videoRepository.save(video);
    }

    public void deleteVideo(Long videoId) {
        boolean exists = videoRepository.existsById(videoId);
        if(!exists){
            throw new IllegalStateException("video with id " + videoId + " does not exists");
        }
        videoRepository.deleteById(videoId);
    }

    @Transactional
    public void updateVideo(Long videoId, String title, String duration) {
        Video video = videoRepository.findById(videoId).orElseThrow(()-> new IllegalStateException("video with id "+ videoId + "does not exist"));
        if(title != null && title.length()>0 && !Objects.equals(video.getTitle(), title)){
            video.setTitle(title);
        }
        if(duration != null && duration.length()>0 && !Objects.equals(video.getDuration(), duration)){
            video.setDuration(duration);
        }
    }
}
