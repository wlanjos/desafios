package idwall.desafio.crawlers;

public class SubredditThread {

    private String upvotes;
    private String subreddit;
    private String tituloThread;
    private String linkComentarios;
    private String linkThread;

    public String getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(String upvotes) {
        this.upvotes = upvotes;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getTituloThread() {
        return tituloThread;
    }

    public void setTituloThread(String tituloThread) {
        this.tituloThread = tituloThread;
    }

    public String getLinkComentarios() {
        return linkComentarios;
    }

    public void setLinkComentarios(String linkComentarios) {
        this.linkComentarios = linkComentarios;
    }

    public String getLinkThread() {
        return linkThread;
    }

    public void setLinkThread(String linkThread) {
        this.linkThread = linkThread;
    }


    public String toString() {
        return " **********  Título: " + this.getTituloThread() +
                "\n ********** VOTOS: " + this.getUpvotes() +
                "\n ********** Link Comentários: " + this.getLinkComentarios() +
                "\n ********** Link do POST: " + this.getLinkThread() +
                "\n\n";

    }
}
