package idwall.desafio.crawlers;

import java.util.ArrayList;
import java.util.List;

public class Subreddit {

    private List<SubredditThread> threads;
    private String titulo;

    public Subreddit(String titulo) {
        this.titulo = titulo;
        threads = new ArrayList<SubredditThread>();
    }

    public Subreddit() {
        threads = new ArrayList<SubredditThread>();
    }

    public void addThread(SubredditThread thread) {
        threads.add(thread);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<SubredditThread> getThreads() {
        return threads;
    }

}
