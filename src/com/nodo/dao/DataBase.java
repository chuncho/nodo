package com.nodo.dao;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class DataBase {

    final Morphia morphia = new Morphia();
    final Datastore ds = morphia.createDatastore(new MongoClient(), "dbnodo");
}
