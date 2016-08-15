package com.brauliomendez.realm.presenter.impl;

import com.brauliomendez.realm.model.Subject;
import com.brauliomendez.realm.presenter.ISubjectPresenter;
import com.brauliomendez.realm.realm.repository.ISubjectRepository;
import com.brauliomendez.realm.realm.repository.impl.SubjectRepository;
import com.brauliomendez.realm.view.activity.SubjectActivity;

import io.realm.RealmResults;

/**
 * @author Braulio Méndez Jiménez
 * @since 14/08/16
 */
public class SubjectPresenter implements ISubjectPresenter {

    private SubjectActivity mView;

    private ISubjectRepository.OnSaveSubjectCallback onSaveSubjectCallback;
    private ISubjectRepository.OnDeleteSubjectCallback onDeleteSubjectCallback;
    private ISubjectRepository.OnGetAllSubjectsCallback onGetAllSubjectsCallback;
    private ISubjectRepository.OnGetSubjectByIdCallback onGetSubjectByIdCallback;

    private ISubjectRepository mSubjectRepository;

    public SubjectPresenter(SubjectActivity mView) {
        this.mView = mView;
        mSubjectRepository = new SubjectRepository();
    }

    @Override public void addSubject(Subject subject) {
        mSubjectRepository.addSubject(subject, onSaveSubjectCallback);
    }

    @Override public void deleteSubjectById(String id) {
        mSubjectRepository.deleteSubjectById(id, onDeleteSubjectCallback);
    }

    @Override public void deleteSubjectByPosition(int position) {
        mSubjectRepository.deleteSubjectByPosition(position, onDeleteSubjectCallback);
    }

    @Override public void getAllSubjects() {
        mSubjectRepository.getAllSubjects(onGetAllSubjectsCallback);
    }

    @Override public void getSubjectsById(String id) {
        mSubjectRepository.getSubjectsById(id, onGetSubjectByIdCallback);
    }

    @Override public void subscribeCallbacks() {
        onSaveSubjectCallback = new ISubjectRepository.OnSaveSubjectCallback() {
            @Override public void onSuccess() {
                mView.showMessage("Added");
            }

            @Override public void onError(String message) {
                mView.showMessage(message);
            }
        };

        onDeleteSubjectCallback = new ISubjectRepository.OnDeleteSubjectCallback() {
            @Override public void onSuccess() {
                mView.showMessage("Deleted");
            }

            @Override public void onError(String message) {
                mView.showMessage(message);
            }
        };

        onGetSubjectByIdCallback = new ISubjectRepository.OnGetSubjectByIdCallback() {
            @Override public void onSuccess(Subject subject) {

            }

            @Override public void onError(String message) {

            }
        };

        onGetAllSubjectsCallback = new ISubjectRepository.OnGetAllSubjectsCallback() {
            @Override public void onSuccess(RealmResults<Subject> subjects) {

            }

            @Override public void onError(String message) {
                mView.showMessage(message);
            }
        };
    }

    @Override public void unSubscribeCallbacks() {
        onSaveSubjectCallback = null;
        onDeleteSubjectCallback = null;
        onGetSubjectByIdCallback = null;
        onGetAllSubjectsCallback = null;
    }
}
