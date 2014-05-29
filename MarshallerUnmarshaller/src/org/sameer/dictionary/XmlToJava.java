package org.sameer.dictionary;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class XmlToJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			// create JAXB context and initializing Marshaller
			JAXBContext jaxbContext = JAXBContext.newInstance(DictionaryList.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			// specify the location and name of xml file to be read  
			File XMLfile = new File("Input\\DictionaryWebster.xml");
			
			 // this will create Java object - country from the XML file  
			DictionaryList dictList = (DictionaryList) jaxbUnmarshaller.unmarshal(XMLfile);
			ArrayList<Dictionary> dictionaries = dictList.getDictionaries();
			int i=0;
			int size=0;
			
			Collections.sort(dictionaries, new Comparator<Dictionary>() {
		        
		        public int compare(Dictionary  dict1, Dictionary  dict2)
		        {

		            return  dict1.getWord().compareToIgnoreCase(dict2.getWord());
		        }
		    });
			for (Dictionary dictionary : dictionaries) {
				System.out.println(i++);
				System.out.println("Word: "+dictionary.getWord());
				System.out.println("Meaning: "+dictionary.getMeaning());
				size = dictionary.getWord().length() > size ? dictionary.getWord().length() : size;
			}
		System.out.println(size);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
	}
	
	
	public static DictionaryList getDictionaryList() {
		// TODO Auto-generated method stub
		try{
			// create JAXB context and initializing Marshaller
			JAXBContext jaxbContext = JAXBContext.newInstance(DictionaryList.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			// specify the location and name of xml file to be read  
			File XMLfile = new File("Input\\DictionaryWebster.xml");
			
			 // this will create Java object - country from the XML file  
			DictionaryList dictList = (DictionaryList) jaxbUnmarshaller.unmarshal(XMLfile);
					
			return dictList;

		}
		catch(JAXBException e){
			e.printStackTrace();
		}
		return null;
	}

}
