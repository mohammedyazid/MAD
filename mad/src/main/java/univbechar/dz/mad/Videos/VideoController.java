package univbechar.dz.mad.Videos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import univbechar.dz.mad.Users.Users;
import univbechar.dz.mad.Users.UsersService;

import java.util.List;

@RestController
@RequestMapping(path="/videos")
public class VideoController {
    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping
    public List<Video> getVideo() {
        return videoService.getVideo();
    }

    @PostMapping
    public void registerNewVideo(@RequestBody Video video){
        videoService.addNewVideo(video);
    }
    @DeleteMapping(path="{videoId}")
    public void deleteVideo(@PathVariable("videoId")Long videoId){
        videoService.deleteVideo(videoId);
    }
    @PutMapping(path="{videoId}")
    public void updateVideo(
            @PathVariable("videoId") Long videoId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String duration){
        videoService.updateVideo(videoId,title,duration);
    }
}