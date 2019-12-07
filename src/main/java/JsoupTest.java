import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupTest {
    public static void main(String[] args) throws IOException {
        String linuxTest = "linuxTest";
        String winTest = "winTest";
        String winTest2 = "winTest2";
        String url = "https://ru.wikipedia.org/wiki/%D0%A0%D0%B0%D0%B7%D1%80%D0%B5%D1%88%D0%B5%D0%BD%D0%B8%D0%B5_(%D0%BA%D0%BE%D0%BC%D0%BF%D1%8C%D1%8E%D1%82%D0%B5%D1%80%D0%BD%D0%B0%D1%8F_%D0%B3%D1%80%D0%B0%D1%84%D0%B8%D0%BA%D0%B0)";
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla")
                .get();
        String title = doc.title();
        System.out.println(title);
        Elements wikiSortTables = doc.getElementsByTag("table").select("table[class=\"wikitable sortable\"]");
        for (int i = 0; i < 2; i++) {
            System.out.println("\n" + wikiSortTables.get(i).className());
            Elements rows = wikiSortTables.get(i).select("tr");
            for (Element row : rows) {
                Elements words = row.getElementsByTag("td");
                for (int j = 0; j < words.size(); j++) {
                    if (j % 4 == 0) {
                        System.out.println();
                        System.out.println(words.get(j).text());
                    } else  {
                        System.out.printf("%-24s", words.get(j).text());
                    }
                }
                System.out.println();
            }
            System.out.println("-----------------------------------------------------------------------");
        }
    }
}
