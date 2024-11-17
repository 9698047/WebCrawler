public class main {
    public static void main(String[] args) {

        String seedURL = "https://www.wikipedia.org";
        WebCrawler crawler = new WebCrawler();
        crawler.crawl(seedURL);
    }
}

