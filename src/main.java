import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://varzesh3.com").get();

        Elements div = doc.select("#67");
        for(Element e:div){
            String s=e.wholeText().replaceAll("( )", " ");
            s=s.replaceAll("(  )+", "");
            System.out.println(s);
        }

    }
}
