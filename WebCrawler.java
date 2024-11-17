import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawler {
    private static final int MAX_DEPTH = 3;
    private HashSet<String> visitedUrls;

    public WebCrawler() {
        visitedUrls = new HashSet<>();
    }

    public void crawl(String seedURL) {
        Queue<UrlDepthPair> queue = new LinkedList<>();
        queue.add(new UrlDepthPair(seedURL, 0));
        visitedUrls.add(seedURL);

        while (!queue.isEmpty()) {
            UrlDepthPair current = queue.poll();
            String currentUrl = current.getUrl();
            int currentDepth = current.getDepth();

            if (currentDepth > MAX_DEPTH) {
                return;
            }

            try {
                Document document = Jsoup.connect(currentUrl).get();
                System.out.println("URL: " + currentUrl);

                // Trova tutti i collegamenti nella pagina
                Elements links = document.select("a[href]");
                for (Element link : links) {
                    String absUrl = link.absUrl("href"); // URL assoluto
                    if (!visitedUrls.contains(absUrl)) {
                        visitedUrls.add(absUrl);
                        queue.add(new UrlDepthPair(absUrl, currentDepth + 1));
                    }
                }
            } catch (IOException e) {
                System.err.println("Errore durante l'accesso a " + currentUrl + ": " + e.getMessage());
            }
        }
}
}
