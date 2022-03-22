package univbechar.dz.mad.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUser() {
        return usersRepository.findAll();
    }

    public void addNewUsers(Users users) {
        Optional<Users> usersOptional= usersRepository.findUsersByEmail(users.getEmail());
        if(usersOptional.isPresent()){
            throw new IllegalStateException("Email ALready Taken!");
        }
        usersRepository.save(users);
    }

    public void deleteUsers(Long usersId) {
        boolean exists = usersRepository.existsById(usersId);
        if(!exists){
            throw new IllegalStateException("user with id " + usersId + " does not exists");
        }
        usersRepository.deleteById(usersId);
    }
    @Transactional
    public void updateUsers(Long usersId, String name, String email) {
        Users users = usersRepository.findById(usersId).orElseThrow(()-> new IllegalStateException("user with id "+ usersId + "does not exist"));
    if(name != null && name.length()>0 && !Objects.equals(users.getUsername(), name)){
        users.setUsername(name);
    }
        if(email != null && email.length()>0 && !Objects.equals(users.getEmail(), email)){
            Optional<Users> usersOptional = usersRepository.findUsersByEmail(email);
            if(usersOptional.isPresent()){
                throw new IllegalStateException("Email Already Taken!");
            }
            users.setEmail(email);
        }
    }
}
