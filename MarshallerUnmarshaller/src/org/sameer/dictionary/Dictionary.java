package org.sameer.dictionary;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
//Below statement means that class "DictionaryList.java" is the root-element of our example 

@XmlRootElement(namespace = "org.sameer.dictionary.DictionaryList")  
//defining order of the element
@XmlType(propOrder = {"word","meaning"})
public class Dictionary {
	
	private String word;
	private String meaning;
	
	public Dictionary() {
		super();
	}
	
	public Dictionary(String word, String meaning) {
		super();
		this.word = word;
		this.meaning = meaning;
	}
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	public String getMeaning() {
		return meaning;
	}
	
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	

}
