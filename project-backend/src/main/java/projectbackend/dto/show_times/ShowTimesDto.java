package projectbackend.dto.show_times;

import projectbackend.model.movie.Movie;
import projectbackend.model.room.Room;
import projectbackend.model.show_times.Times;

import java.sql.Date;
import java.util.List;

public class ShowTimesDto {
    private Integer id;
    private Date dateProjection;
    private Movie movie;
    private Times times;
    private Room room;

    public ShowTimesDto() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getDateProjection() {
        return dateProjection;
    }

    public void setDateProjection(Date dateProjection) {
        this.dateProjection = dateProjection;
    }

    public Times getTimes() {
        return times;
    }

    public void setTimes(Times times) {
        this.times = times;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}

