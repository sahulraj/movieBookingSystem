package com.example.movieBookingSystem.service;

import com.example.movieBookingSystem.Exception.RequestedSeatAreNotAvailable;
import com.example.movieBookingSystem.Exception.ShowDoesNotExists;
import com.example.movieBookingSystem.Exception.UserDoesNotExists;
import com.example.movieBookingSystem.RequestDtos.TicketEntryDto;
import com.example.movieBookingSystem.ResponseDtos.TicketResponseDto;
import com.example.movieBookingSystem.entities.Show;
import com.example.movieBookingSystem.entities.ShowSeat;
import com.example.movieBookingSystem.entities.Ticket;
import com.example.movieBookingSystem.entities.User;
import com.example.movieBookingSystem.repositories.*;
import com.example.movieBookingSystem.transformers.TicketTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TheaterRepository theaterRepository;


    @Autowired
    private UserService userService;

    public TicketResponseDto ticketBooking(TicketEntryDto ticketEntryDto) throws RequestedSeatAreNotAvailable, UserDoesNotExists, ShowDoesNotExists{

        //check show present
        Optional<Show> showOpt = showRepository.findById(ticketEntryDto.getShowId());
        if(showOpt.isEmpty()) {
            throw new ShowDoesNotExists();
        }

        // check user present

        User user = userService.getLoggedInUser();
        Show show = showOpt.get();

        //check requested seat available
        Boolean isSeatAvailable = isSeatAvailable(show.getShowSeatList(), ticketEntryDto.getRequestSeats());
        if(!isSeatAvailable) {
            throw new RequestedSeatAreNotAvailable();
        }

        // count price
        Integer getPriceAndAssignSeats = getPriceAndAssignSeats(show.getShowSeatList(),ticketEntryDto.getRequestSeats());

        // change list to string
        String seats = listToString(ticketEntryDto.getRequestSeats());

        // create ticket entity and set all attribute
        Ticket ticket = new Ticket();
        ticket.setTotalTicketsPrice(getPriceAndAssignSeats);
        ticket.setBookedSeats(seats);

        // setting foreign key variables
        ticket.setUser(user);
        ticket.setShow(show);

        ticket = ticketRepository.save(ticket);

        user.getTicketList().add(ticket);
        show.getTicketList().add(ticket);
        userRepository.save(user);
        showRepository.save(show);




        // build Ticket Response Dto
        return TicketTransformer.returnTicket(show, ticket);
    }



    public Boolean isSeatAvailable(List<ShowSeat> showSeatList, List<String> requestSeats) {
        for(ShowSeat showSeat : showSeatList) {
            String seatNo = showSeat.getSeatNo();
            if(requestSeats.contains(seatNo)) {
                if(!showSeat.getIsAvailable()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Integer getPriceAndAssignSeats(List<ShowSeat> showSeatList, List<String> requestSeats) {
        Integer totalAmount = 0;
        for(ShowSeat showSeat : showSeatList) {
            if(requestSeats.contains(showSeat.getSeatNo())) {
                totalAmount += showSeat.getPrice();
                showSeat.setIsAvailable(Boolean.FALSE);
            }
        }
        return totalAmount;
    }

    public String listToString(List<String> requestSeats) {
        StringBuilder sb = new StringBuilder();
        for(String s : requestSeats) {
            sb.append(s).append(",");
        }
        return sb.toString();
    }
}
