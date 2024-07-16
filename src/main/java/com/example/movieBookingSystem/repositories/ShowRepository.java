package com.example.movieBookingSystem.repositories;

import com.example.movieBookingSystem.entities.Show;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {

    @Query(value = "select * from shows where date = :date and movie_id = :movieId and theater_id = :theaterId" , nativeQuery = true)
    public List<Show> getShowTimingsOnDate(@Param("date")Date date, @Param("movieId")Integer movieId, @Param("theaterId")Integer theaterId);

    @Query(value = "select movie_id from shows group by movie_id order by count(*) desc limit 1" , nativeQuery = true)
    public Integer getMostShowsMovie();

    @Query(value = "select * from shows where movie_id = :movieId" , nativeQuery = true)
    public List<Show> getAllShowsOfMovie(@Param("movieId")Integer movieId);
    public List<Show>findShowByDateAndTheaterIdAndMovieId(Date date, Integer theaterId, Integer movieId);
    public List<Show>findShowByMovieIdAndTheaterIdAndDate(Integer movieId, Integer theaterId, Date date);
}
