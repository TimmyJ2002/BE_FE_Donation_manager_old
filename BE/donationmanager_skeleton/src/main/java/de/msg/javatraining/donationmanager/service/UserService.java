package de.msg.javatraining.donationmanager.service;

import de.msg.javatraining.donationmanager.persistence.model.DTOs.UserDTO;
import de.msg.javatraining.donationmanager.persistence.model.User;
import de.msg.javatraining.donationmanager.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static de.msg.javatraining.donationmanager.persistence.model.DTOs.UserMapper.mapUserDTOToUser;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public User createUser(UserDTO userDTO){
        validateUserInput(userDTO);


        //Converts userDto to user
        User user = mapUserDTOToUser(userDTO);

        //Username generation
        String generatedUsername = generateUniqueUsername(user.getFirstName(), user.getLastName());

        user.setUsername(generatedUsername);

        //Initial Password generation
        String initialPassword = generateInitialPassword();
        user.setPassword(initialPassword);

        //Send email
       // sendWelcomeEmail(user.getEmail(), initialPassword);

        //initial login count 0 & is_active status true
        user.setLoginCount(0);
        user.setActive(true);




        return userRepository.save(user);
    }



    private String generateInitialPassword() {
        UUID uuid = UUID.randomUUID();
        String initialPassword = uuid.toString().replace("-","").substring(0,10); // For 10 character long Password

        return initialPassword;
    }

    public String generateUniqueUsername(String firstName, String lastName) {
        String baseUsername = (lastName.substring(0, Math.min(5, lastName.length())) +
                firstName.substring(0, 1)).toLowerCase();

        int count = 1;
        String username = baseUsername;
        username = baseUsername + count;
        while (userRepository.existsByUsername(username)) {
            count++;
            username = baseUsername + count;
        }

        return username;
    }



    private void validateUserInput(UserDTO userDTO) {

    }
}
