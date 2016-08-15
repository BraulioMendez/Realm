package com.brauliomendez.realm.realm.table;

/**
 * @author Braulio Méndez Jiménez
 * @since 14/08/16
 */
public interface IRealmTable {

    String ID = "id";

    interface Subject{
        String TEACHER = "teacher";
        String ASSISTANT = "assistant";
        String HOUR = "hour";
        String CLASSROOM = "classrom";
    }
}
