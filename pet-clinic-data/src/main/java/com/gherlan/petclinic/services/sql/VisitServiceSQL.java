package com.gherlan.petclinic.services.sql;

import com.gherlan.petclinic.model.Visit;
import com.gherlan.petclinic.repositories.VisitRepository;
import com.gherlan.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("sql")
public class VisitServiceSQL extends CrudServiceSQL<Visit, Long> implements VisitService {

    private final VisitRepository visitRepository;

    public VisitServiceSQL(VisitRepository visitRepository) {
        super(visitRepository);
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findByPetId(Long petId) {
        return visitRepository.findByPetId(petId);
    }
}