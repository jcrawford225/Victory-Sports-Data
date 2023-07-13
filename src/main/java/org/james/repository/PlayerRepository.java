package org.james.repository;

import org.james.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Modifying
    @Query("DELETE FROM Player p WHERE p.playernumber = ?1")
    void deleteByPlayernumber(int playernumber);


}
