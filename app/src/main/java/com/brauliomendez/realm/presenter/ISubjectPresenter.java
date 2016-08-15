package com.brauliomendez.realm.presenter;

import com.brauliomendez.realm.model.Subject;

/**
 * @author Braulio Méndez Jiménez
 * @since 14/08/16
 */
public interface ISubjectPresenter extends IBasePresenter {

    void addSubject(Subject subject);

    void deleteSubjectById(String id);

    void deleteSubjectByPosition(int position);

    void getAllSubjects();

    void getSubjectsById(String id);
}
