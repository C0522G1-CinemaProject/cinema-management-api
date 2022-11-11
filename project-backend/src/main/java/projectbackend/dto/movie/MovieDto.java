package projectbackend.dto.movie;

import projectbackend.model.employee.Employee;
import projectbackend.model.movie.MovieType;

import javax.validation.constraints.*;

public class MovieDto {
    private Integer id;

    @NotBlank(message = "Vui lòng nhập tên phim")
    @Size(min = 15, max = 50)
    private String name;
    private boolean isDelete;

    @NotBlank(message = "Vui lòng tải lên hình ảnh")
    private String image;

    @NotBlank(message = "Vui lòng nhập ngày bắt đầu")
    private String startDay;

    @NotBlank(message = "Vui lòng nhập ngày kết thúc")
    private String endDay;

    @NotBlank(message = "Vui lòng nhập tên đạo diễn")
    @Size(min = 2, max = 35)
    @Pattern(regexp = "^(([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5})| *$")
    private String director;

    @NotNull(message = "Vui lòng nhập thời lượng phim")
    @Max(value = 180)
    private Integer filmTime;

    @NotBlank(message = "Vui lòng nhập trailer")
    private String trailer;

    private String content;

    @NotBlank(message = "Vui lòng nhập hãng phim")
    @Size(min = 10, max = 25)
    private String filmStudio;

    @NotBlank(message = "Vui lòng nhập tên diễn viên")
    @Size(min = 2, max = 35)
    @Pattern(regexp = "^(([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5})| *$")
    private String actor;

    @NotNull(message = "Vui lòng chọn phiên bản")
    private Integer version;

    @NotNull(message = "Vui lòng chọn chọn thể loại")
    private MovieTypeDto movieTypeDto;

    private Employee employee;

    public MovieDto() {
    }

    public MovieDto(Integer id, String name, boolean isDelete, String image, String startDay, String endDay,
                    String director, Integer filmTime, String trailer, String content, String filmStudio,
                    String actor, Integer version, MovieTypeDto movieTypeDto, Employee employee) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
        this.image = image;
        this.startDay = startDay;
        this.endDay = endDay;
        this.director = director;
        this.filmTime = filmTime;
        this.trailer = trailer;
        this.content = content;
        this.filmStudio = filmStudio;
        this.actor = actor;
        this.version = version;
        this.movieTypeDto = movieTypeDto;
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getFilmTime() {
        return filmTime;
    }

    public void setFilmTime(Integer filmTime) {
        this.filmTime = filmTime;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilmStudio() {
        return filmStudio;
    }

    public void setFilmStudio(String filmStudio) {
        this.filmStudio = filmStudio;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public MovieTypeDto getMovieTypeDto() {
        return movieTypeDto;
    }

    public void setMovieType(MovieTypeDto movieTypeDto) {
        this.movieTypeDto = movieTypeDto;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
