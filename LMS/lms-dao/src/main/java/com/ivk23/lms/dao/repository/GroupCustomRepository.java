package com.ivk23.lms.dao.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ivk23.lms.commons.interfaces.IEmployee;
import com.ivk23.lms.commons.utils.Pair;
import com.ivk23.lms.dao.domain.Group;

@Repository
public class GroupCustomRepository {

	@Autowired
	private EntityManager em;

	/**
	 * Returns list of mentors with more than <code>numberOfMentee</code> mentee
	 * active.
	 * 
	 * @param numberOfMentee
	 * @return
	 */
	public List<IEmployee> mentorsWithSeveralMentee(int numberOfMentee) {
		final List<IEmployee> employees = new ArrayList<>();

		final TypedQuery<Object[]> query = em.createQuery(
				"SELECT g.mentor, count(g.mentee) FROM Group g WHERE g.palnnedEndDate > :today  GROUP BY g.mentor HAVING count(g.mentee) > :numberOfMentee",
				Object[].class);
		query.setParameter("today", new Date());
		query.setParameter("numberOfMentee", Long.valueOf(numberOfMentee));
		List<Object[]> resultList = query.getResultList();

		resultList.forEach((el) -> {
			employees.add((IEmployee) el[0]);
		});

		return employees;
	}

	public List<IEmployee> menteeWithoutMentorInOffice(final String office) {
		final List<IEmployee> employees = new ArrayList<>();

		final TypedQuery<IEmployee> query = em.createQuery(
				"SELECT p.employee FROM PhasePartisipAssignments p WHERE p.role.id = 2 AND p.phase.mentorshipProgram.office = :office AND  NOT EXISTS (SELECT g.mentee FROM Group g WHERE g.mentee = p.employee)",
				IEmployee.class);
		query.setParameter("office", office);
		employees.addAll(query.getResultList());

		return employees;
	}

	public List<Pair<IEmployee, Long>> menteesGrouppedByDuration() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);

		Root<Group> root = query.from(Group.class);

		query.multiselect(root.get("mentee"), cb.sum(root.get("duration")));
		query.groupBy(root.get("mentee"));

		TypedQuery<Object[]> q = em.createQuery(query);

		final List<Pair<IEmployee, Long>> result = new ArrayList<>();

		q.getResultList().forEach((el) -> {
			result.add(new Pair<IEmployee, Long>((IEmployee) el[0], (Long) el[1]));
		});

		return result;
	}

}
