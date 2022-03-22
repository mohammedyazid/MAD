package univbechar.dz.mad.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/users")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> getUser() {
        return usersService.getUser();
    }

    @PostMapping
    public void registerNewUsers(@RequestBody Users users){
        usersService.addNewUsers(users);
    }
    @DeleteMapping(path="{usersId}")
    public void deleteUsers(@PathVariable("usersId")Long usersId){
        usersService.deleteUsers(usersId);
    }
    @PutMapping(path="{usersId}")
    public void updateUsers(
            @PathVariable("usersId") Long usersId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        usersService.updateUsers(usersId,name,email);
    }
}