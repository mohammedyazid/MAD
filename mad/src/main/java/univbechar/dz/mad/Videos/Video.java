package univbechar.dz.mad.Videos;

import javax.persistence.*;

@Entity
@Table
public class Video {
    @Id
    @SequenceGenerator(
            name = "video_sequence",
            sequenceName = "video_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "video_sequence"
    )
    private Long id;
    private String title;
    private String duration;

    public Video() {
    }

    public Video(Long id,
                 String title,
                 String duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Video(String title,
                 String duration) {
        this.title = title;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
