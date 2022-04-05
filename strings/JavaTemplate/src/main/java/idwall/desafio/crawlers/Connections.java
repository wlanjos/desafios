package idwall.desafio.crawlers;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Connections {

    private List<Subreddit> subreddits = new ArrayList<>();
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private static final String URL = "https://old.reddit.com/r/";
    private static final Integer STATUS_OK = 200;
    private static final int BOMBADA = 5000 ;
    private Document htmlDocument;
    private Subreddit subreddit;

        public void getSubreddit(String categoria) {
        try {
            Connection connection = Jsoup.connect(URL.concat(categoria)).userAgent(USER_AGENT);
            Document doc = connection.get();
            this.htmlDocument = doc;
            Connection.Response response = connection.response();
            if (response.statusCode() != STATUS_OK || !response.contentType().contains("text/html")) {
                System.out.println("Ocorreu um error ao acessar categoria: " + categoria);
            } else {
                processaResponse();
            }
            subreddits.add(subreddit);

        } catch (IOException e) {
            System.out.println("Ocorreu um error ao acessar categoria: " + categoria);
            System.out.println("Verifique a categoria informada e tente novamente");

        }
    }

    private void processaResponse() {
        subreddit = new Subreddit();
        Element div = htmlDocument.getElementById("siteTable");
        if (div != null) {
            Elements children = div.children();

            for (Element node : children) {
                SubredditThread thread = new SubredditThread();
                thread.setTituloThread(processTituloThread(node));
                thread.setUpvotes(node.attr("data-score"));
                thread.setLinkComentarios(processarLinkComentarios(node, node.attr("data-permalink")));
                thread.setLinkThread(processarLinkThread(node.attr("data-url"), thread.getLinkComentarios()));

                if (subreddit.getTitulo() == null)
                    subreddit.setTitulo(node.attr("data-subreddit"));
                adicionarThread(thread);
            }
        }else{
            System.out.println("Não foi possivel identificar elementos da pagina");
        }
    }

    private void adicionarThread(SubredditThread thread) {
        if(!thread.getTituloThread().isEmpty() && !thread.getUpvotes().isEmpty()
                && !thread.getLinkComentarios().isEmpty() && !thread.getLinkThread().isEmpty())
            if(isThreadBombada(thread))
                subreddit.addThread(thread);

    }


    private String processarLinkThread(String attr, String linkComentarios) {
        if (attr.startsWith("/r/"))
            return linkComentarios;

        return attr;
    }


    private String processarLinkComentarios(Element node, String attr) {
        Elements titulo = node.select("a");
        for (Element e : titulo) {
            if (e.attr("data-event-action").contains("comments")) {
                return e.attr("href");
            }
        }
        return "";

    }

    private String processTituloThread(Element node) {
        Elements titulo = node.select("a");
        for (Element e : titulo) {
            if (e.toString().contains("title"))
                return e.text();
        }
        return "";
    }

    private boolean isThreadBombada(SubredditThread thread) {
        return Integer.parseInt(thread.getUpvotes()) >= BOMBADA;
    }
    public List<Subreddit> getSubreddits() {
        return subreddits;
    }


}