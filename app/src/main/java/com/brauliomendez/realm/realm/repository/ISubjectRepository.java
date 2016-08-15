package com.brauliomendez.realm.realm.repository;

import com.brauliomendez.realm.model.Subject;

import io.realm.RealmResults;

/**
 * @author Braulio Mendez Jimenez
 * @since 14/08/16
 */
public interface ISubjectRepository {

    interface OnSaveSubjectCallback {
        void onSuccess();

        void onError(String message);
    }

    interface OnDeleteSubjectCallback {
        void onSuccess();

        void onError(String message);
    }

    interface OnGetSubjectByIdCallback {
        void onSuccess(Subject subject);

        void onError(String message);
    }

    interface OnGetAllSubjectsCallback {
        void onSuccess(RealmResults<Subject> subjects);

        void onError(String message);
    }

    void addSubject(Subject subject, OnSaveSubjectCallback callback);

    void deleteSubjectById(String id, OnDeleteSubjectCallback callback);

    void deleteSubjectByPosition(int position, OnDeleteSubjectCallback callback);

    void getAllSubjects(OnGetAllSubjectsCallback callback);

    void getSubjectsById(String id, OnGetSubjectByIdCallback callback);
}
