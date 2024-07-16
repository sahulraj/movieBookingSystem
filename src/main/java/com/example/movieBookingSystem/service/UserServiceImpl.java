package com.example.movieBookingSystem.service;

import com.example.movieBookingSystem.Exception.UserAlreadyExistsWithEmail;
import com.example.movieBookingSystem.Exception.UserDoesNotExists;
import com.example.movieBookingSystem.RequestDtos.UserEntryDto;
import com.example.movieBookingSystem.ResponseDtos.TicketResponseDto;
import com.example.movieBookingSystem.entities.Role;
import com.example.movieBookingSystem.entities.Ticket;
import com.example.movieBookingSystem.entities.User;
import com.example.movieBookingSystem.entities.UserModel;
import com.example.movieBookingSystem.repositories.RoleRepository;
import com.example.movieBookingSystem.repositories.UserRepository;
import com.example.movieBookingSystem.transformers.TicketTransformer;
import com.example.movieBookingSystem.transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    public String addUser(UserEntryDto userEntryDto) throws UserAlreadyExistsWithEmail {
        if(userRepository.findByEmail(userEntryDto.getEmailId()) != null) {
            throw new UserAlreadyExistsWithEmail();
        }
        User user = UserTransformer.userDtoToUser(userEntryDto);

        userRepository.save(user);
        return "User Saved Successfully";
    }
    public User createUser(UserModel userModel)
    {
        Optional<User> user1 = userRepository.findByEmail(userModel.getEmail());
        if(user1.isPresent())throw new UserAlreadyExistsWithEmail();
//        if(userRepository.findByEmail(userModel.getEmail()) != null) {
//            System.out.println("user already exists");
//            throw new UserAlreadyExistsWithEmail();
//        }
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setMobileNumber(userModel.getMobileNumber());
        user.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
        for(String s : userModel.getRoles())
        {
            Role role = roleRepository.findByName(s);
            user.getRoles().add(role);
        }
        user.setName(userModel.getName());
        user = userRepository.save(user);
        System.out.println(user);
        return user;


    }

    public User getLoggedInUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email =authentication.getName();
        return userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("user not found with the given mail id"));
    }

    public List<TicketResponseDto> allTickets() throws UserDoesNotExists {
        User user = getLoggedInUser();
        List<Ticket> ticketList = user.getTicketList();
        List<TicketResponseDto> ticketResponseDtos = new ArrayList<>();
        for(Ticket ticket : ticketList) {
            TicketResponseDto ticketResponseDto = TicketTransformer.returnTicket(ticket.getShow(), ticket);
            ticketResponseDtos.add(ticketResponseDto);
        }
        return ticketResponseDtos;
    }
}
