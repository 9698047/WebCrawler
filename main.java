public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //"https://www.wikipedia.org"
        System.out.println("url che deve seguire il crawler");
        String seedURL = sc.nextLine();
        WebCrawler crawler = new WebCrawler();
        crawler.crawl(seedURL);
    }
}

