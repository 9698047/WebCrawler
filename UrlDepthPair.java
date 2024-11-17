public class UrlDepthPair {
    private final String url;
    private final int depth;

    public UrlDepthPair(String url, int depth) {
        this.url = url;
        this.depth = depth;
    }

    public String getUrl() {
        return url;
    }

    public int getDepth() {
        return depth;
    }
}
