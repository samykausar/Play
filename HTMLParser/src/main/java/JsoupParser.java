import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class JsoupParser {

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.parse(new File("Spring Framework Reference Documentation.htm"), "iso-8859-1");
		Elements els = doc.getElementsByClass("part");
		for (Element element : els) {
			File file = new File(element.attr("title")+".html");
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			fw.write(element.toString());
			System.out.println(element.attr("title"));
		}
	}
}
