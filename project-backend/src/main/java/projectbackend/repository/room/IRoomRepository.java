package projectbackend.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projectbackend.model.room.Room;

import java.util.List;

public interface IRoomRepository extends JpaRepository<Room, Integer> {

    @Query(value = "select name from room where is_delete = 0", nativeQuery = true)
    List<Room> findAll();
}
