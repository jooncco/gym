package leetcode.java.p1472;
// https://leetcode.com/problems/design-browser-history/

public class BrowserHistory {
    Page currentPage;

    public BrowserHistory(String homepage) {
        currentPage = new Page(homepage);
    }

    public void visit(String url) {
        currentPage.setNext(new Page(url));
        currentPage.getNext().setPrev(currentPage);
        currentPage = currentPage.getNext();
    }

    public String back(int steps) {
        while (currentPage.prev != null && steps-- > 0) {
            currentPage = currentPage.prev;
        }
        return currentPage.getUrl();
    }

    public String forward(int steps) {
        while (currentPage.next != null && steps-- > 0) {
            currentPage = currentPage.next;
        }
        return currentPage.getUrl();
    }

    private static class Page {
        String url;
        Page prev, next;

        Page(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Page getPrev() {
            return prev;
        }

        public void setPrev(Page prev) {
            this.prev = prev;
        }

        public Page getNext() {
            return next;
        }

        public void setNext(Page next) {
            this.next = next;
        }
    }
}