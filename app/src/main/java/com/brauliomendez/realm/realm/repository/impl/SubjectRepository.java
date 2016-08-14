package com.brauliomendez.realm.realm.repository.impl;

import com.brauliomendez.realm.model.Subject;
import com.brauliomendez.realm.realm.repository.ISubjectRepository;

/**
 * @author Braulio Méndez Jiménez
 * @since 14/08/2016
 */
public class SubjectRepository implements ISubjectRepository {
    
    @Override public void addSubject(Subject subject, onSaveSubjectCallback callback) {

    }

    @Override public void deleteSubjectById(String id, OnDeleteSubjectCallback callback) {

    }

    @Override public void deleteSubjectByPosition(int position, OnDeleteSubjectCallback callback) {

    }

    @Override public void getAllSubjects(OnGetAllSubjectsCallback callback) {

    }

    @Override public void getSubjectsById(String id, OnGetSubjectByIdCallback callback) {

    }
}
