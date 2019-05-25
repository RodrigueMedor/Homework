package com.elibrarysecurity.projectsecurity.service;



import com.elibrarysecurity.projectsecurity.model.Position;

import javax.crypto.spec.PSource;
import java.util.List;
import java.util.Optional;

public interface IPositionService {
    Position createPosition(Position position);
    void removePosition(Position position);
    List<Position> getAllPositions();
    Optional<Position> findPositionByNumber(int positionId);
}
