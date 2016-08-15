package com.brauliomendez.realm.realm.repository.impl;

import com.brauliomendez.realm.app.RealmApp;
import com.brauliomendez.realm.model.Subject;
import com.brauliomendez.realm.realm.repository.ISubjectRepository;
import com.brauliomendez.realm.realm.table.IRealmTable;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * @author Braulio Méndez Jiménez
 * @since 14/08/2016
 */
public class SubjectRepository implements ISubjectRepository {
    
    @Override public void addSubject(Subject subject, onSaveSubjectCallback callback) {
        Realm mRealm = Realm.getInstance(RealmApp.getInstance());
        mRealm.beginTransaction();
        Subject mSubject = mRealm.createObject(Subject.class);
        mSubject.setId(UUID.randomUUID().toString());
        mSubject.setTeacher(subject.getTeacher());
        mSubject.setAssistant(subject.getAssistant());
        mSubject.setClassroom(subject.getClassroom());
        mSubject.setHour(subject.getHour());
        mRealm.commitTransaction();

        if (callback != null){
            callback.onSuccess();
        }
    }

    @Override public void deleteSubjectById(String id, OnDeleteSubjectCallback callback) {
        Realm mRealm = Realm.getInstance(RealmApp.getInstance());
        mRealm.beginTransaction();
        Subject mSubject = mRealm.where(Subject.class).equalTo(IRealmTable.ID, id).findFirst();
        mSubject.removeFromRealm();
        mRealm.commitTransaction();

        if (callback != null)
            callback.onSuccess();
    }

    @Override public void deleteSubjectByPosition(int position, OnDeleteSubjectCallback callback) {
        Realm mRealm = Realm.getInstance(RealmApp.getInstance());
        mRealm.beginTransaction();
        RealmQuery<Subject> mQuery = mRealm.where(Subject.class);
        RealmResults<Subject> mResults = mQuery.findAll();
        mResults.remove(position);
        mRealm.commitTransaction();

        if (callback != null)
            callback.onSuccess();
    }

    @Override public void getAllSubjects(OnGetAllSubjectsCallback callback) {
        Realm mRealm = Realm.getInstance(RealmApp.getInstance());
        RealmResults<Subject> mResults =  mRealm.where(Subject.class).findAll();

        if (callback != null)
            callback.onSuccess(mResults);
    }

    @Override public void getSubjectsById(String id, OnGetSubjectByIdCallback callback) {
        Realm mRealm = Realm.getInstance(RealmApp.getInstance());
        Subject mSubject = mRealm.where(Subject.class).equalTo(IRealmTable.ID, id).findFirst();

        if (callback != null)
            callback.onSuccess(mSubject);
    }
}
