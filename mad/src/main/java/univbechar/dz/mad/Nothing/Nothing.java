package univbechar.dz.mad.Nothing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Nothing {
    @GetMapping(path="/nothing")
    public String nothing(){
        return "There is nothing here!";
    }
}
