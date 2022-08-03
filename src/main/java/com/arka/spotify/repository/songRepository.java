package com.arka.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.arka.spotify.model.Song;

@Repository
public interface songRepository extends JpaRepository<Song, Long> {
	
}