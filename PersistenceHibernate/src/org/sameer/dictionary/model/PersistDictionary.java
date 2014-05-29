package org.sameer.dictionary.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sameer.dictionary.DictionaryList;
import org.sameer.dictionary.XmlToJava;
import org.sameer.dictionary.Dictionary;

public class PersistDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        SessionFactory sessFact = HibernateUtil.getSessionFactory();
        Session session = sessFact.getCurrentSession();
        org.hibernate.Transaction tr = session.beginTransaction();
       	DictionaryList dictList =XmlToJava.getDictionaryList();
       	ArrayList<Dictionary> dictionaries = dictList.getDictionaries();

		Collections.sort(dictionaries, new Comparator<Dictionary>() {
	        
	        public int compare(Dictionary  dict1, Dictionary  dict2)
	        {

	            return  dict1.getWord().compareToIgnoreCase(dict2.getWord());
	        }
	    });
		int i=1;
		
		for (Dictionary dictionary : dictionaries) {
		DictionaryH dictH = new DictionaryH();
		dictH.setWord(dictionary.getWord());
		dictH.setMeaning(dictionary.getMeaning());
		session.save(dictH);
		System.out.println("Saved " +i+++ "th entry");
		}
        
        tr.commit();
        System.out.println("Successfully inserted");
        sessFact.close();
	}

}
