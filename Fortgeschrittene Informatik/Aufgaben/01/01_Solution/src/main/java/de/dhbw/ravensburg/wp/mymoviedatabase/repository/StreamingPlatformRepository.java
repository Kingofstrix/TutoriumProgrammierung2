package de.dhbw.ravensburg.wp.mymoviedatabase.repository;

import de.dhbw.ravensburg.wp.mymoviedatabase.model.StreamingPlatform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreamingPlatformRepository extends JpaRepository<StreamingPlatform, Long> {

    @Query("SELECT p FROM StreamingPlatform p JOIN p.movies m WHERE m.title = :param1")
    List<StreamingPlatform> findAllPlatformsWithMovieTitle(@Param("param1") String movieTitle);
}
