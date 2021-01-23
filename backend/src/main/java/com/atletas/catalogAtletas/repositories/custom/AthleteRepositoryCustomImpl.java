package com.atletas.catalogAtletas.repositories.custom;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.atletas.catalogAtletas.dto.AthleteResumedDTO;
import com.atletas.catalogAtletas.entities.Athlete;
import com.atletas.catalogAtletas.resources.filters.AthleteFilter;

public class AthleteRepositoryCustomImpl implements AthleteRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<AthleteResumedDTO> findResumedPage(AthleteFilter filter, Pageable pageSettings) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<AthleteResumedDTO> criteria = builder.createQuery(AthleteResumedDTO.class);
        Root<Athlete> root = criteria.from(Athlete.class);

        criteria.select(builder.construct(AthleteResumedDTO.class,
                                          root.get("id"),
                                          root.get("codAthlete"),
                                          root.get("name"),
                                          root.get("dtBirth"),
                                          root.get("nmFather"),
                                          root.get("nmMother"),
                                          root.get("identity"),
                                          root.get("certBirth"),
                                          root.get("cpf")));
        criteria.where(createRestrictions(filter, builder, root));

        TypedQuery<AthleteResumedDTO> query = em.createQuery(criteria);
        query.setFirstResult(pageSettings.getPageNumber() * pageSettings.getPageSize());
        query.setMaxResults(pageSettings.getPageSize());

        return new PageImpl<>(query.getResultList(), pageSettings, getTotalElementsHandler(filter));
    }

    /**
     * Busca o total de elementos
     * 
     * @param filter
     * 
     * @return
     */
    private Long getTotalElementsHandler(AthleteFilter filter) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
        Root<Athlete> root = criteriaQuery.from(Athlete.class);
        criteriaQuery.select(builder.count(root));
        criteriaQuery.where(createRestrictions(filter, builder, root));

        return em.createQuery(criteriaQuery).getSingleResult();
    }

    /**
     * Cria as restrições da consulta baseadas no filtro (Cláusula WHERE)
     * 
     * @param filter
     * @param builder
     * @param root
     * @return
     */
    private Predicate[] createRestrictions(AthleteFilter filter, CriteriaBuilder builder, Root<Athlete> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (isNotNulllOrBlank(filter.getId()) && isNumeric(filter.getId())) {
            predicates.add(builder.equal(root.get("id"), Long.parseLong(filter.getId())));
        }

        if (isNotNulllOrBlank(filter.getName())) {
            predicates.add(builder.like(root.get("name"), "%".concat(filter.getName()).concat("%")));
        }

        if (isNotNulllOrBlank(filter.getIdCategory())) {
            predicates.add(builder.equal(root.get("idCategory"), Long.parseLong(filter.getIdCategory())));
        }

        if (isNotNulllOrBlank(filter.getCodAthlete())) {
            predicates.add(builder.equal(root.get("codAthlete"), Long.parseLong(filter.getCodAthlete())));
        }

        if (isNotNulllOrBlank(filter.getIdModality())) {
            predicates.add(builder.equal(root.get("idModality"), Long.parseLong(filter.getIdModality())));
        }

        if (isNotNulllOrBlank(filter.getIdSchool())) {
            predicates.add(builder.equal(root.get("idSchool"), Long.parseLong(filter.getIdSchool())));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

    private boolean isNumeric(String number) {
        try {
            Long.parseLong(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isNotNulllOrBlank(String string) {
        return string != null && !string.isBlank();
    }

}
