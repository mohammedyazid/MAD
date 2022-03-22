package univbechar.dz.mad.AlsoNothing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlsoNothing {
    @GetMapping(path="/alsonothing")
    public String nothing(){
        return "What are you doing here?";
    }
}
