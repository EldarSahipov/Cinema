package com.java.cinema.view;

import com.java.cinema.entity.Hall;
import com.java.cinema.entity.HallRow;
import com.java.cinema.entity.Movie;
import com.java.cinema.entity.Screening;
import com.java.cinema.service.HallRowService;
import com.java.cinema.service.MoviesService;
import com.java.cinema.service.ScreeningService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
@AllArgsConstructor
@Log
public class ReservationController {

    @Autowired
    private ScreeningService screeningService;

    @Autowired
    private MoviesService moviesService;

    @Autowired
    private HallRowService hallRowService;

    @GetMapping("/reservation/{id}")
    public String reservation(Model model, @PathVariable Integer id) {
        Screening screening = screeningService.findScreeningById(id).orElse(null);
        assert screening != null;
        Optional<Movie> movie = moviesService.findMovieById(screening.getMovie().getId());
        Hall hall = screening.getHall();
        List<HallRow> seats = hallRowService.findHallRowsByIdHall(screening.getHall().getId()).stream().sorted().toList();
        model.addAttribute("screening", screening);
        model.addAttribute("movie", movie);
        model.addAttribute("seats", seats);
        model.addAttribute("hall", hall);
        return "reservation";
    }

    @GetMapping("/pay")
    public String paymentPassedPage() {
        return "pay";
    }
}
