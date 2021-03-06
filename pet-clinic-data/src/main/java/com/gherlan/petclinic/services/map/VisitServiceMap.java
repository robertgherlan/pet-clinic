package com.gherlan.petclinic.services.map;

import com.gherlan.petclinic.model.Visit;
import com.gherlan.petclinic.services.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit save(Visit visit) {
        if (visit != null) {
            if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null) {
                throw new RuntimeException("Invalid visit.");
            }

            return super.save(visit);
        }

        return null;
    }

    @Override
    public Set<Visit> findByPetId(Long petId) {
        return findAll().stream().filter(visit -> visit.getPet().getId().equals(petId)).collect(Collectors.toSet());
    }
}
