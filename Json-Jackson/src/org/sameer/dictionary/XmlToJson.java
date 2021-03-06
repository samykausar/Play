package org.sameer.dictionary;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.lang3.text.WordUtils;
import org.codehaus.jackson.map.ObjectMapper;

public class XmlToJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DictionaryList dictList =XmlToJava.getDictionaryList();
       	ArrayList<Dictionary> dictionaries = dictList.getDictionaries();
       	for (Dictionary dictionary : dictionaries) {
			dictionary.setWord(WordUtils.capitalize(dictionary.getWord()));
		}
		Collections.sort(dictionaries, new Comparator<Dictionary>() {
	        
	        public int compare(Dictionary  dict1, Dictionary  dict2)
	        {

	            return  dict1.getWord().compareToIgnoreCase(dict2.getWord());
	        }
	    });
		HashMap<String, ArrayList<String>> dictionaryMap = new HashMap<String, ArrayList<String>>();
		ObjectMapper mapper = new ObjectMapper();


			String uniqueWord = "";
			ArrayList<String> meanings = new ArrayList<String>();
			int i=0;
			for (Dictionary dictionary : dictionaries) {
				i++;
				if(dictionary.getWord().toLowerCase().contains(uniqueWord.toLowerCase()+" (")){
				meanings.add(dictionary.getMeaning());
				}
				else
				{
					uniqueWord = dictionary.getWord();
					meanings.add(dictionary.getMeaning());
					meanings = new ArrayList<String>();
				}
				dictionaryMap.put(uniqueWord, meanings);	
			}
			

			System.out.println(i+"-"+dictionaryMap.size()+"="+(i-dictionaryMap.size()));

		try {
	 
			// write JSON to a file
			Map<String, ArrayList<String>> dictionaryMapSort = new TreeMap<String, ArrayList<String>>(dictionaryMap);
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("Output\\DictionaryUnique.json"), dictionaryMapSort);
	 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
