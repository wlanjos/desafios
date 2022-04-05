package idwall.desafio.crawlers;

import java.util.List;
import java.util.Objects;

public class Crawales {

     Connections connections = new Connections();
     String[] listSubeddit= new String[0];

    public void processarSubreddits(String subreddit){

        //verifica se subreddt está branco ou nulo
        if (subreddit.isEmpty()|| Objects.isNull(subreddit)){
            System.out.println("Erro ao receber subreddits");
        }else {
            //verificar se apenas uma categoria
            if (!subreddit.contains(";")){
                connections.getSubreddit(subreddit);
            }else {
                listSubeddit = subreddit.split(";");

                for (String cat :  listSubeddit) {
                    connections.getSubreddit(cat.trim());
                }
            }
        }



    }
    public void exibirCaptura() {
        for(Subreddit subreddit : connections.getSubreddits()) {
            System.out.println(subreddit.getTitulo());
            for(SubredditThread thread : subreddit.getThreads())
                System.out.print(thread.toString());
        }
    }
}
